package kmeansPkg;

public class Point {
	protected double[] _coordinate;
	protected int _id;
	protected boolean _taken = false;
	
	public double[] getCoordinate() 	{ return _coordinate; }
	public int getId()					{ return _id; }
	public boolean getTaken()			{ return _taken; }
	
	public void setCoordinate(double[] coordinate)	{ _coordinate = coordinate; }
	public void setId(int id)						{ _id = id; }
	public void setTaken(boolean taken)				{ _taken = taken; }
	
	public Point() {
		
	}
	
	public Point(double[] coordinate) {
		_coordinate = coordinate;
	}
	
	/**
	 * creates a random point in the range (min, max) in the given dimension
	 * @param min
	 * @param max
	 * @param dim
	 */
	public Point(int min, int max, int dim) {
		double[] coord = new double[dim];
		for (int i = 0; i < dim; i++) {
			coord[i] = (double)((int)(Math.random()*(max-min)+min));
		}
		_coordinate = coord;
	}
	public static double getDistance(Point c1, Point c2) {
		double distance = 0.0;
		double[] coord1 = c1.getCoordinate();
		double[] coord2 = c2.getCoordinate();
		
		int dim = coord1.length;
		if (coord1.length == coord2.length) {
			for (int i = 0; i < dim; i++) {
				distance += Math.pow(coord2[i]-coord1[i], 2);
			}
			distance = Math.sqrt(distance);
		}
		
		return distance;
	}
}
