package com.pulin.springbootpulin.test.push;

public class AvailableTime {
	private String start_time;
	private String end_time;
	
	public AvailableTime(){
		
	}
	
	public AvailableTime(String start_time,String end_time){
		this.start_time = start_time;
		this.end_time = end_time;
	}
	
	
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
}	
