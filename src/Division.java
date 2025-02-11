public class Division extends ComplexExpression{
    public Division(ComplexNumber[] args) {
        super(Operation.DIVISION, args);
    }

    @Override
    public ComplexNumber executeOneOperation(ComplexNumber a, ComplexNumber b) {
        return a.divide(b);
    }
}
