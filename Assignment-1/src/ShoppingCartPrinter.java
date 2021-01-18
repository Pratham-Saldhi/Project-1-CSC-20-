import java.util.*;

public class ShoppingCartPrinter {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		ItemToPurchase item1 = new ItemToPurchase();
		System.out.println("Item 1");
		System.out.println("Enter item name: ");
		String itemName = console.nextLine();
		item1.setItemName(itemName);
		System.out.println("Enter item price: ");
		int price = console.nextInt();
		item1.setItemPrice(price);
		System.out.println("Enter item quantity: ");
		int quantity = console.nextInt();
		console.nextLine();
		item1.setItemQuantity(quantity);
		
		// Cost to firstItem
		int cost = item1.getItemPrice() * item1.getItemQuantity();
		
		
		ItemToPurchase item2 = new ItemToPurchase();
		System.out.println("Item 2");
		System.out.println("Enter item name: ");
		String itemName2 = console.nextLine();
		item2.setItemName(itemName2);
		System.out.println("Enter item price: ");
		int price2 = console.nextInt();
		item2.setItemPrice(price2);
		System.out.println("Enter item quantity: ");
		int quantity2 = console.nextInt();
		item2.setItemQuantity(quantity2);
		int cost2 = item2.getItemPrice() * item2.getItemQuantity();

		System.out.println("------TOTAL COST------");
		item1.printItemCost();
		
		//System.out.println(item1.getItemName() + " " + item1.getItemQuantity() + " @ " + item1.getItemPrice() + " = $ " + cost0);
		
		item2.printItemCost();
		//System.out.println(item2.getItemName() + " " + item2.getItemQuantity() + " @ " + item2.getItemPrice() + " = $ " + cost2);
		
		System.out.println();
		
		System.out.print("Total : $" + (cost + cost2));
	}

}
