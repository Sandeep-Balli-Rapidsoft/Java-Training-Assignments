//  Given a map of product names and their corresponding prices, 
// Write a Java method to calculate the total cost of all the products in the map, print the output as like invoice.
package com.ProductInvoice;
import java.util.*;
public class Test {
	
	public static void displayInvoice(Map<String, Double> products) {
		double totalCost = 0.00;
		for(Map.Entry<String, Double> items : products.entrySet()) {
			totalCost += items.getValue();
		}
		
		for(Map.Entry<String, Double> items : products.entrySet()) {
			System.out.println("Item: " + items.getKey() + ", Price: " + items.getValue());
		}

		
		System.out.println("Total cost: " + totalCost);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Double> products = new HashMap<>();
		products.put("Mocktail", 200.00);
		products.put("Pizza", 456.00);
		products.put("Chicken Chilli", 310.00);
		products.put("Crispy Mushroom", 200.00);
		
		displayInvoice(products);
		
	}

}
