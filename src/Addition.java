public class Addition extends ComplexExpression {
    public Addition(ComplexNumber[] args) {
        super(Operation.ADDITION, args);
    }

    @Override
    public ComplexNumber executeOneOperation(ComplexNumber a, ComplexNumber b) {
        return a.add(b);
    }
}
