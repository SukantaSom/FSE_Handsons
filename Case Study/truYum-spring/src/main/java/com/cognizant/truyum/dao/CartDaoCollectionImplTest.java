package com.cognizant.truyum.dao;

import java.util.List;
import java.util.Scanner;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String choice;
		int itemAdded = 0;

		do {
			System.out.println("Menu");
			System.out.println("****************************************");
			System.out.println("1. Add Cart Item");
			System.out.println("2. Get All Cart Items");
			System.out.println("3. Remove Cart Item");
			System.out.println("4. Exit");
			System.out.println("****************************************");

			choice = sc.nextLine();
			System.out.println("****************************************");

			switch (choice) {
			case "1": {
				System.out.println("Item 2 is added in User Id 1. Enter 2 to test.");
				System.out.println("****************************************");
				testAddCartItem();
				itemAdded++;
				break;
			}
			case "2": {
				testGetAllCartItems();
				break;
			}
			case "3": {
				if (itemAdded != 0) {
					System.out.println("Item 2 is removed in User Id 1. Enter 2 to test.");
					System.out.println("****************************************");
					testRemoveCartItem();
					itemAdded--;
				} else {
					System.out.println("Cart Empty !! First add something to the cart.");
					System.out.println("****************************************");
				}
				break;
			}
			case "4": {
				break;
			}
			default: {
				System.out.println("Enter valid choice");
			}
			}
		} while (!choice.equals("4"));

		sc.close();
	}

	public static void testAddCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 2);
	}

	public static void testGetAllCartItems() {
		CartDao cartDao = new CartDaoCollectionImpl();
		try {
			List<MenuItem> menuItemList = cartDao.getAllCartItems(1);
			System.out.println("User Id 1 content is displayed");
			System.out.println("****************************************");
			for (MenuItem menuItem : menuItemList) {
				System.out.println(menuItem);
			}
		} catch (CartEmptyException e) {
			System.out.println("Cart Empty !!");
			System.out.println("****************************************");
		}
	}

	public static void testRemoveCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.removeCartItem(1, 2);
	}
}
