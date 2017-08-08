package com.jx372.jblog.vo;

public class CategoryVo {
	private int no;
	private int userNo;
	private String name;
	private String description;
	private String date;
	private int cnt;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", userNo=" + userNo + ", name=" + name + ", description=" + description
				+ ", date=" + date + ", cnt=" + cnt + "]";
	}
	
	
	
}
