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
	 * login登录函数
	 * 返回值0为正确，-1为服务器返回拒绝，-2为联网错误
	 * */
	public static int postLogin(UserModel user){
		HttpPost httpRequest = null;
		List <NameValuePair> params = null;
		HttpResponse httpResponse;
		/*建立HttpPost连接*/
		httpRequest = new HttpPost(ConstantValues.urlLogin);
		/*Post运作传送变数必须用NameValuePair[]阵列存储*/
		params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username",user.getName()));
		params.add(new BasicNameValuePair("userpassword",user.getPassword()));
		
		try{
			//发出HTTP request
			httpRequest.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
			//取得HTTP response
			httpResponse = new DefaultHttpClient().execute(httpRequest);
			//若状态码为200,即用户名密码正确
			if(httpResponse.getStatusLine().getStatusCode()==200){
				String strResult = EntityUtils.toString(httpResponse.getEntity());
				user.setUserId(Integer.parseInt(strResult));
			}else{
				//密码错误
				user.setUserId(-1);
				return -1;
			}
		}catch(Exception e){
			//联网失败
			user.setUserId(-2);
			e.printStackTrace();
			return -2;
		}	
		return 0;
	}
	
	/**
	 * 获取流行菜 函数
	 * 返回值0为正确，-1为服务器返回拒绝，-2为联网错误
	 * */
	public static int getPopular(Vector<Integer> v){
		 /*建立HTTP Get联机*/  
		HttpGet httpRequest = new HttpGet(ConstantValues.urlPopular);
		try{
			/*发出HTTP request*/  
			HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
			/*若状态码为200*/
			if(httpResponse.getStatusLine().getStatusCode()==200){
				/*取出响应字符串*/  
				String strResult = EntityUtils.toString(httpResponse.getEntity());
				/*删除多余字符*/
				/*摘自网上*/
				strResult = eregi_replace("(/r/n|/r|/n|/n/r)","",strResult);
				//这里我默认strResult的格式是这样的：菜号;菜号;菜号
				String[] caiTemp = strResult.split(";");
				for(int i=0;i<caiTemp.length;i++){
					v.add(Integer.parseInt(caiTemp[i]));
				}
				
			}else{
				//服务器返回异常
				Log.e("getpopular", httpResponse.getStatusLine().toString());
				return -1;
			}
		}catch(Exception e){
			//网络错误
			e.printStackTrace();
			return -2;
		}
		//正常返回
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
