package lab3;
import java.util.Scanner;
public class FlowerDemo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("What type of flower?");
		String name = in.nextLine();
		System.out.println("How many petals?");
		int petals = in.nextInt();
		System.out.println("Input the price.");
		float price = in.nextFloat();
		in.close();
		Flower flower = new Flower(petals, price, name);
		System.out.println("Flower name: " + flower.getName());
		System.out.println("Number of Petals: " + flower.getPetal());
		System.out.println("Price: " + flower.getPrice());

	}

}
