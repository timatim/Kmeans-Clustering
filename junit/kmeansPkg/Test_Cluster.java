package kmeansPkg;

import junit.framework.TestCase;
import kmeansPkg.Centroid;
import kmeansPkg.Cluster;
import kmeansPkg.Point;

import java.util.ArrayList;
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
		Cluster c = new Cluster(0, 2);
	}
	
	public void testComputeCentroid() {
		//make a cluster with dimension = 3
		int dim = 3;
		Cluster c = new Cluster(0, dim);
		//3-d points
		ArrayList<Point> p = new ArrayList<Point>();
		double[] coord1 = {1,2,3};
		double[] coord2 = {6,7,4};
		double[] coord3 = {5,3,8};
		p.add(new Point(coord1));
		p.add(new Point(coord2));
		p.add(new Point(coord3));
		
		//assign points to cluster
		c.setPoints(p);
		//compute centroid
		c.computeCentroid();
		
		double[] answer = {4,4,5};
		
		assertTrue(Arrays.equals(answer, c.getCentroid().getCoordinate()));
		
	}
	
	public void testComputeMeanDistance() {
		double[] coord = {0,0};
		Centroid cent = new Centroid(coord);
		Cluster c = new Cluster(0, cent);
		
		double [] coord1 = {3,3};
		double [] coord2 = {2,2};
		Point p1 = new Point(coord1);
		Point p2 = new Point(coord2);
		c.addToCluster(p1);
		c.addToCluster(p2);
		
		//System.out.println(c.computeMeanDistance());

		assertEquals(c.computeMeanDistance(), (Math.sqrt(8)+Math.sqrt(18))/2);
	}
	
	public void testGetDistance() {
		double [] c1 = {5, 5, 5};
		double [] c2 = {1, 2, 3};
		double dist = Math.sqrt(29);
		Point p1 = new Point(c1);
		Point p2 = new Point(c2);
		
		assertEquals(dist, Cluster.getDistance(p1, p2));
	}
	
	
}
