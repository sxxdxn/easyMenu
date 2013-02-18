package com.xuning.easymenu;

import java.util.Vector;

public class ListModel {

	private int num;
	public Vector<Integer> listVector = new Vector<Integer>();
	private int id;
	private int userId;
	private float totalPrice;
	
	public void setNum(int num){
		this.num = num;
	}
	public int getNum(){
		return num;
	}
	
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	public int getUserId(){
		return userId;
	}
	
	public void setTotalPrice(float totalPrice){
		this.totalPrice = totalPrice;
	}
	public float getTotalPrice(){
		return totalPrice;
	}
	
	public void addCai(int caiId){
		listVector.add(caiId);
	}
	
	public int delCai(int caiId){
		int num = 0;
		while(listVector.indexOf(caiId)!=-1){
			listVector.remove((Object)caiId);
			num++;
		}
		return num;
	}
}
