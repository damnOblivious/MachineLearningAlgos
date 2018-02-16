/**
 * This is the interface for all interpolation methods
 *
 */

public interface InterpolationMethod {

	/**
	 * Initialization of the interpolation method with equidistant support points
     * It always applies and is required by init ():
     * a < b
	 * n > 0
	 * Length of y = n+1
	 * @param a Smallest support site
	 * @param b Largest support site
	 * @param n Number of equidistant intervals between a and b. Thus, the interpolation method has n + 1 support points
	 */
	public void init(double a, double b, int n, double[] y);

	/**
	 * Wertet das Interpolationsverfahren an einer Stelle z aus
	 */
	public double evaluate(double z);
}
