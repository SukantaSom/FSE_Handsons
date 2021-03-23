package com.cognizant.truyum;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@SpringBootApplication
public class TruyumSpringJpaApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumSpringJpaApplication.class);
	private static MenuItemService menuItemService;

	public static void main(String[] args) {
		LOGGER.info("Inside main");

		ApplicationContext context = SpringApplication.run(TruyumSpringJpaApplication.class, args);

		menuItemService = context.getBean(MenuItemService.class);

		//testGetMenuItemListAdmin();
		//testGetMenuItemListCustomer();
		//testGetMenuItem();
		testModifyMenuItem();
	}

	public static void testGetMenuItemListAdmin() {
		LOGGER.info("Start : testGetMenuItemListAdmin()");

		List<MenuItem> menuItems = menuItemService.getMenuItemListAdmin();

		LOGGER.debug("MenuItems={}", menuItems);

		LOGGER.info("End testGetMenuItemListAdmin()");
	}

	public static void testGetMenuItemListCustomer() {
		LOGGER.info("Start : testGetMenuItemListCustomer()");

		List<MenuItem> menuItems = menuItemService.getMenuItemListCustomer();

		LOGGER.debug("MenuItems={}", menuItems);

		LOGGER.info("End testGetMenuItemListCustomer()");
	}
	
	public static void testGetMenuItem() {
		LOGGER.info("Start : testGetMenuItem()");

		MenuItem menuItems = menuItemService.getMenuItem(1);

		LOGGER.debug("MenuItem={}", menuItems);

		LOGGER.info("End testGetMenuItem()");
	}
	
	public static void testModifyMenuItem() {
		LOGGER.info("Start : testModifyMenuItem()");

		MenuItem menuItem = menuItemService.getMenuItem(1);
		menuItem.setPrice(100f);
		
		menuItemService.modifyMenuItem(menuItem);
		
		menuItem = menuItemService.getMenuItem(1);
		
		LOGGER.debug("MenuItems={}", menuItem);

		LOGGER.info("End testModifyMenuItem()");
	}

}
