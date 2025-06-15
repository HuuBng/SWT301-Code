namespace CalculatorApp
{
    public class Calculator
    {
        public static int Add(int a, int b)
        {
            return a + b;
        }

        public static double Divide(double a, double b)
        {
            if (b == 0)
                throw new DivideByZeroException("Cannot divide by zero");
            return a / b;
        }
    }
}