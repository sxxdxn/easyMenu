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
	
	/**
	 * �ϴ���������
	 * �����û��Ͷ�����
	 * ���ط��������ص�ֵ
	 * */
	public static String uploadBuyList(UserModel user,ListModel cailist){
		
		String returnMessage;
		String buyCaiId="",buyUserId=user.getUserId()+"",sessionId = user.getSessionId();
		
		final String METHOD_NAME = "uploadBuyList";
		String SOAP_ACTION = NAMESPACE + METHOD_NAME;
		
		SoapObject detail;
		
		SoapObject rpc = new SoapObject(NAMESPACE,METHOD_NAME);
		//���rpc
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
			//���崦������DealWebservice��
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
	 * ��ȡtop10����
	 * �����ȡ�������Լ�Ҫ����top10��vector
	 * ��������������ֵ
	 * */
	public static String getTop10(int top10Kind,Vector<Integer> top10Cai){
		
		String returnMessage;
		
		
		final String METHOD_NAME = "getTop10";
		String SOAP_ACTION = NAMESPACE + METHOD_NAME;
		
		SoapObject detail;
		
		SoapObject rpc = new SoapObject(NAMESPACE,METHOD_NAME);
		//���rpc
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
			//���崦������DealWebservice��
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
	 * �ϴ��û����ֺ���
	 * ���ط���������ֵ
	 * ���뱻���˺ţ��û��࣬�Ǽ�
	 * */
	public static String uploadStar(int uploadStarCaiId,int uploadStarCaiStar,UserModel user){
		
		String returnMessage;
		
		
		final String METHOD_NAME = "uploadStar";
		String SOAP_ACTION = NAMESPACE + METHOD_NAME;
		
		SoapObject detail;
		
		SoapObject rpc = new SoapObject(NAMESPACE,METHOD_NAME);
		//���rpc
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
			//���崦������DealWebservice��
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
