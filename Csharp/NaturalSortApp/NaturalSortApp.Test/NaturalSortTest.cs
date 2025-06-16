namespace NaturalSortApp.Test
{
    [TestFixture]
    public class NaturalSortTest
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void Sort_GivenNumbersOnly_ReturnsCorrectOutput()
        {
            int[] numbers = { 3, 8, 1, 6, 2 };
            var expected = new int[] { 1, 2, 3, 6, 8 };

            var actual = NaturalSort.OrderByNatural(numbers, n => n.ToString()).ToList();

            Assert.That(actual, Is.EqualTo(expected), "Natural sort did not return the expected order for numbers only.");
        }

        [Test]
        public void Sort_GivenNullSource_ThrowsArgumentNullException()
        {
            List<string> source = null;

            Assert.Throws<ArgumentNullException>(() => NaturalSort.OrderByNatural(source, s => s).ToList(),
                "Calling OrderByNatural with a null source should throw ArgumentNullException.");
        }

        [TestCase(new[] { "pe10", "fe3.8", "re8", "fail0" }, new[] { "fail0", "fe3.8", "pe10", "re8" })]
        [TestCase(new[] { "SWT301", "SWP391", "SWR302", "PRN212" }, new[] { "PRN212", "SWP391", "SWR302", "SWT301" })]
        public void Sort_GivenStringsWithNumbers_ReturnsCorrectOutput(string[] strings, string[] expected)
        {
            var actual = NaturalSort.OrderByNatural(strings, s => s).ToList();

            Assert.That(actual, Is.EqualTo(expected), "Natural sort did not return the expected order for strings with numbers.");
        }

        [TestCaseSource(nameof(GetTestCasesFromCsv))]
        public void Sort_GivenStringsWithNumbersFromCsv_ReturnsCorrectOutput(string[] strings, string[] expected)
        {
            var actual = NaturalSort.OrderByNatural(strings, s => s).ToList();
            Assert.That(actual, Is.EqualTo(expected), "Natural sort did not return the expected order for strings with numbers.");
        }

        public static IEnumerable<TestCaseData> GetTestCasesFromCsv()
        {
            var path = Path.Combine(TestContext.CurrentContext.TestDirectory, "NaturalSortTestData.csv");
            foreach (var line in File.ReadLines(path).Skip(1))
            {
                if (string.IsNullOrWhiteSpace(line)) continue;

                var parts = line.Split("\",\"");

                if (parts.Length < 2) continue;

                var input = parts[0].Trim('"').Split(',');
                var expected = parts[1].Trim('"').Split(',');

                yield return new TestCaseData(input, expected)
                    .SetName($"Sort_GivenStringsWithNumbersFromCsv_ReturnsCorrectOutput({input}, {expected})");
            }
        }
    }
}
