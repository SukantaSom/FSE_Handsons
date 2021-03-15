package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;

@Service
public class MenuItemService {

	@Autowired
	private MenuItemDao menuItemDao;
	
	/**
	 * 
	 * @return list of MenuItem for Admin
	 */
	public List<MenuItem> getMenuItemListAdmin(){
		
		return menuItemDao.getMenuItemListAdmin();
	}
	
	/**
	 * 
	 * @return list of MenuItem for Customer
	 */
	public List<MenuItem> getMenuItemListCustomer(){
		
		return menuItemDao.getMenuItemListCustomer();
	}
	
	/**
	 * 
	 * @param menuItem for modification/update
	 */
	public void modifyMenuItem(MenuItem menuItem){
		
		menuItemDao.modifyMenuItem(menuItem);
	}
	
	/**
	 * 
	 * @param menuItemId  to get the MenuItem object
	 * @return MenuItem object
	 */
	public MenuItem getMenuItem(long menuItemId){
		
		return menuItemDao.getMenuItem(menuItemId);
	}
	
}
