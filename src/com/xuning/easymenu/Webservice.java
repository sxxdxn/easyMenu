package com.xuning.easymenu;

import java.io.IOException;
import java.util.Vector;

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
	
	/**
	 * 上传订单函数
	 * 传入用户和订单类
	 * 返回服务器返回的值
	 * */
	public static String uploadBuyList(UserModel user,ListModel cailist){
		
		String returnMessage;
		String buyCaiId="",buyUserId=user.getUserId()+"",sessionId = user.getSessionId();
		
		final String METHOD_NAME = "uploadBuyList";
		String SOAP_ACTION = NAMESPACE + METHOD_NAME;
		
		SoapObject detail;
		
		SoapObject rpc = new SoapObject(NAMESPACE,METHOD_NAME);
		//输出rpc
		Log.i("uploadBuyList", "rpc"+rpc);
		
		for(int i=0;i<cailist.listVector.size();i++){
			buyCaiId += cailist.listVector.get(i);
			buyCaiId += ";";
		}
		buyCaiId = buyCaiId.substring(0, buyCaiId.length()-1);
		
		rpc.addProperty("buyCaiId", buyCaiId);
		rpc.addProperty("buyUserId", buyUserId);
		rpc.addProperty("sessionId", sessionId);
		
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
			returnMessage = DealWebservice.dealUploadBuyList(detail,cailist);
			
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
	 * 获取top10函数
	 * 传入获取参数，以及要保存top10的vector
	 * 传出服务器返回值
	 * */
	public static String getTop10(int top10Kind,Vector<Integer> top10Cai){
		
		String returnMessage;
		
		
		final String METHOD_NAME = "getTop10";
		String SOAP_ACTION = NAMESPACE + METHOD_NAME;
		
		SoapObject detail;
		
		SoapObject rpc = new SoapObject(NAMESPACE,METHOD_NAME);
		//输出rpc
		Log.i("Top10Kind", "rpc"+rpc);
		
		rpc.addProperty("Top10Kind", top10Kind);
		
		
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
			returnMessage = DealWebservice.dealGetTop10(detail,top10Cai);
			
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
	 * 上传用户评分函数
	 * 返回服务器返回值
	 * 传入被评菜号，用户类，星级
	 * */
	public static String uploadStar(int uploadStarCaiId,int uploadStarCaiStar,UserModel user){
		
		String returnMessage;
		
		
		final String METHOD_NAME = "uploadStar";
		String SOAP_ACTION = NAMESPACE + METHOD_NAME;
		
		SoapObject detail;
		
		SoapObject rpc = new SoapObject(NAMESPACE,METHOD_NAME);
		//输出rpc
		Log.i("uploadStar", "rpc"+rpc);
		
		rpc.addProperty("uploadStarCaiId", uploadStarCaiId);
		rpc.addProperty("uploadStarCaiStar", uploadStarCaiStar);
		rpc.addProperty("uploadStarUserId",user.getUserId()+"");
		rpc.addProperty("sessionId",user.getSessionId()+"");
		
		
		
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
			returnMessage = DealWebservice.dealUploadStar(detail);
			
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
