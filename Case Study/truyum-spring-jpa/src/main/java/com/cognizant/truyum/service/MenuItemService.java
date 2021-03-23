package com.cognizant.truyum.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuItemRepository;

@Service
public class MenuItemService implements MenuItemDao {

	@Autowired
	MenuItemRepository menuItemRepository;
	
	@Transactional
	public void modifyMenuItem(MenuItem menuItem) {
		menuItemRepository.save(menuItem);
	}


	@Transactional
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemRepository.findAll();
	}

	@Transactional
	public List<MenuItem> getMenuItemListCustomer() {
		return menuItemRepository.findByActiveAndDateOfLaunchBefore(true, new Date());
	}

	@Transactional
	public MenuItem getMenuItem(int menuItemId) {
		return menuItemRepository.getOne(menuItemId);
	}


	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
