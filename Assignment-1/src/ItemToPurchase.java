/**
 * Creating an ItemToPurchase class that 
 * contains the fields and methods for an item
 * that can be in one's shopping cart
 * @author Pratham Saldhi
 *	Programming Assignment -1
 *	10/11/2020
 */
public class ItemToPurchase {
	
	//Private fields for any ItemToPurchase object: item's name, price, quantity and description
	private String itemName;
	private int itemPrice;
	private int itemQuantity;
	private  String itemDescription;
	//Default constructor assigning default values
	public ItemToPurchase() {
		this.itemName = "none";
		this.itemPrice = 0;
		this.itemQuantity =0;
		this.itemDescription = "none";
	}
	//Parameterized constructor assigning values that are given while creating the object 
	public ItemToPurchase(String itemName, int itemPrice, int itemQuantity, String itemDescription ) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
		this.itemDescription = itemDescription;
		
	}
	//Getting the item description
	public String getItemDescription() {
		return itemDescription;
	}
	//Setting the item description
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	//Getting the item name
	public String getItemName() {
		return itemName;
	}
	//Setting the item name
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	//Getting the item price
	public int getItemPrice() {
		return itemPrice;
	}
	//Setting the item price
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	//Getting the item quantity
	public int getItemQuantity() {
		return itemQuantity;
	}
	//Setting the item quantity
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	/*
	 * A method to print item's name,
	 * quantity, price and cost
	 */
	public void printItemCost() {
		System.out.println(itemName + " " + itemQuantity + " @ $" + itemPrice + " = $ "+itemPrice*itemQuantity);
	}
	/*
	 * A method to print item's description
	 * In particular its name and description
	 */
	public void printItemDescription() {
		System.out.println(itemName + " : " + itemDescription);
	}
	
}
