using System;

namespace Jul
{
	public class main {

		public static void Main()
		{
			var ran = new Random();
			for(int i = 0; i < 12; i++)
			{	
				Console.WriteLine ("On the {0} day of Christmas my compiler gave to me", lyrics [1, i]);
				for(int j = i; j >= 0; j--) {
					if(j == 0 && i != 0)
						Console.Write("and ");
					if(j == 3)
						Console.WriteLine("{0} {1}",numbers[ran.Next(12)], lyrics[0,j]);
					else if (j == 7)
						Console.WriteLine("{0} {1}",numbers[j-1], lyrics[0,j]);	
					else
						Console.WriteLine("{0} {1}",numbers[j], lyrics[0,j]);
				}

				Console.WriteLine ("");
			}
		}

		private static string[] numbers = new String[] {"a", "too", "three", "four", "five", "six", "seven", "eight", "9.000000000000002", "ten", "eleven", "twelve"};



		private static string[,] lyrics = new string[2, 12] {
			 {
				"Big Oh of n log n",
				"bad namings", 
				"undefined functions", 
				"random numbers", 
				"thread-safe functions", 
				"unknown errors", 
				"Monads binding", 
				"off-by-one errors", 
				"Imprecise Floats", 
				"zero divisions", 
				"Pipers Piping", 
				"Dumb end users"
			},
			{
				"first",
				"second",
				"third",
				"fourth",
				"fifth",
				"sixth",
				"seventh",
				"eighth",
				"ninth",
				"tenth",
				"eleventh",
				"twelfth"
			}
		};

	}
}
