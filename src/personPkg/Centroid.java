package personPkg;
import java.util.Arrays;

public class Centroid {
	protected double[] _coordinate;
	
	public double[] getCoordinate() 	{ return _coordinate; }
	
	public void setCoordinate(double[] coordinate)	{ _coordinate = coordinate; }
	
	public Centroid(double[] coords) {
		_coordinate = coords;
	}
	
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (!(object instanceof Centroid)) {
			return false;
		}
		Centroid p = (Centroid)object;
		return Arrays.equals(p.getCoordinate(),_coordinate);
	}
	
	public static double getDistance(Centroid c1, Centroid c2) {
		double distance = 0.0;
		double[] coord1 = c1.getCoordinate();
		double[] coord2 = c2.getCoordinate();
		
		int dim = coord1.length;
		if (coord1.length == coord2.length) {
			for (int i = 0; i < dim; i++) {
				distance += Math.pow(coord2[i]-coord1[i], 2);
			}
			distance = Math.sqrt(distance);
		}
		
		return distance;
	}
}
