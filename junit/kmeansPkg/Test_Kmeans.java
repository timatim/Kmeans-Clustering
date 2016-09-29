package kmeansPkg;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class Test_Kmeans extends TestCase {
	
	public void testKmeansConstructor() {
		Kmeans km = new Kmeans();
	}
	
	public void testCheckConvergence() {
		// with default params
		Kmeans km = new Kmeans();
		Cluster[] cl = km.getClusters();
		Centroid[] c = new Centroid[cl.length];
		for (int i = 0; i < cl.length; i++) {
			c[i] = cl[i].getCentroid();
		}
		// should converge because testing with same centroids
		assertTrue(km.checkConvergence(c));
	}
	
	public void testAssignClusters() {
		Kmeans km = new Kmeans();
		Cluster[] cl = km.getClusters();
		ArrayList<Point> p = new ArrayList<Point>();
		for (int i = 0; i < p.size(); i++) {
			p.add(cl[i%3].getCentroid());
		}
		km.setPoints(p);
		// points should get assigned accordingly because they are at the same coordinate as centroids
		km.assignCluster();
		for (int i = 0; i < p.size(); i++) {
			assertEquals(p.get(i).getId(), i%3);
		}
	}
	
	public void testInitializeClusters() {
		// with default params
		Kmeans km = new Kmeans();
		Cluster[] cl = km.getClusters();
		Centroid[] c = new Centroid[cl.length];
		for (int i = 0; i < cl.length; i++) {
			c[i] = cl[i].getCentroid();
		}
		
		assertTrue(km.checkConvergence(c));
	}
	
	public void testComputeMeanDistance() {
		int len = 10;
		Kmeans km = new Kmeans(100, 2, 0, 10);
		ArrayList<Point> pts = new ArrayList<Point>();
		for (int i = 0; i < len; i ++) {
			for (int j = 0; j < len; j++) {
				double[] coord = new double[2];
				coord[0] = i;
				coord[1] = j;
				pts.add(new Point(coord));
			}
		}
		double dist = km.computeMeanDistance();
	}
	
	public void testFunctionality() {
		Kmeans km = new Kmeans(500);
		ArrayList<Point> pts = new ArrayList<Point>();
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				double[] coord = new double[2];
				coord[0] = i;
				coord[1] = j;
				pts.add(new Point(coord));
			}
		}
		km.setPoints(pts);
		km.assignCluster();
		double initial_dist = km.computeMeanDistance();
		//System.out.println(initial_dist);
		
		km.calculate();
		double final_dist = km.computeMeanDistance();
		//System.out.println(final_dist);
		
		assertTrue(final_dist < initial_dist);
		
		/*
		for (Cluster cl : km.getClusters()) {
			double[] coord = cl.getCentroid().getCoordinate();
			//System.out.println("["+coord[0]+","+coord[1]+"], size="+cl.getPoints().size());
		}
		*/
		
	}
}
