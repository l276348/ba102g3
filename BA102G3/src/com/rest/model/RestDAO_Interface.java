package com.rest.model;

import java.util.List;

import com.rest.model.RestVO;

public interface RestDAO_Interface {
	public void insert(RestVO restVO);
    public void update(RestVO restVO);
    public void delete(Integer rest_id);
    public RestVO findByPrimaryKey(Integer rest_id);
    public List<RestVO> getAll();
}
