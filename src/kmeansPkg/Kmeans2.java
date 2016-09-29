package kmeansPkg;

public class Kmeans2 extends Kmeans {
	public Kmeans2() {
		super();
	}
	
	public Kmeans2(int k) {
		super(k);
	}
	
	public Kmeans2(int k, int dim, int min, int max) {
		super(k, dim, min, max);
	}
	
	/**
	 * main algorithm caller
	 * iterates the algorithm until convegence.
	 */
	public void calculate() {
		boolean convergence = false;
		int counter = 0;
		do {
			//reset for iteration
			clearClusters();
			clearPointTaken();
			
			//assigning points to nearest centroid
			assignPoints();
			
			//get current centroids
			Centroid[] last_centroids = getCentroids();
			
			//get new centroid
			updateCentroids();
			
			convergence = checkConvergence(last_centroids);
			
			counter++;
			
		} while (!convergence);	//check for convergence
		
		System.out.println("Kmeans2 Iterations: "+counter);
	}
	
	public void clearPointTaken() {
		for (Point p : _points) {
			p.setTaken(false);
		}
	}
	/**
	 * method to assign each point to clusters
	 * each centroid seeks nearest points
	 */
	protected void assignPoints() {
		//each cluster centorids traverse through points
		int N = (int)(_points.size()/_k);
		for (int i = 0; i < _k-1; i++) {
			Cluster curr = _clusters[i];
			Centroid c = curr.getCentroid();
			while (curr._points.size() < N) {
				// traverse through points to get closest
				double min = Double.MAX_VALUE;
				int min_idx = 0;
				for (int j = 0; j < _points.size(); j++) {
					//get distance between point and centroid
					double curr_dist = Point.getDistance(_points.get(j), c);
					//only look at available points
					if (!_points.get(j).getTaken()) {
						if (curr_dist < min) {
							min = curr_dist;
							min_idx = j;
						}
					}
				}
				Point min_point = _points.get(min_idx);
				min_point.setTaken(true);
				min_point.setId(i);
				curr.addToCluster(min_point);
			}
		}
		
	}
}
