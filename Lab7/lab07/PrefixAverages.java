package lab07;

public class PrefixAverages {

	public static double[] prefixAverage1 (double[] x) {
		int n = x.length;
		double[] a = new double[n];
		for (int j = 0; j < n; j++) {
			double total = 0;
			for (int i = 0; i <= j; i++)
				total += x[i];
			a[j] = total / (j + 1);

		}
		return a;
	}
	
	public static double[] prefixAverage2(double[] x) {
		int n = x.length;
		double[] a = new double[n];
		double total = 0;
		for (int j = 0; j < n; j++) {
			total += x[j];
			a[j] = total / (j + 1);
		}
		return a;
	}

	public static void main(String[] args) {
		
		for(int n = 10; n <= 100000; n *= 10)
		{
			double[] test1 = new double[n];
			fill(test1);
			long startTime = System.nanoTime();
			prefixAverage1(test1);
			long estTime = System.nanoTime() - startTime;
			System.out.println("n = " + n + "   alg1 time: " + estTime + " ns");
			System.out.println();
		}
		
		for(int n = 10; n <= 100000; n *= 10)
		{
			double[] test2 = new double[n];
			fill(test2);
			long startTime = System.nanoTime();
			prefixAverage2(test2);
			long estTime = System.nanoTime() - startTime;
			System.out.println("n = " + n + "   alg2 time: " + estTime + " ns");
			System.out.println();
		}
		System.out.println("These results indicate that the Big O of the first algorithm is O(n * n), and the second algorithm is O(n)");
		
		

	}
	
	public static double[] fill(double[] x)
	{
		int n = x.length;
		for(int i = 0; i < n; i++)
		{
			x[i] = (int)(100 * Math.random());
		}
		return x;
		
	}

}
