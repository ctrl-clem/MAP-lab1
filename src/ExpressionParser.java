import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ExpressionParser {

    public static boolean isValidExpression(String expression) {
        return expression.matches(
                "^\\s*([-+*/]?\\d*\\.?\\d+[-+*/]?\\d*\\.?\\d*i)\\s*([+\\-*/])\\s*([-+]?\\d*\\.?\\d+[-+/*]?\\d*\\.?\\d*i)\\s*(\\s*([+\\-*/])\\s*[-+]?\\d*\\.?\\d+[-+/*]?\\d*\\.?\\d*i)*\\s*$");
    }

    public static ComplexNumber parseAndCreateResult(String expression) {
        if (!isValidExpression(expression)) {
            throw new IllegalArgumentException("Expresia nu este validă.");
        }

        List<String> tokens = tokenizeExpression(expression);

        List<ComplexNumber> complexNumbers = new ArrayList<>();
        Queue<Operation> operations = new LinkedList<>();

        for (int i = 0; i < tokens.size(); i++) {
            if (i % 2 == 0) {
                complexNumbers.add(parseComplex(tokens.get(i)));
            } else {
                operations.add(parseOperator(tokens.get(i)));
            }
        }
        ComplexNumber result = complexNumbers.getFirst();
        for(int i=1; i<complexNumbers.size() && !operations.isEmpty(); i++) {
            ComplexNumber second = complexNumbers.get(i);
            Operation operation = operations.poll();

            ComplexExpression miniExpression = ExpressionFactory.getInstance().createExpression(operation, new ComplexNumber[]{result, second});
            result = miniExpression.execute();
        }

        return result;

    }

    private static ComplexNumber parseComplex(String complexStr) {
        complexStr = complexStr.replace(" ", "");

        String realPart = "0";
        String imagPart = "0";

        if (complexStr.contains("i")) {
            String[] parts = complexStr.replace("i", "").split("[+-]");
            realPart = parts[0].trim();
            imagPart = parts.length > 1 ? parts[1].trim() : "1";
        } else {
            realPart = complexStr;
        }

        double real = Double.parseDouble(realPart);
        double imag = Double.parseDouble(imagPart);

        return new ComplexNumber(real, imag);
    }

    private static Operation parseOperator(String operator) {
        switch (operator) {
            case "+":
                return Operation.ADDITION;
            case "-":
                return Operation.SUBTRACTION;
            case "*":
                return Operation.MULTIPLICATION;
            case "/":
                return Operation.DIVISION;
            default:
                throw new IllegalArgumentException("Operator necunoscut: " + operator);
        }
    }

    // Tokenize expression into a list of terms and operators
    private static List<String> tokenizeExpression(String expression) {
        List<String> tokens = new ArrayList<>();
        String[] parts = expression.split("\\s");

        for (String part : parts) {
            tokens.add(part);
        }

        return tokens;
    }
}