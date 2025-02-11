public class Multiplication extends ComplexExpression{
    public Multiplication(ComplexNumber[] args) {
        super(Operation.MULTIPLICATION, args);
    }

    @Override
    public ComplexNumber executeOneOperation(ComplexNumber a, ComplexNumber b) {
        return a.multiply(b);
    }
}
