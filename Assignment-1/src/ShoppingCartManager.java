import java.util.*;
/**
 * 
 * @author Pratham Saldhi
 * Programming Assignment -1
 * 10/11/2020
 * Creating a ShoppingCartManager class that 
 * manages the ShoppingCart. It prompts the customer
 * for his name and current date. It creates a ShoppingCart object
 * and passes that as a parameter in printMenu method.
 *
 */
public class ShoppingCartManager {

	public static void main(String[] args) {
		
		
		//Prompting for customer's name and date
		Scanner console = new Scanner(System.in);
		System.out.print("Enter Customer's Name: ");

		String cName = console.nextLine();

		System.out.print("Enter Today's date: ");

		String cDate = console.nextLine();
		//Printing name and date
		System.out.println("Customer Name: " + cName);
		System.out.println("Today's Date: " + cDate);
		//Creating a shopping cart object
		ShoppingCart customer1 = new ShoppingCart(cName, cDate);
		//Calling printMenu
		printMenu(customer1);

	}
	/**
	 * A method that takes in 
	 * @param c that is an object 
	 * of ShoppingCart class
	 * and prints the menu that gives several options to the user
	 * for adding, removing, changing items in the cart. Also,
	 * it give option to get description of the items in cart and also
	 * option for the total number of items in cart, and
	 * their individual and total cost. 
	 * 
	 */
	public static void printMenu(ShoppingCart c) {
		boolean notValid = false;
		Scanner in = new Scanner(System.in);
		/*
		 * The menu is printed repeatedly until 'q' is entered.
		 * It contains a bunch of if blocks for different options
		 * whichever option is entered, its execution takes place.
		 * If an invalid option is entered, the program prompts the 
		 * user to input a valid option.
		 */		
		while (!notValid) {
			//Prints the menu
			System.out.println("MENU\r\n" + "a - Add item to cart\r\n" + "d - Remove item from cart \r\n"
					+ "c - Change item quantity\r\n" + "i - Output items' descriptions \r\n"
					+ "o - Output shopping cart\r\n" + "q - Quit\r\n" + "\r\n" + "");

			System.out.print("Enter an option: ");
			String option = in.next();// Takes in option
			// If option entered = q, Stops the program
			if (option.equalsIgnoreCase("q") || option.equalsIgnoreCase("quit")) {
				notValid = true;
				System.out.println("Thanks for shopping!!");
				return;
			}
			// If an invalid option is entered, the code prompts the user to enter a valid one again.
			if (!(option.equals("a") || option.equals("d") || option.equals("c") || option.equals("i")
					|| option.equals("o") || option.equals("q"))) {
				boolean valid = false;
				while (!valid) {
					System.out.println("You entered invalid option");
					System.out.print("Enter a valid option: ");
					option = in.next();
					if (option.equals("a") || option.equals("d") || option.equals("c") || option.equals("i")
							|| option.equals("o") || option.equals("q")) {
						valid = true;
					}
				}
			}
			// if a is entered
			if (option.equals("a")) {
				//Calling menuForA
				menuForA(c);
			}
			//if d is entered
			if (option.equals("d")) {
				//Calling menuForD
				menuForD(c);
			}
			//if c is entered
			if (option.equals("c")) {
				//Calling menuForC
				menuForC(c);
			}
			//if i is entered
			if (option.equals("i")) {
				System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
				//Calling printDescription on c
				c.printDescription();
			}
			//if o is entered
			if (option.equals("o")) {
				System.out.println("OUTPUT SHOPPING CART");
				//Calling printTotal on c
				c.printTotal();
			}

		}
	}
	/*
	 * A method that prompts the user
	 * when option 'a' is entered. It 
	 * takes in the ShoppingCart object c 
	 * as its parameter. It creates a new item 
	 * by using the parameterized constructor of the
	 * ItemToPurchase class and adds it into the cart
	 * by using the addItem method on c.
	 * ADDS ITEM IN CART.
	 */
	public static void menuForA(ShoppingCart c) {
		Scanner in = new Scanner(System.in);
		System.out.println("ADD ITEM TO CART");

		System.out.println("Enter the item name: ");
		String iName = in.nextLine();
		System.out.println("Enter the item description: ");
		String iDescription = in.nextLine();
		System.out.println("Enter the item price:");
		int iPrice = in.nextInt();
		System.out.println("Enter the item quantity: ");
		int iQuantity = in.nextInt();
		//Creating a new object with parameterized constructor
		ItemToPurchase item = new ItemToPurchase(iName, iPrice, iQuantity, iDescription);
		//Add item
		c.addItem(item);

	}
	/*
	 * A method that prompts the user
	 * when option 'd' is entered. It 
	 * takes in the ShoppingCart object c 
	 * as its parameter. It prompts the user for an item name 
	 * that is to be removed from the cart and 
	 * calls removeItem method on object c.
	 * REMOVES ITEM FROM CART
	 */
	public static void menuForD(ShoppingCart c) {
		Scanner in = new Scanner(System.in);
		System.out.println("REMOVE ITEM FROM CART");
		System.out.println("Enter name of item to remove: ");
		String iNameToRemove = in.nextLine();
		//Remove item
		c.removeItem(iNameToRemove);

	}
	/*
	 * A method that prompts the user
	 * when option 'c' is entered. It 
	 * takes in the ShoppingCart object c 
	 * as its parameter. It creates an object 
	 * of type ItemToPurchase and sets its quantity and
	 * name as entered by the user. It uses the modifyItem method 
	 * on c to change the quantity of the entered item.
	 * Prints empty cart if carts has no items. 
	 * CHANGES ITEM QUANTITY
	 */
	public static void menuForC(ShoppingCart c) {
		Scanner in = new Scanner(System.in);
		System.out.println("CHANGE ITEM QUANTITY");
		System.out.println("Enter the item name: ");
		String iName = in.nextLine();
		System.out.println("Enter the new quantity: ");
		int changeQuantity = in.nextInt();
		//Creating a new object
		ItemToPurchase itp = new ItemToPurchase();
		itp.setItemQuantity(changeQuantity);
		itp.setItemName(iName);
		if (c.getCartSize() != 0) {
			for (int i = 0; i < c.getCartSize(); i++) {
				//Calling modifyItem on c
				c.modifyItem(itp);
			}
		} else {	//if cart is empty
			System.out.println("Cart is empty, try adding an item first");
		}
	}

	

}
