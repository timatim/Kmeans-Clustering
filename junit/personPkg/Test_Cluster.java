package personPkg;

import junit.framework.TestCase;
import java.util.Arrays;

public class Test_Cluster extends TestCase {

	
	public void testConstructor1() {
		double[] coord = {1,2,3};
		Centroid cent = new Centroid(coord);
		Cluster c = new Cluster(0, cent);
		assertEquals(c.getCentroid(), cent);
	}
	
	public void testConstructor2() {
		double[] coord = {1,2,3};
		Centroid cent = new Centroid(coord);
		Cluster c = new Cluster(0, coord);
		assertEquals(c.getCentroid(), cent);
	}
	
	public void testComputeCentroid() {
		//make a cluster with dimension = 3
		int dim = 3;
		Cluster c = new Cluster(0, dim);
		//3-d points
		Point[] p = new Point[3];
		int[] coord1 = {1,2,3};
		int[] coord2 = {6,7,4};
		int[] coord3 = {5,3,8};
		p[0] = new Point(coord1);
		p[1] = new Point(coord2);
		p[2] = new Point(coord3);
		
		//assign points to cluster
		c.setPoints(p);
		//compute centroid
		c.computeCentroid();
		
		double[] answer = {4,4,5};
		
		assertTrue(Arrays.equals(answer, c.getCentroid().getCoordinate()));
		
	}
	
	public void testGetDistance() {
		int [] c1 = {5, 5, 5};
		int [] c2 = {1, 2, 3};
		double dist = Math.sqrt(29);
		Point p1 = new Point(c1);
		Point p2 = new Point(c2);
		
		assertEquals(dist, Cluster.getDistance(p1, p2));
	}
	
	
}
