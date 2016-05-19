package com.pulin.springbootpulin.test.push;

import java.util.ArrayList;
import java.util.List;

public class Data {
	
	
	private String dish_id="31";
	private String name="汇源果汁";
	private String upc="";
	private String pic="";
	private String min_order_num="1";
	private String package_box_num="1";
	private String description="";
	private String wid="1486061032";
	private String status="1";
	private List<Norm> norms;
	private Object[] attr = new Object[]{};
	private List<AvailableTime> available_times;
	

	
	public Data(){
		norms = new ArrayList<Norm>();
		Norm norm = new Norm();
		norms.add(norm);
		
		available_times = new ArrayList<AvailableTime>();
		for(int i = 0;i < 7;i++){
			AvailableTime time = new AvailableTime("00:00:00","23:00:00");
			available_times.add(time);
		}
	}



	public String getDish_id() {
		return dish_id;
	}



	public void setDish_id(String dish_id) {
		this.dish_id = dish_id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getUpc() {
		return upc;
	}



	public void setUpc(String upc) {
		this.upc = upc;
	}



	public String getPic() {
		return pic;
	}



	public void setPic(String pic) {
		this.pic = pic;
	}



	public String getMin_order_num() {
		return min_order_num;
	}



	public void setMin_order_num(String min_order_num) {
		this.min_order_num = min_order_num;
	}



	public String getPackage_box_num() {
		return package_box_num;
	}



	public void setPackage_box_num(String package_box_num) {
		this.package_box_num = package_box_num;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getWid() {
		return wid;
	}



	public void setWid(String wid) {
		this.wid = wid;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public List<Norm> getNorms() {
		return norms;
	}



	public void setNorms(List<Norm> norms) {
		this.norms = norms;
	}



	public Object[] getAttr() {
		return attr;
	}



	public void setAttr(Object[] attr) {
		this.attr = attr;
	}



	public List<AvailableTime> getAvailable_times() {
		return available_times;
	}



	public void setAvailable_times(List<AvailableTime> available_times) {
		this.available_times = available_times;
	}

	
	
}


