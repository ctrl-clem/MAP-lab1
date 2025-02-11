public class ExpressionFactory {

    private static ExpressionFactory instance = new ExpressionFactory();

    private ExpressionFactory() {}

    public static ExpressionFactory getInstance() {
        return instance;
    }

    public ComplexExpression createExpression(Operation operation, ComplexNumber[] args) {
        if(operation.equals(Operation.ADDITION))
            return new Addition(args);
        else if(operation.equals(Operation.SUBTRACTION))
            return new Substraction(args);
        else if(operation.equals(Operation.MULTIPLICATION))
            return new Multiplication(args);
        else if(operation.equals(Operation.DIVISION))
            return new Division(args);
        else return null;

    }
}
