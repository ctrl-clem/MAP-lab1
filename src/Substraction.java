public class Substraction extends ComplexExpression{

    public Substraction(ComplexNumber[] args) {
        super(Operation.SUBTRACTION, args);
    }

    @Override
    public ComplexNumber executeOneOperation(ComplexNumber a, ComplexNumber b) {
        return a.subtract(b);
    }
}
