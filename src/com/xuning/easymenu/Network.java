package com.xuning.easymenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class Network {
	
	/**
	 * login��¼����
	 * ����ֵ0Ϊ��ȷ��-1Ϊ���������ؾܾ���-2Ϊ��������
	 * */
	public static int postLogin(UserModel user){
		HttpPost httpRequest = null;
		List <NameValuePair> params = null;
		HttpResponse httpResponse;
		/*����HttpPost����*/
		httpRequest = new HttpPost(ConstantValues.urlLogin);
		/*Post�������ͱ���������NameValuePair[]���д洢*/
		params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username",user.getName()));
		params.add(new BasicNameValuePair("userpassword",user.getPassword()));
		
		try{
			//����HTTP request
			httpRequest.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
			//ȡ��HTTP response
			httpResponse = new DefaultHttpClient().execute(httpRequest);
			//��״̬��Ϊ200,���û���������ȷ
			if(httpResponse.getStatusLine().getStatusCode()==200){
				String strResult = EntityUtils.toString(httpResponse.getEntity());
				user.setUserId(Integer.parseInt(strResult));
			}else{
				//�������
				user.setUserId(-1);
				return -1;
			}
		}catch(Exception e){
			//����ʧ��
			user.setUserId(-2);
			e.printStackTrace();
			return -2;
		}	
		return 0;
	}
	
	/**
	 * ��ȡ���в� ����
	 * ����ֵ0Ϊ��ȷ��-1Ϊ���������ؾܾ���-2Ϊ��������
	 * */
	public static int getPopular(Vector<Integer> v){
		 /*����HTTP Get����*/  
		HttpGet httpRequest = new HttpGet(ConstantValues.urlPopular);
		try{
			/*����HTTP request*/  
			HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
			/*��״̬��Ϊ200*/
			if(httpResponse.getStatusLine().getStatusCode()==200){
				/*ȡ����Ӧ�ַ���*/  
				String strResult = EntityUtils.toString(httpResponse.getEntity());
				/*ɾ�������ַ�*/
				/*ժ������*/
				strResult = eregi_replace("(/r/n|/r|/n|/n/r)","",strResult);
				//������Ĭ��strResult�ĸ�ʽ�������ģ��˺�;�˺�;�˺�
				String[] caiTemp = strResult.split(";");
				for(int i=0;i<caiTemp.length;i++){
					v.add(Integer.parseInt(caiTemp[i]));
				}
				
			}else{
				//�����������쳣
				Log.e("getpopular", httpResponse.getStatusLine().toString());
				return -1;
			}
		}catch(Exception e){
			//�������
			e.printStackTrace();
			return -2;
		}
		//��������
		return 0;
	}

	private static String eregi_replace(String strFrom, String strTo,String strTarget) {
		String strPattern = "(?i)"+strFrom;  
	      Pattern p = Pattern.compile(strPattern);  
	      Matcher m = p.matcher(strTarget);  
	      if(m.find())  
	      {  
	        return strTarget.replaceAll(strFrom, strTo);  
	      }  
	      else  
	      {  
	        return strTarget;  
	      }  
	}  
	
}
