public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }
    public double getImaginary() {
        return imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(real + other.real, imaginary + other.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(real - other.real, imaginary - other.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        return new ComplexNumber(real * other.real-imaginary*other.imaginary, real * other.imaginary + imaginary * other.real);
    }

    public ComplexNumber divide(ComplexNumber other) {
        return new ComplexNumber((real*other.real+imaginary* other.imaginary)/(other.imaginary*other.imaginary+other.real*other.real),
                       (imaginary*other.real-real*other.imaginary)/(other.imaginary*other.imaginary+other.real*other.real));
    }

    public ComplexNumber conjugate(){
        return new ComplexNumber(real, -imaginary);
    }

    public String toString() {
        return this.real + " + " + this.imaginary + "i";
    }
}
