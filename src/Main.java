public class Main {
    public static void main(String[] args) {
        try {
            String expression = "1+2i + 3+2i * 1+i";
            ComplexNumber result = ExpressionParser.parseAndCreateResult(expression);
            System.out.println("Rezultatul expresiei este: " + result.toString());
        } catch (Exception e) {
            System.out.println("Eroare: " + e.getMessage());
        }
    }
}
