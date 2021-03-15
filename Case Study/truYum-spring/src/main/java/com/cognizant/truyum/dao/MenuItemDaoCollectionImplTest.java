package com.cognizant.truyum.dao;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static ApplicationContext cpxac = new ClassPathXmlApplicationContext("spring-config.xml");
	public static MenuItemService menuItemService = (MenuItemService) cpxac.getBean("menuItemService");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String choice;

		do {
			System.out.println("Menu");
			System.out.println("****************************************");
			System.out.println("1. Admin");
			System.out.println("2. Customer");
			System.out.println("3. Exit");
			System.out.println("****************************************");

			choice = sc.nextLine();
			System.out.println("****************************************");

			switch (choice) {
			case "1": {
				String adminChoice;
				do {
					System.out.println("Admin Menu");
					System.out.println("****************************************");
					System.out.println("1. Get Menu Item List");
					System.out.println("2. Modify Menu Item");
					System.out.println("3. Get Menu Item");
					System.out.println("4. Main Menu");
					System.out.println("****************************************");

					adminChoice = sc.nextLine();
					System.out.println("****************************************");

					switch (adminChoice) {
					case "1": {
						System.out.println("Admin Menu Item List");
						System.out.println("****************************************");
						testGetMenuItemListAdmin();
						break;
					}
					case "2": {
						System.out.println("Item 2 is modified. Enter 3 to display the changes.");
						System.out.println("****************************************");
						testModifyMenuItem();
						break;
					}
					case "3": {
						System.out.println("2nd Menu Item is displayed");
						System.out.println("****************************************");
						testGetMenuItem();
						break;
					}
					case "4": {
						break;
					}
					default: {
						System.out.println("Enter valid choice");
					}
					}
				} while (adminChoice.equals("4"));
				break;
			}
			case "2": {
				System.out.println("Customer Menu Item List");
				System.out.println("****************************************");
				testGetMenuItemListCustomer();
				break;
			}
			case "3": {
				break;
			}
			default: {
				System.out.println("Enter valid choice");
			}
			}
		} while (choice.equals("3"));

		sc.close();
	}

	public static void testGetMenuItemListAdmin() {

		List<MenuItem> menuItemList = menuItemService.getMenuItemListAdmin();

		for (int i = 0; i < menuItemList.size(); i++) {
			System.out.println(menuItemList.get(i));
		}
	}

	public static void testGetMenuItemListCustomer() {
		
		List<MenuItem> menuItemList = menuItemService.getMenuItemListCustomer();

		for (int i = 0; i < menuItemList.size(); i++) {
			System.out.println(menuItemList.get(i));
		}
	}

	public static void testModifyMenuItem() {
		MenuItem menuItem = new MenuItem(2, "Hotdog", 129f, true, DateUtil.convertToDate("23/12/2017"), "Main Course",
				false);

		menuItemService.modifyMenuItem(menuItem);
	}

	public static void testGetMenuItem() {

		System.out.println(menuItemService.getMenuItem(2));
	}
}
