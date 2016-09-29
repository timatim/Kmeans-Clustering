package kmeansPkg;

import java.util.ArrayList;

import junit.framework.TestCase;

public class Test_Kmeans2 extends TestCase {
	
	public void testFunctionality() {
		Kmeans2 km = new Kmeans2(500);
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
		km.assignPoints();
		double initial_dist = km.computeMeanDistance();
		
		km.calculate();
		
		double final_dist = km.computeMeanDistance();
		
		assertTrue(final_dist < initial_dist);
		
		//final distance is much bigger than that in kmeans.
	}
	
}
