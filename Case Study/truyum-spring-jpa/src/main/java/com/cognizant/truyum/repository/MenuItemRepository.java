package com.cognizant.truyum.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
	public List<MenuItem> findByActiveAndDateOfLaunchBefore(boolean active, Date date);

	@Query("select m from MenuItem m where m.id=:c")
	public MenuItem getOne(@Param("c") int id);
}
