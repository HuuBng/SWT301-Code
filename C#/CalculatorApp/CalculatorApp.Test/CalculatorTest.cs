namespace CalculatorApp.Test
{
    [TestFixture]
    public class CalculatorTest
    {

        [SetUp]
        public void Setup()
        {
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
            int result = Calculator.Add(a, b);

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
            int result = Calculator.Add(a, b);

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
            int result = Calculator.Add(a, b);

            // Assert
            Assert.That(result, Is.EqualTo(expected));
        }

        [Test, TestCaseSource(nameof(GetTestData))]
        public void Add_FromCsv_ReturnsCorrectSum(int a, int b, int expectedAdd, double expectedDivide)
        {
            int result = Calculator.Add(a, b);
            Assert.That(result, Is.EqualTo(expectedAdd));
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
            double result = Calculator.Divide(a, b);

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
            Assert.Throws<DivideByZeroException>(() => Calculator.Divide(a, b));
        }

        // DDT: Data-driven test for Divide method
        [TestCase(10, 5, 2.0)]
        [TestCase(8, 4, 2.0)]
        [TestCase(-6, 2, -3.0)]
        public void Divide_VariousInputs_ReturnsCorrectQuotient(double a, double b, double expected)
        {
            // Act
            double result = Calculator.Divide(a, b);

            // Assert
            Assert.That(result, Is.EqualTo(expected));
        }

        // DDT: Data-driven test for Divide method using external data source
        [Test, TestCaseSource(nameof(GetTestData))]
        public void Divide_FromCsv_ReturnsCorrectQuotient(int a, int b, int expectedAdd, double expectedDivide)
        {
            double result = Calculator.Divide(a, b);
            Assert.That(result, Is.EqualTo(expectedDivide));
        }

        private static IEnumerable<object[]> GetTestData()
        {
            string csvPath = Path.Combine(TestContext.CurrentContext.TestDirectory, "TestData.csv");
            return File.ReadAllLines(csvPath)
                .Skip(1) // Skip header
                .Select(line => line.Split(','))
                .Select(values => new object[]
                {
                    int.Parse(values[0]), // a
                    int.Parse(values[1]), // b
                    int.Parse(values[2]), // expectedAdd
                    double.Parse(values[3]) // expectedDivide
                });
        }
    }
}
