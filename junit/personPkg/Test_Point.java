package personPkg;

import junit.framework.TestCase;
import java.util.Arrays;

public class Test_Point extends TestCase {
	
	public void testConstructor() {
		int [] coord = {5, 5, 5};
		Point p = new Point(coord);
		assertTrue(Arrays.equals(p.getCoordinate(), coord));
	}
	
	public void testGetCoordinate() {
		int [] coord = {5, 5, 5};
		Point p = new Point(coord);
		assertEquals(p.getCoordinate(), coord);
	}
	
	public void testSetCoordinate() {
		int [] c1 = {5, 5, 5};
		Point p = new Point(c1);
		int [] c2 = {1, 2, 3};
		p.setCoordinate(c2);
		assertEquals(c2, p.getCoordinate());
	}
	
	
}
