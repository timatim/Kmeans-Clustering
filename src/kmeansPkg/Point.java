package personPkg;

public class Point {
	protected int[] _coordinate;
	
	public int[] getCoordinate() 	{ return _coordinate; }
	
	public void setCoordinate(int[] coordinate)	{ _coordinate = coordinate; }
	
	public Point(int[] coordinate) {
		_coordinate = coordinate;
	}
	
	/**
	 * creates a random point in the range (min, max) in the given dimension
	 * @param min
	 * @param max
	 * @param dim
	 */
	public Point(int min, int max, int dim) {
		int[] coord = new int[dim];
		for (int i = 0; i < dim; i++) {
			coord[i] = (int)(Math.random()*(max-min)+min);
		}
	}
	
}
