package com.dish.model;

import java.util.List;

public interface DishDAO_Interface {
	public void insert(DishVO dishVO);
	public void update(DishVO dishVO);
	public void delete(DishVO dishVO);
	public DishVO findByPrimaryKey(Integer dish_id);
	public List<DishVO> getAll();
}
