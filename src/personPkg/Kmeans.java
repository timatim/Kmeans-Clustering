package personPkg;

public class Kmeans {
	protected int _k = 3;
	protected int _dim = 2;
	protected int _max = 99;
	protected int _min = 0;
	protected Cluster[] _clusters;
	protected Point[] _points;
	
	public void setK(int k)			{ _k = k; }
	
	public void calculate() {
		//check for convergence
		do {
			//assigning points to nearest centroid
			assignCluster();
			//get new centroid
			updateCentroids();
		
		} while (!checkConvergence());
	}
	
	/**
	 * method to update the centroid of each cluster
	 */
	public void updateCentroids() {
		for (int i = 0; i < _k; i++) {
			_clusters[i].computeCentroid();
		}
	}
	
	/**
	 * method to assign each point to clusters
	 */
	public void assignCluster() {
		
	}
	
	/**
	 * check for convergence
	 */
	public boolean checkConvergence() {
		return true;
	}
	
}
