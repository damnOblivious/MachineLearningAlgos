import java.util.*;
public class LinearInterpolation implements InterpolationMethod {

	double[] x; double[] y;

	@Override
	public void init(double a, double b, int n, double[] y) {
		this.y = y;
		x = new double[n + 1];
		double h = (b - a) / n;
		for (int i = 0; i < n + 1; ++i) x[i] = a + i * h;
	}

	/**
     *
	 * @param y
     * @param x
     *
	 */
	public void init(final double[] x, double[] y) {
		if (x.length != y.length || x.length == 0) return;
		int n = x.length;
		List<Integer> indices = new ArrayList<Integer>(n);
		for (int i = 0; i < n; i++) indices.add(i);
		Comparator<Integer> comparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer i, Integer j) {
				if (x[i] - x[j] < 0) return -1;
				if (x[i] - x[j] > 0) return 1;
				else return 0;
			}
		};

		Collections.sort(indices, comparator);

        this.y = new double[n]; this.x = new double[n];

		for (int i = 0; i < n; i++) {
			int index = indices.get(i);
            this.y[i] = y[index]; this.x[i] = x[index];
		}
	}

	@Override
	public double evaluate(double z) {
        int xl, xf;
        xl = 1; xf = 0;
		for (int i = 0; i < x.length - 1; ++i) {
			if (x[i] < z) {
				xl = i + 1; xf = i;
			}
            else if (x[i] > z) break;
		}
        double yl, yf, m, diff, ans;
        yl = y[xl]; yf = y[xf];
		m = (yl - yf) / (x[xl] - x[xf]);
		diff = z - x[xf];
        ans = diff * m + yf;
		return ans;
	}
}
