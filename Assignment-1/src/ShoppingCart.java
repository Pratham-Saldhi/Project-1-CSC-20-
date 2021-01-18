/**
 * @author Pratham Saldhi
 *	Programming Assignment -1
 *	10/11/2020
 ** Creating an ShoppingCart class that 
 * contains fields and methods for a shopping
 * cart that can take in a long list of items,
 * can modify its price, remove items from it, calculate the price for
 * individual item and the entire order. Also, contains methods that
 * return the number of items in the cart.
 *
 */

import java.util.*;

public class ShoppingCart {
	//Private fields for any ShoppingCart object customer's name and current date
	private String customerName;
	private String currentDate;
	// An arrayList for storing the list of items which are in the cart.
	// items are objects of ItemToPurchase
	private ArrayList<ItemToPurchase> cartItems =  null;;
	
	// Default constructor that assigns default values
	public ShoppingCart() {
		this.cartItems = new ArrayList<ItemToPurchase>();
		this.customerName = "none";
		this.currentDate = "January 1 2020";
	}
	
	//Parameterized constructor that assigns customer's name and current date
	public ShoppingCart(String customerName, String currentDate) {
		this.cartItems = new ArrayList<ItemToPurchase>();
		this.customerName = customerName;
		this.currentDate = currentDate;
	}
	// Returns the number of items in cart
	public int getCartSize() {
		return cartItems.size();
	}
	//Getting customer name
	public String getCustomerName() {
		return customerName;
	}
	// Getting current date
	public String getDate() {
		return currentDate;
	}
	// Returns the arrayList of items
	public ArrayList<ItemToPurchase> getListOfItems() {
		return cartItems;
	}
	// A method that adds an item of type ItemToPurchase in cart 
	public void addItem(ItemToPurchase itp) {
		cartItems.add(itp);
	}
	/**
	 * A method that removes an item from 
	 * the cart whose name is equal to the 
	 * @param toRemove that is passed.
	 * if the item is not found in cart 
	 * it prints item not found.
	 */
	public void removeItem(String toRemove) {
		boolean itemRemoved = false;
		//int notFound=0;
		if (!itemRemoved) {
			for (int i = 0; i < cartItems.size(); i++) {
				if (cartItems.get(i).getItemName().equalsIgnoreCase(toRemove)) {
					//Removing item at index i
					cartItems.remove(cartItems.get(i));
					itemRemoved = true;
				}
			}
		}//When item is not found 
		if(!itemRemoved) {
			System.out.println("Item not found in cart.Nothing removed.");
		}
	}
	/**
	 * A method that modifies an existing item of the cart. It takes in 
	 * @param itp an object of ItemToPurchase class
	 * as parameter, whose name and quantity are stored.
	 * If the item's price, description and/or
	 * quantity are default values, then it modifies them.
	 * Also, changes the quantity of the item.
	 * If item is not found in cart, nothing is modified.
	 */
	public void modifyItem(ItemToPurchase itp) {
		boolean notFound = false;
		boolean modified = false;
		if(!notFound) {
		for (int i = 0; i < cartItems.size(); i++) {
			if (cartItems.get(i).getItemName().equalsIgnoreCase(itp.getItemName())) {
				modified = true;
				// if item has default values, assigning some generic value
				
				//Gives a generic description
				if (cartItems.get(i).getItemDescription().equalsIgnoreCase("none")) {
					cartItems.get(i).setItemDescription(
							"A tasty item " + "("+"Description added in ShoppingCart class" + ")");
					
				}
				if (cartItems.get(i).getItemPrice() == 0) {
					// A generic price of item as $2
					cartItems.get(i).setItemPrice(2);
					
				}
				// A generic quantity of 1 units.
				if (cartItems.get(i).getItemQuantity() == 0) {
					cartItems.get(i).setItemQuantity(1);
					
				}
				// Setting quantity to what is entered by the user
				cartItems.get(i).setItemQuantity(itp.getItemQuantity());

			} 
		}
		
	}	//When item is not found
		if(!modified) {
			System.out.println("Item not found in cart. Nothing modified.");
			
		}
	}

	// Returns the total quantity of all the items
	public int getNumItemsInCart() {
		int totalQuant = 0;
		for (int i = 0; i < cartItems.size(); i++) {
			totalQuant += cartItems.get(i).getItemQuantity();
		}
		//Total number of items
		return totalQuant;

	}
	/**
	 * A method that calculates and 
	 * @return the total cost of the cart.
	 */
	public int getCostOfCart() {
		int totalCost = 0;
		for (int i = 0; i < cartItems.size(); i++) {
			totalCost += cartItems.get(i).getItemQuantity() * cartItems.get(i).getItemPrice();
		}
		//Total cost
		return totalCost;
	}
	/**
	 * A method that prints customer's name and current date
	 * It prints the number of items(total quantity) in cart,
	 * individual cost for each type of item
	 * (using printItemCost of ItemToPurchase class)and the total cost.
	 * If cart is empty, it prints empty cart. 
	 */
	public void printTotal() {
		System.out.println(customerName + "'s" + " Shopping Cart - " + currentDate);
		System.out.println();
		if (cartItems.size() == 0) {
			System.out.println("SHOPPING CART IS EMPTY");
		}
		System.out.print("Number of Items: " + getNumItemsInCart());
		System.out.println();
		for (int i = 0; i < cartItems.size(); i++) {
			cartItems.get(i).printItemCost();//Calling printItemCost on ItemToPurchase objects that are stored in cartItems

		}
		System.out.println("Total: $ " + getCostOfCart());

	}
	/**
	 * A method that prints description, which 
	 * includes customer name and current date
	 * and prints the item name and its description
	 * by using method printItemDescription 
	 * of the ItemToPurchase class.
	 */
	public void printDescription() {
		System.out.println(customerName + " - " + currentDate);
		System.out.println();
		System.out.println("Item Descriptions ");
		for (int i = 0; i < cartItems.size(); i++) {
			cartItems.get(i).printItemDescription();//Calling printItemDescription on ItemToPurchase objects that are stored in cartItems
		}
	}

}
