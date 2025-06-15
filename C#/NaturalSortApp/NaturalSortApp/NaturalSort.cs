namespace NaturalSortApp
{
    public static class NaturalSort
    {
        public static IOrderedEnumerable<T> OrderByNatural<T>(IEnumerable<T> source, Func<T, string> keySelector)
        {
            return source.OrderBy(item => new NaturalStringComparer(keySelector(item)));
        }

        private class NaturalStringComparer : IComparable
        {
            private readonly string _value;

            public NaturalStringComparer(string value)
            {
                _value = value ?? string.Empty; // Handle null values
            }

            public int CompareTo(object obj)
            {
                if (obj == null) return 1;
                if (!(obj is NaturalStringComparer other)) throw new ArgumentException("Object is not a NaturalStringComparer");

                return NaturalCompare(_value, other._value);
            }

            private static int NaturalCompare(string a, string b)
            {
                if (a == b) return 0;
                if (a == null) return -1;
                if (b == null) return 1;

                int i = 0, j = 0;
                while (i < a.Length && j < b.Length)
                {
                    if (char.IsDigit(a[i]) && char.IsDigit(b[j]))
                    {
                        // Extract numbers, including decimals
                        string numA = ExtractNumber(a, ref i);
                        string numB = ExtractNumber(b, ref j);

                        // Try parsing as decimal to handle floating-point numbers
                        if (decimal.TryParse(numA, System.Globalization.NumberStyles.Any, System.Globalization.CultureInfo.InvariantCulture, out decimal decA) &&
                            decimal.TryParse(numB, System.Globalization.NumberStyles.Any, System.Globalization.CultureInfo.InvariantCulture, out decimal decB))
                        {
                            if (decA != decB) return decA.CompareTo(decB);
                        }
                        else
                        {
                            // Fallback to string comparison if parsing fails
                            int lengthCompare = numA.Length.CompareTo(numB.Length);
                            if (lengthCompare != 0) return lengthCompare;
                            return string.Compare(numA, numB, StringComparison.Ordinal);
                        }
                    }
                    else
                    {
                        // Compare characters
                        if (a[i] != b[j]) return a[i].CompareTo(b[j]);
                        i++;
                        j++;
                    }
                }

                return a.Length.CompareTo(b.Length);
            }

            private static string ExtractNumber(string s, ref int index)
            {
                int start = index;
                bool hasDecimal = false;

                // Extract digits, including one decimal point if present
                while (index < s.Length && (char.IsDigit(s[index]) || (s[index] == '.' && !hasDecimal)))
                {
                    if (s[index] == '.') hasDecimal = true;
                    index++;
                }

                return s.Substring(start, index - start);
            }
        }
    }
}
