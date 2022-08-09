package z_homework.basket3X3;

public class Item {
	
	private int threeUp, twoUp, blockUp, cost;
	private String name;
	
	
	
	
	public int getThreeUp() {
		return threeUp;
	}




	public int getTwoUp() {
		return twoUp;
	}




	public int getBlockUp() {
		return blockUp;
	}




	public int getCost() {
		return cost;
	}




	public void setCost(int cost) {
		this.cost = cost;
	}




	@SuppressWarnings("unused")
	private Item() {
	
	}




	public Item(int threeUp, int twoUp, int blockUp, String name, int cost) {
		this.threeUp = threeUp;
		this.twoUp = twoUp;
		this.blockUp = blockUp;
		this.cost = cost;
		this.name = name;
	}


	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
