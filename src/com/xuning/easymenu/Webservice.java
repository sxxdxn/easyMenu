package com.xuning.easymenu;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Log;

public class Webservice {

	private static final String NAMESPACE = "http://easyMenu.com.cn/";
	
	private static String URL = "http://easyMenu.com.cn/webservice/webservice.asmx";
	
	/**
	 * 登录函数，返回登录信息
	 * 
	 * */
	public static String login(UserModel user){
		
		String returnMessage;
		
		final String METHOD_NAME = "login";
		String SOAP_ACTION = NAMESPACE + METHOD_NAME;
		
		SoapObject detail;
		
		SoapObject rpc = new SoapObject(NAMESPACE,METHOD_NAME);
		//输出rpc
		Log.i("login", "rpc"+rpc);
		rpc.addProperty("username", user.getName());
		rpc.addProperty("userpassword", user.getPassword());
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.bodyOut = rpc;
		envelope.dotNet = true;
		
		envelope.setOutputSoapObject(rpc);
		
		HttpTransportSE ht = new HttpTransportSE(URL);
		
		ht.debug = true;
		try {
			
			ht.call(SOAP_ACTION, envelope);
			detail = (SoapObject)envelope.getResponse();
			//具体处理函数在DealWebservice中
			returnMessage = DealWebservice.dealLogin(detail,user);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnMessage = "IOException";
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnMessage = "XmlPullParserException";
		}
		
		return returnMessage;
	
	}
	
	/**
	 * 获取zip函数
	 * 返回zip的下载地址
	 * 或返回错误原因
	 * 
	 * 传入本地版本号以及要填充服务器版本号的变量
	 * */
	public static String getZipFile(String ClientDataVersion,String ServerDataVersion){
		
		String returnMessage;
		
		final String METHOD_NAME = "getZipFile";
		String SOAP_ACTION = NAMESPACE + METHOD_NAME;
		
		SoapObject detail;
		
		SoapObject rpc = new SoapObject(NAMESPACE,METHOD_NAME);
		//输出rpc
		Log.i("getZipFile", "rpc"+rpc);
		rpc.addProperty("ClientDataVersion",ClientDataVersion);
		
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.bodyOut = rpc;
		envelope.dotNet = true;
		
		envelope.setOutputSoapObject(rpc);
		
		HttpTransportSE ht = new HttpTransportSE(URL);
		
		ht.debug = true;
		try {
			
			ht.call(SOAP_ACTION, envelope);
			detail = (SoapObject)envelope.getResponse();
			//具体处理函数在DealWebservice中
			returnMessage = DealWebservice.dealGetZipFile(detail,ServerDataVersion);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnMessage = "IOException";
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnMessage = "XmlPullParserException";
		}
		
		return returnMessage;
	
	}
	
	/**
	 * 更新菜单函数
	 * 传入本地版本号以及要填充服务器版本号的变量
	 * 返回服务器返回的消息
	 * */
	public static String updateMenu(String ClientMenuVersion,String ServerMenuVersion){
		
		String returnMessage;
		
		final String METHOD_NAME = "updateMenu";
		String SOAP_ACTION = NAMESPACE + METHOD_NAME;
		
		SoapObject detail;
		
		SoapObject rpc = new SoapObject(NAMESPACE,METHOD_NAME);
		//输出rpc
		Log.i("updateMenu", "rpc"+rpc);
		rpc.addProperty("ClientMenuVersion",ClientMenuVersion);
		
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.bodyOut = rpc;
		envelope.dotNet = true;
		
		envelope.setOutputSoapObject(rpc);
		
		HttpTransportSE ht = new HttpTransportSE(URL);
		
		ht.debug = true;
		try {
			
			ht.call(SOAP_ACTION, envelope);
			detail = (SoapObject)envelope.getResponse();
			//具体处理函数在DealWebservice中
			returnMessage = DealWebservice.dealUpdateMenu(detail,ServerMenuVersion);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnMessage = "IOException";
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnMessage = "XmlPullParserException";
		}
		
		return returnMessage;
	
	}
}
