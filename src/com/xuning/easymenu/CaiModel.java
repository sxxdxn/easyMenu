package com.xuning.easymenu;

public class CaiModel {

	private int id;
	private String name;
	private int kind;
	private String picPath;
	private double discount;
	private double star;
	private double price;
	private String info;
	private String other;
	
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	public void setKind(int kind){
		this.kind = kind;
	}
	public int getKind(){
		return kind;
	}
	
	public void setPicPath(String picPath){
		this.picPath = picPath;
	}
	public String getPicPath(){
		return picPath;
	}
	
	public void setDiscount(double discount){
		this.discount = discount;
	}
	public double getDiscount(){
		return discount;
	}
	
	public void setPrice(double d){
		this.price = d;
	}
	public double getPrice(){
		return price;
	}
	
	public void setStar(double d){
		this.star = d;
	}
	public double getStar(){
		return star;
	}
	
	public void setInfo(String info){
		this.info = info;
	}
	public String getInfo(){
		return info;
	}
	
	public void setOther(String other){
		this.other = other;
	}
	public String getOther(){
		return other;
	}
}
