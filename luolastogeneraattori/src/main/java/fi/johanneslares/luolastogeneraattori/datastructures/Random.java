package fi.johanneslares.luolastogeneraattori.datastructures;

public class Random {
	private static int M = 8267;
	public static double getRandom() {
		double r = System.nanoTime() % M;
		return r/10000;
	}
	
	public static int getRandom(int start, int end) {
		double r = System.nanoTime() % M;
		int space = end-start;
		double n = r/10000;
		double value = space*n;
		return (int)value+start;
	}
	
	public static int getRandom(int start, int end, int mod) {
		double r = System.nanoTime() % mod;
		int space = end-start;
		double n = r/10000;
		double value = space*n;
		return (int)value+start;
	}
}
