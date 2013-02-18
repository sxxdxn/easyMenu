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
	 * ��¼���������ص�¼��Ϣ
	 * 
	 * */
	public static String login(UserModel user){
		
		String returnMessage;
		
		final String METHOD_NAME = "login";
		String SOAP_ACTION = NAMESPACE + METHOD_NAME;
		
		SoapObject detail;
		
		SoapObject rpc = new SoapObject(NAMESPACE,METHOD_NAME);
		//���rpc
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
			//���崦������DealWebservice��
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
	 * ��ȡzip����
	 * ����zip�����ص�ַ
	 * �򷵻ش���ԭ��
	 * 
	 * ���뱾�ذ汾���Լ�Ҫ���������汾�ŵı���
	 * */
	public static String getZipFile(String ClientDataVersion,String ServerDataVersion){
		
		String returnMessage;
		
		final String METHOD_NAME = "getZipFile";
		String SOAP_ACTION = NAMESPACE + METHOD_NAME;
		
		SoapObject detail;
		
		SoapObject rpc = new SoapObject(NAMESPACE,METHOD_NAME);
		//���rpc
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
			//���崦������DealWebservice��
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
	 * ���²˵�����
	 * ���뱾�ذ汾���Լ�Ҫ���������汾�ŵı���
	 * ���ط��������ص���Ϣ
	 * */
	public static String updateMenu(String ClientMenuVersion,String ServerMenuVersion){
		
		String returnMessage;
		
		final String METHOD_NAME = "updateMenu";
		String SOAP_ACTION = NAMESPACE + METHOD_NAME;
		
		SoapObject detail;
		
		SoapObject rpc = new SoapObject(NAMESPACE,METHOD_NAME);
		//���rpc
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
			//���崦������DealWebservice��
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
