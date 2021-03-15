package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

@Service
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private List<MenuItem> menuItemList;

//	public MenuItemDaoCollectionImpl() {
//		super();
//		if (menuItemList == null) {
//			menuItemList = new ArrayList<MenuItem>();
//			MenuItem menuItem;
//
//			menuItem = new MenuItem(1, "Sandwich", 99f, true, DateUtil.convertToDate("15/03/2017"),
//					"Main Course", true);
//			menuItemList.add(menuItem);
//			menuItem = new MenuItem(2, "Burger", 129f, true, DateUtil.convertToDate("23/12/2017"), 
//					"Main Course", false);
//			menuItemList.add(menuItem);
//			menuItem = new MenuItem(3, "Pizza", 149f, true, DateUtil.convertToDate("21/08/2018"), 
//					"Main Course", false);
//			menuItemList.add(menuItem);
//			menuItem = new MenuItem(4, "French Fries", 57f, false, 
//					DateUtil.convertToDate("02/07/2017"), "Starters", true);
//			menuItemList.add(menuItem);
//			menuItem = new MenuItem(5, "Chocolate Brownie", 32f, true, 
//					DateUtil.convertToDate("02/11/2022"), "Dessert", true);
//			menuItemList.add(menuItem);
//		}
//	}

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> customerMenuItemList = new ArrayList<MenuItem>();

		for (int i = 0; i < menuItemList.size(); i++) {
			MenuItem menuItem = menuItemList.get(i);
			if ((menuItem.getDateOfLaunch().equals(new Date()) 
					|| menuItem.getDateOfLaunch().before(new Date())) && menuItem.isActive()) {
				customerMenuItemList.add(menuItem);
			}
		}

		return customerMenuItemList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).equals(menuItem)) {
				menuItemList.set(i, menuItem);
				break;
			}
		}
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		MenuItem menuItem = null;
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItemId) {
				menuItem = menuItemList.get(i);
				break;
			}
		}
		return menuItem;
	}

}
