package kmeansPkg;

import java.util.ArrayList;

public class Cluster {
	/* 
	 * centroid: centroid of the cluster
	 * points: points belonging to this cluster
	 */
	protected Centroid _centroid;
	protected ArrayList<Point> _points;
	protected int _id = 0;
	
	public ArrayList<Point> getPoints()				{ return _points; }
	public Centroid getCentroid()					{ return _centroid; }
	public int getId()								{ return _id; }
	
	public void setPoints(ArrayList<Point> points)	{ _points = points; }
	public void setId(int id)						{ _id = id; }
	
	/**
	 * Instantiates a cluster with a random centroid with the given dimension
	 * Within the given range min and max
	 * @param id
	 * @param dim
	 * @param min
	 * @param max
	 */
	public Cluster(int id, int dim, int min, int max) {
		
		Centroid c = new Centroid(min, max, dim);
		_centroid = c;
		_id = id;
		_points = new ArrayList<Point>();
	}
	
	public Cluster(int id, int dim) {
		_id = id;
		_points = new ArrayList<Point>();
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
		_points = new ArrayList<Point>();
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
	 * adds point to cluster
	 */
	public void addToCluster(Point p) {
		_points.add(p);
	}
	
	/**
	 * clear cluster of points
	 */
	public void clearCluster() {
		_points = new ArrayList<Point>();
	}
	
	
	/**
	 * Method to obtain the centroid of the cluster
	 */
	public void computeCentroid() {
		int n = _points.size();
		if (n > 0) {
			int dim = _points.get(0).getCoordinate().length;
			double[] new_coords = new double[dim];
			//sum of all points
			for (int i = 0; i < n; i++) {
				double[] curr_coords = _points.get(i).getCoordinate();
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
	
	public double computeMeanDistance() {
		double distance = 0.0;
		
		for (Point p : _points) {
			distance += getDistance(p, _centroid);
			//System.out.println(getDistance(p, _centroid));
		}
		//System.out.println("end"+_points.size());
		if (_points.size() == 0)
			return distance;
		return distance/_points.size();
	}
	
	/**
	 * Computes the distance between two given points
	 * @param p1 
	 * @param p2
	 * @return distance between p1 and p2
	 */
	public static double getDistance(Point p1, Point p2) {
		double distance = 0;
		double [] coord1 = p1.getCoordinate();
		double [] coord2 = p2.getCoordinate();
		for (int i = 0; i < coord1.length; i++) {
			distance += Math.pow(coord2[i]-coord1[i], 2);
		}
		return Math.sqrt(distance);
	}
	
	
}
