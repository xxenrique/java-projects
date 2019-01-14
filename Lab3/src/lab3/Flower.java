package lab3;

public class Flower {
	private int numPetals;
	private float price;
	private String name;
	
	public Flower(int inPetal, float inPrice, String inName)
	{
		name = inName;
		price = inPrice;
		numPetals = inPetal;
	}
	public void setName(String inName)
	{
		name = inName;
	}
	public void setPrice(float inPrice)
	{
		price = inPrice;
	}
	public void setPetal(int inPetal)
	{
		numPetals = inPetal;
	}
	public int getPetal()
	{
		return numPetals;
	}
	public float getPrice()
	{
		return price;
	}
	public String getName()
	{
		return name;
	}
}
