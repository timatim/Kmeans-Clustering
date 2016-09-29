package kmeansPkg;
import java.util.Arrays;

public class Centroid extends Point {
	
	public Centroid(double[] coords) {
		super(coords);
	}
	
	/**
	 * creates a random centroid in the range (min, max) in the given dimension
	 * @param min
	 * @param max
	 * @param dim
	 */
	public Centroid(int min, int max, int dim) {
		super(min, max, dim);
	}
	
}
