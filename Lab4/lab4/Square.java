package lab4;

public class Square implements Polygon{
	double side;
	public Square(double inSide)
	{
		side = inSide;
	}
	
	public double area()
	{
		double area = side * side;
		return area;
	}
	
	public double perimeter()
	{
		double perim = side * 4;
		return perim;
	}
}
