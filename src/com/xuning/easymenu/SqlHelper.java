package com.xuning.easymenu;

import android.database.sqlite.SQLiteDatabase;

public class SqlHelper {
	
	public static SQLiteDatabase createOrOpenDatabase()
	{
		SQLiteDatabase db=null;
		try{
			db=SQLiteDatabase.openDatabase(
					"/data/data/org.xuning/EasyMenudb",
					null,
					SQLiteDatabase.OPEN_READWRITE|SQLiteDatabase.CREATE_IF_NECESSARY);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return db;
	}
	
	/*
	 *创建menu表。buy表
	 *
	 ***/
	public static void createTable(String sql)
	{
		SQLiteDatabase db=createOrOpenDatabase();
		try{
			db.execSQL(sql);
			db.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void insertMenu(CaiModel cai){
		StringBuilder sql = new StringBuilder("insert into menu values(");
		SQLiteDatabase db=createOrOpenDatabase();
		sql.append(cai.getId()+",'");
		sql.append(cai.getName()+"',");
		sql.append(cai.getKind()+",'");
		sql.append(cai.getPicPath()+"',");
		sql.append(cai.getPrice()+",");
		sql.append(cai.getStar()+",");
		sql.append(cai.getDiscount()+",'");
		sql.append(cai.getInfo()+"','");
		sql.append(cai.getOther()+"')");
		
		try{
			db.execSQL(sql.toString());
			db.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void deleteMenu(CaiModel cai){
		StringBuilder sql = new StringBuilder("delete from menu where cai_id = ");
		SQLiteDatabase db=createOrOpenDatabase();
		sql.append(cai.getId());
		
		try{
			db.execSQL(sql.toString());
			db.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void updateMenu(CaiModel cai){
		deleteMenu(cai);
		insertMenu(cai);
	}
	
	public static void insertBuy(ListModel list){
		
		SQLiteDatabase db = createOrOpenDatabase();
		int tempCaiId;
		int number = 0;
		while(list.listVector.isEmpty()==false){
			StringBuilder sql = new StringBuilder("insert into buy values(");
			tempCaiId = list.listVector.get(0);
			number = list.delCai(tempCaiId);
			sql.append(list.getId()+",");
			sql.append(list.getUserId()+",");
			sql.append(tempCaiId+",");
			sql.append(number+")");
			
			//输出测试
			System.out.println(sql.toString());
			
			try{
				db.execSQL(sql.toString());
				//db.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		db.close();
	}
}
