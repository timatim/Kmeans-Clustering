package personPkg;

import junit.framework.TestCase;

public class Test_Centroid extends TestCase {

	public void testConstruct() {
		double[] coord = {1,2,3};
		Centroid cent = new Centroid(coord);
		assertEquals(cent.getCoordinate(), coord);
	}
	
	public void testEquals() {
		double[] coord1 = {1,2,3};
		double[] coord2 = {1,2,3};
		Centroid c1 = new Centroid(coord1);
		Centroid c2 = new Centroid(coord2);
		assertTrue(c1.equals(c2));
	}
	
	public void testGetDistance() {
		double[] coord1 = {0,0,0};
		double[] coord2 = {3,4,5};
		Centroid c1 = new Centroid(coord1);
		Centroid c2 = new Centroid(coord2);
		assertEquals(Math.sqrt(50), Centroid.getDistance(c1, c2));
	}
}
