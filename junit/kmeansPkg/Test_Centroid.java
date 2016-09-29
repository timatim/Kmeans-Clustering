package kmeansPkg;

import junit.framework.TestCase;
import kmeansPkg.Centroid;

public class Test_Centroid extends TestCase {

	public void testConstruct() {
		double[] coord = {1,2,3};
		Centroid cent = new Centroid(coord);
		assertEquals(cent.getCoordinate(), coord);
	}

	public void testGetDistance() {
		double[] coord1 = {0,0,0};
		double[] coord2 = {3,4,5};
		Centroid c1 = new Centroid(coord1);
		Centroid c2 = new Centroid(coord2);
		assertEquals(Math.sqrt(50), Centroid.getDistance(c1, c2));
	}
}
