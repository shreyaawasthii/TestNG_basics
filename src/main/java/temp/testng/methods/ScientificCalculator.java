package temp.testng.methods;


    public class ScientificCalculator {

        public double add(double a, double b) {
            return a + b;
        }

        public double subtract(double a, double b) {
            return a - b;
        }

        public double multiply(double a, double b) {
            return a * b;
        }

        public double divide(double a, double b) {
            if (b == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            return a / b;
        }

        public double squareRoot(double a) {
            if (a < 0) {
                throw new IllegalArgumentException("Cannot calculate square root of a negative number");
            }
            return Math.sqrt(a);
        }

        public double power(double base, double exponent) {
            return Math.pow(base, exponent);
        }

        public double sin(double angleInDegrees) {
            return Math.sin(Math.toRadians(angleInDegrees));
        }

        public double cos(double angleInDegrees) {
            return Math.cos(Math.toRadians(angleInDegrees));
        }

        public double tan(double angleInDegrees) {
            return Math.tan(Math.toRadians(angleInDegrees));
        }
    }

