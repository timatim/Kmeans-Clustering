package personPkg;

public class Cluster {
	/* 
	 * centroid: centroid of the cluster
	 * points: points belonging to this cluster
	 */
	protected Centroid _centroid;
	protected Point[] _points;
	protected int _id = 0;
	
	public Point[] getPoints()				{ return _points; }
	public Centroid getCentroid()			{ return _centroid; }
	public int getId()						{ return _id; }
	
	public void setPoints(Point[] points)	{ _points = points; }
	public void setId(int id)				{ _id = id; }
	
	/**
	 * Instantiates a cluster with a random centroid with the given dimension
	 * 
	 * @param dim
	 */
	public Cluster(int id, int dim) {
		double[] coord = new double[dim];
		for (int i = 0; i < dim; i++) {
			coord[i] = (double)(Math.random()*100);
		}
		Centroid c = new Centroid(coord);
		_centroid = c;
		_id = id;
	}
	/** 
	 * Instantiates a cluster with the given centroid instance
	 * 
	 * @param centroid given centroid as center of cluster
	 * @param points list of points belonging to this cluster
	 */
	public Cluster(int id, Centroid centroid) {
		_centroid = centroid;
		_id = id;
		//collectPoints();
	}
	
	/**
	 * Instantiates a cluster using the given list of numbers to create its centroid
	 * 
	 * @param coord coordinate of the centroid to be created of this cluster
	 */
	public Cluster(int id, double[] coords) {
		_centroid = new Centroid(coords);
		_id = id;
		//collectPoints();
	}
	
	/**
	 * Instantiates a cluster problem given the number of clusters desired and the dimension.
	 * Will randomly initialize the centroids.
	 * 
	 * @param k number of clusters desired
	 * @param n dimension of points
	 */
	
	/*
	public Cluster(int k, int n) {
		initializeCentroids(n);
		initializePoints(n);
	}
	*/
	
	/**
	 * Method used to randomly initialize centroids given the number of clusters and dimension
	 * 
	 * @param n dimension of points
	 */
	
	
	/**
	 * Method to obtain the centroid of the cluster
	 */
	public void computeCentroid() {
		int n = _points.length;
		if (n > 0) {
			int dim = _points[0].getCoordinate().length;
			double[] new_coords = new double[dim];
			//sum of all points
			for (int i = 0; i < n; i++) {
				int[] curr_coords = _points[i].getCoordinate();
				for (int j = 0; j < dim; j++) {
					new_coords[j] += curr_coords[j];
				}
			}
			//divide coordinates by number of points
			for (int i = 0; i < dim; i++) {
				new_coords[i] /= n;
			}
			//create new centroid with coordinates
			_centroid = new Centroid(new_coords);
		}
	}
	
	/**
	 * Computes the distance between two given points
	 * @param p1 
	 * @param p2
	 * @return distance between p1 and p2
	 */
	public static double getDistance(Point p1, Point p2) {
		double distance = 0;
		int [] coord1 = p1.getCoordinate();
		int [] coord2 = p2.getCoordinate();
		for (int i = 0; i < coord1.length; i++) {
			distance += Math.pow(coord2[i]-coord1[i], 2);
		}
		return Math.sqrt(distance);
	}
	
}
