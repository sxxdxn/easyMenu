package com.xuning.easymenu;

public class CreateDatabase {
	public static void createdatabase(){
		try{
			String sqll[]=new String[]{
					//建表_菜单
				"create table if not exists menu "+
				"(cai_id integer primary key,"+
				"cai_name char(20),cai_kind integer,"+
				"cai_pic char(50),"+
				"cai_price double(2),cai_star double(1),"+
				"cai_discount double(2),cai_info char(50),"+
				"cai_other char(50))",
				//建表_订购
				"create table if not exists buy "+
				"(list_id integer,user_id integer,"+
				"cai_id integer,cai_num integer,"+
				"primary key(list_id,cai_id))",
				//插入数据
				"insert into menu values(1001,'香辣里脊',2,'/sdcard/data/easyMenu/cai_1.png',18.00,5,10,'香辣里脊很好吃','null')",
				"insert into menu values(1002,'香菇油菜',1,'/sdcard/data/easyMenu/cai_2.png',16.00,4.5,10,'香菇油菜很好吃','null')",
				"insert into menu values(1003,'水煮肉',2,'/sdcard/data/easyMenu/cai_3.png',20.00,4.5,10,'水煮肉很好吃','null')",
				"insert into menu values(1004,'过油肉',2,'/sdcard/data/easyMenu/cai_4.png',20.00,4.5,10,'过油肉很好吃','null')",
				"insert into menu values(1005,'椒盐里脊',2,'/sdcard/data/easyMenu/cai_5.png',21.50,4.5,10,'椒盐里脊很好吃','null')",
				"insert into menu values(1006,'椒盐里脊',0,'/sdcard/data/easyMenu/cai_5.png',21.50,4.5,10,'椒盐里脊很好吃','null')"
			};
			
			for(String o:sqll){//循环所有SQL语句，进行建表和初始化一些数据操作
				SqlHelper.createTable(o);
			}	
			System.out.println("数据库创建成功");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
