package kmeansPkg;

import java.util.ArrayList;

public class Kmeans {
	protected int _k = 3;
	protected int _dim = 2;
	protected int _max = 99;
	protected int _min = 0;
	protected Cluster[] _clusters;
	protected ArrayList<Point> _points;
	protected double tol = 0.0;
	
	public Cluster[] getClusters()						{ return _clusters; }
	public ArrayList<Point> getPoints()					{ return _points; }
	
	public void setK(int k)								{ _k = k; }
	public void setPoints(ArrayList<Point> points)		{ _points = points; }
	
	public Kmeans() {
		initializeClusters();
	}
	
	public Kmeans(int k) {
		_k = k;
		initializeClusters();
	}
	
	public Kmeans(int k, int dim, int min, int max) {
		_k = k;
		_dim = dim;
		_min = min;
		_max = max;
		initializeClusters();
	}
	
	/**
	 * main algorithm caller
	 * iterates the algorithm until convegence.
	 */
	public void calculate() {
		boolean convergence = false;
		int counter = 0;
		do {
			clearClusters();
			//assigning points to nearest centroid
			assignCluster();
			
			//get current centroids
			Centroid[] last_centroids = getCentroids();
			
			//get new centroid
			updateCentroids();
			
			convergence = checkConvergence(last_centroids);
			
			counter++;
		} while (!convergence);	//check for convergence
		
		System.out.println("Kmeans Iterations: "+counter);
	}
	
	/**
	 * method to update the centroid of each cluster
	 */
	protected void updateCentroids() {
		for (int i = 0; i < _k; i++) {
			_clusters[i].computeCentroid();
		}
	}
	
	/**
	 * method to randomly initialize centroids
	 */
	protected void initializeClusters() {
		_clusters = new Cluster[_k];
		for (int i = 0; i < _k; i++) {
			_clusters[i] = (Cluster) new Cluster(i, _dim, _min, _max);
		}
	}
	
	protected void clearClusters() {
		for (Cluster c : _clusters) {
			c.clearCluster();
		}
	}
	/**
	 * method to assign each point to clusters
	 * each point seeks nearest centroid
	 */
	protected void assignCluster() {
		//each point traverse through cluster centroids
		for (int i = 0; i < _points.size(); i++) {
			double min = Double.MAX_VALUE;
			int min_idx = 0;
			Point curr_point = _points.get(i);
			//find closest centroid
			for (int j = 0; j < _k; j++) {
				//get distance between point and centroid
				double curr_dist = Point.getDistance(curr_point, _clusters[j].getCentroid());
				if (curr_dist < min) {
					min = curr_dist;
					min_idx = j;
				}
			}
			//assign cluster to min
			curr_point.setId(min_idx);
			//add point to cluster
			_clusters[min_idx].addToCluster(curr_point);
		}
	}
	
	public Centroid[] getCentroids() {
		Centroid[] c = new Centroid[_k];
		for (int i = 0; i < _k; i++) {
			c[i] = _clusters[i].getCentroid();
		}
		return c;
	}
	
	public double computeMeanDistance() {
		double distance = 0.0;
		for (int i = 0; i < _k; i++) {
			distance += _clusters[i].computeMeanDistance();
			//System.out.println(distance);
		}
		return distance/_k;
	}
	
	/**
	 * check for convergence by checking if centroids' coordinates are different
	 * if there are still points switching clusters, the centroids would change as well
	 * if all points stayed in the same cluster, the centroids would stay in the same coordinate
	 */
	protected boolean checkConvergence(Centroid[] last_centroids) {
		double distance = 0.0;
		for (int i = 0; i < _k; i++) {
			distance += Centroid.getDistance(last_centroids[i], _clusters[i].getCentroid());
		}
		distance /= _k;
		//System.out.println(distance);
		if (distance <= tol)
			return true;
		else
			return false;
	}
	
}
