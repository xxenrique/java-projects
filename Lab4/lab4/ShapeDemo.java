package lab4;
import java.util.Scanner;
public class ShapeDemo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter side of square: ");
		int side = in.nextInt();
		Polygon shape1 = new Square(side);
		System.out.println();
		System.out.println("Area of square is " + shape1.area());
		System.out.println("Perimeter of square is " + shape1.perimeter());
		
		System.out.print("Enter base of rectangle: ");
		int base = in.nextInt();
		System.out.print("Enter height of rectangle: ");
		int height = in.nextInt();
		Polygon shape2 = new Rectangle(base, height);
		System.out.println();
		System.out.println("Area of rectangle is " + shape2.area());
		System.out.println("Perimeter of rectangle is " + shape2.perimeter());
		
		System.out.print("Enter side of hexagon: ");
		side = in.nextInt();
		in.close();
		Polygon shape3 = new Hexagon(side);
		System.out.println();
		System.out.println("Area of hexagon is " + shape3.area());
		System.out.println("Perimeter of hexagon is " + shape3.perimeter());
		
	}

}
