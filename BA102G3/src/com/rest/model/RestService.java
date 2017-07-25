package com.rest.model;

import java.util.List;

import com.rest.model.RestDAO;
import com.rest.model.RestVO;

public class RestService {
	private RestDAO_Interface dao;
	public RestService() {
		dao = new RestDAO();
	}

	public RestVO addrest(Integer rest_id, Integer user_id, String rest_name, String rest_address, String rest_phone,
			String rest_trans, String rest_detail, String rest_hours, Integer rest_ter, Integer rest_floor,
			Double rest_lon, Double rest_lat, Integer rest_inout, Integer rest_type, Integer rest_count,
			Integer rest_score) {

		RestVO restVO = new RestVO();

		restVO.setRest_id(rest_id);
		restVO.setUser_id(user_id);
		restVO.setRest_name(rest_name);
		restVO.setRest_address(rest_address);
		restVO.setRest_phone(rest_phone);
		restVO.setRest_trans(rest_trans);
		restVO.setRest_detail(rest_detail);
		restVO.setRest_hours(rest_hours);
		restVO.setRest_ter(rest_ter);
		restVO.setRest_floor(rest_floor);
		restVO.setRest_lon(rest_lon);
		restVO.setRest_lat(rest_lat);
		restVO.setRest_inout(rest_inout);
		restVO.setRest_type(rest_type);
		restVO.setRest_count(rest_count);
		restVO.setRest_score(rest_score);
		dao.insert(restVO);

		return restVO;
	}

	public RestVO updaterest(String rest_hours,Integer rest_count,Integer rest_score) {

		RestVO restVO = new RestVO();

		restVO.setRest_hours(rest_hours);
		restVO.setRest_count(rest_count);
		restVO.setRest_score(rest_score);
		dao.update(restVO);

		return restVO;
	}

	public void deleterest(Integer restno) {
		dao.delete(restno);
	}

	public RestVO getOnerest(Integer restno) {
		return dao.findByPrimaryKey(restno);
	}

	public List<RestVO> getAll() {
		return dao.getAll();
	}
}
