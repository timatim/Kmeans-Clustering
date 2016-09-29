package kmeansPkg;

import junit.framework.TestCase;
import kmeansPkg.Point;

import java.util.Arrays;

public class Test_Point extends TestCase {
	
	public void testConstructor() {
		double [] coord = {5, 5, 5};
		Point p = new Point(coord);
		assertTrue(Arrays.equals(p.getCoordinate(), coord));
	}
	
	public void testGetCoordinate() {
		double [] coord = {5, 5, 5};
		Point p = new Point(coord);
		assertEquals(p.getCoordinate(), coord);
	}
	
	public void testSetCoordinate() {
		double [] c1 = {5, 5, 5};
		Point p = new Point(c1);
		double [] c2 = {1, 2, 3};
		p.setCoordinate(c2);
		assertEquals(c2, p.getCoordinate());
	}
	
	
}
