package com.study.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.domain.Menu;
import com.study.domain.Taste;
import com.study.domain.Type;
import com.study.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	MenuRepository menuRepository;

	public List<Menu> menuAllList() {		
		return menuRepository.findAll();
	}

	public List<Menu> menuType(Type type) {
		return menuRepository.findByType(type);
	}

	public List<Menu> menuTypeTaste(Type type, Taste taste) {
		return menuRepository.findByTypeAndTaste(type, taste);
	}
	/*
	public Menu findById(Long id) {
		return menuRepository.findById(id).get();
	}
	*/

	public Optional<Menu> findById(Long id) {
		return menuRepository.findById(id);	
	}

	public Menu insertMenu(Menu menu) {
		return menuRepository.save(menu);
	}

	public Menu updateMenu(Menu menu) {
		Menu reMenu = menuRepository.findById(menu.getId()).get();
		reMenu.setName(menu.getName());
		reMenu.setPrice(menu.getPrice());
		reMenu.setRestaurant(menu.getRestaurant());
		reMenu.setType(menu.getType());
		reMenu.setTaste(menu.getTaste());
		
		return menuRepository.save(reMenu);
	}

	public void deleteMenu(Long id) {
		menuRepository.deleteById(id);
	}
}








