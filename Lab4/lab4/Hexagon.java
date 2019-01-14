package lab4;

public class Hexagon implements Polygon{
	double side;
	double root = Math.sqrt(3);
	double formula = ((3 * root) / 2);
	public Hexagon(double inSide)
	{
		side = inSide;
	}
	
	public double area()
	{
		double area = formula * (side * side);
		return area;
	}
	
	public double perimeter()
	{
		double perim = side * 6;
		return perim;
	}
}
