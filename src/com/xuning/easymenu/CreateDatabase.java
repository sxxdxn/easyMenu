package com.xuning.easymenu;

public class CreateDatabase {
	public static void createdatabase(){
		try{
			String sqll[]=new String[]{
					//����_�˵�
				"create table if not exists menu "+
				"(cai_id integer primary key,"+
				"cai_name char(20),cai_kind integer,"+
				"cai_pic char(50),"+
				"cai_price double(2),cai_star double(1),"+
				"cai_discount double(2),cai_info char(50),"+
				"cai_other char(50))",
				//����_����
				"create table if not exists buy "+
				"(list_id integer,user_id integer,"+
				"cai_id integer,cai_num integer,"+
				"primary key(list_id,cai_id))",
				//��������
				"insert into menu values(1001,'�����Ｙ',2,'/sdcard/data/easyMenu/cai_1.png',18.00,5,10,'�����Ｙ�ܺó�','null')",
				"insert into menu values(1002,'�㹽�Ͳ�',1,'/sdcard/data/easyMenu/cai_2.png',16.00,4.5,10,'�㹽�Ͳ˺ܺó�','null')",
				"insert into menu values(1003,'ˮ����',2,'/sdcard/data/easyMenu/cai_3.png',20.00,4.5,10,'ˮ����ܺó�','null')",
				"insert into menu values(1004,'������',2,'/sdcard/data/easyMenu/cai_4.png',20.00,4.5,10,'������ܺó�','null')",
				"insert into menu values(1005,'�����Ｙ',2,'/sdcard/data/easyMenu/cai_5.png',21.50,4.5,10,'�����Ｙ�ܺó�','null')",
				"insert into menu values(1006,'�����Ｙ',0,'/sdcard/data/easyMenu/cai_5.png',21.50,4.5,10,'�����Ｙ�ܺó�','null')"
			};
			
			for(String o:sqll){//ѭ������SQL��䣬���н���ͳ�ʼ��һЩ���ݲ���
				SqlHelper.createTable(o);
			}	
			System.out.println("���ݿⴴ���ɹ�");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
