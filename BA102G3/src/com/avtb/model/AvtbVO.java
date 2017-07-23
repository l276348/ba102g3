package com.avtb.model;

import java.util.Date;

public class AvtbVO {
 private Integer avtb_id;
 private Integer rest_id;
 private Date avtb_date_s;
 private Date avtb_date_e;
 private Integer avtb_reservation;
 private Integer avtb_max_reservation;
 
 public AvtbVO() {
 }

public Integer getAvtb_id() {
	return avtb_id;
}

public void setAvtb_id(Integer avtb_id) {
	this.avtb_id = avtb_id;
}

public Integer getRest_id() {
	return rest_id;
}

public void setRest_id(Integer rest_id) {
	this.rest_id = rest_id;
}

public Date getAvtb_date_s() {
	return avtb_date_s;
}

public void setAvtb_date_s(Date avtb_date_s) {
	this.avtb_date_s = avtb_date_s;
}

public Date getAvtb_date_e() {
	return avtb_date_e;
}

public void setAvtb_date_e(Date avtb_date_e) {
	this.avtb_date_e = avtb_date_e;
}

public Integer getAvtb_reservation() {
	return avtb_reservation;
}

public void setAvtb_reservation(Integer avtb_reservation) {
	this.avtb_reservation = avtb_reservation;
}

public Integer getAvtb_max_reservation() {
	return avtb_max_reservation;
}

public void setAvtb_max_reservation(Integer avtb_max_reservation) {
	this.avtb_max_reservation = avtb_max_reservation;
}
 
}
