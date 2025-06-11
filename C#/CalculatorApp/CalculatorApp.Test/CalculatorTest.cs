namespace CalculatorApp.Test
{
    [TestFixture]
    public class CalculatorTest
    {
        private Calculator _calculator;

        [SetUp]
        public void Setup()
        {
            _calculator = new Calculator();
        }

        // TDD: Test cases for Add method
        [Test]
        public void Add_TwoPositiveNumbers_ReturnsCorrectSum()
        {
            // Arrange
            int a = 5;
            int b = 3;
            int expected = 8;

            // Act
            int result = _calculator.Add(a, b);

            // Assert
            Assert.That(result, Is.EqualTo(expected));
        }

        [Test]
        public void Add_NegativeAndPositiveNumber_ReturnsCorrectSum()
        {
            // Arrange
            int a = -2;
            int b = 7;
            int expected = 5;

            // Act
            int result = _calculator.Add(a, b);

            // Assert
            Assert.That(result, Is.EqualTo(expected));
        }

        // DDT: Data-driven test for Add method
        [TestCase(1, 1, 2)]
        [TestCase(-1, -1, -2)]
        [TestCase(0, 5, 5)]
        public void Add_VariousInputs_ReturnsCorrectSum(int a, int b, int expected)
        {
            // Act
            int result = _calculator.Add(a, b);

            // Assert
            Assert.That(result, Is.EqualTo(expected));
        }

        // TDD: Test cases for Divide method
        [Test]
        public void Divide_ValidNumbers_ReturnsCorrectQuotient()
        {
            // Arrange
            double a = 10;
            double b = 2;
            double expected = 5.0;

            // Act
            double result = _calculator.Divide(a, b);

            // Assert
            Assert.That(result, Is.EqualTo(expected));
        }

        [Test]
        public void Divide_ByZero_ThrowsDivideByZeroException()
        {
            // Arrange
            double a = 10;
            double b = 0;

            // Act & Assert
            Assert.Throws<DivideByZeroException>(() => _calculator.Divide(a, b));
        }

        // DDT: Data-driven test for Divide method
        [TestCase(10, 5, 2.0)]
        [TestCase(8, 4, 2.0)]
        [TestCase(-6, 2, -3.0)]
        public void Divide_VariousInputs_ReturnsCorrectQuotient(double a, double b, double expected)
        {
            // Act
            double result = _calculator.Divide(a, b);

            // Assert
            Assert.That(result, Is.EqualTo(expected));
        }
    }
}
