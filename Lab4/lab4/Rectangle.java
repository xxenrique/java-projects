package lab4;

public class Rectangle implements Polygon{
	double base;
	double height;
	public Rectangle(double inBase, double inHeight)
	{
		base = inBase;
		height = inHeight;
	}
	
	public double area()
	{
		double area = base * height;
		return area;
	}
	
	public double perimeter()
	{
		double perim = (base * 2) + (height * 2);
		return perim;
	}
}
