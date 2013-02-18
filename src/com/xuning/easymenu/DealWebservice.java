package com.xuning.easymenu;

import java.io.UnsupportedEncodingException;
import org.ksoap2.serialization.SoapObject;

import android.util.Log;

public class DealWebservice {

	/**
	 * 返回登陆成功或失败的服务器提示
	 * */
	public static String dealLogin(SoapObject detail,UserModel user)throws UnsupportedEncodingException{
			
		String loginSuccess,userId,sessionId,returnMessage;
		
		loginSuccess = detail.getProperty("loginSuccess").toString();
		if(loginSuccess.equals("true")){
			userId = detail.getProperty("userId").toString();
			sessionId = detail.getProperty("sessionId").toString();
			
			user.setSessionId(sessionId);
			user.setUserId(Integer.parseInt(userId));
			returnMessage = detail.getProperty("returnMessage").toString();
			
		}else if(loginSuccess.equals("false")){
			returnMessage = detail.getProperty("returnMessage").toString();
			return returnMessage;
		}else{
			Log.e("login", "服务器返回loginSuccess错误");
			returnMessage = detail.getProperty("returnMessage").toString();
			return returnMessage;
		}
		
		return returnMessage;
	}
	
	/**
	 * 如果成功，返回zip的地址
	 * 否则返回失败原因
	 * */
	public static String dealGetZipFile(SoapObject detail,String ServerDataVersion)throws UnsupportedEncodingException{
		
		String getZipFileSuccess,zipFileUrl,returnMessage;
		
		getZipFileSuccess = detail.getProperty("getZipFileSuccess").toString();
		if(getZipFileSuccess.equals("true")){
			ServerDataVersion = detail.getProperty("ServerDataVersion").toString();
			zipFileUrl = detail.getProperty("zipFileUrl").toString();
			returnMessage = zipFileUrl;
		}else if(getZipFileSuccess.equals("false")){
			returnMessage = detail.getProperty("returnMessage").toString();
			return returnMessage;
		}else{
			Log.e("getZipFile", "服务器返回getZipFileSuccess错误");
			returnMessage = detail.getProperty("returnMessage").toString();
			return returnMessage;
		}
		return returnMessage;
	}

	/**
	 * 更新菜单
	 * */
	public static String dealUpdateMenu(SoapObject detail,String serverMenuVersion) {
		
		String updataMenuSuccess,updataKind,caiId,caiName,caiKind,caiPic,caiPrice,caiStar,caiDiscount,caiInfo,caiOther,returnMessage;
		
		CaiModel cai = new CaiModel();
		
		updataMenuSuccess = detail.getProperty("updataMenuSuccess").toString();
		if(updataMenuSuccess.equals("true")){
			serverMenuVersion = detail.getProperty("serverMenuVersion").toString();
			updataKind = detail.getProperty("updataKind").toString();
			caiId = detail.getProperty("caiId").toString();
			caiName = detail.getProperty("caiName").toString();
			caiKind = detail.getProperty("caiKind").toString();
			caiPic = detail.getProperty("caiPic").toString();
			caiPrice = detail.getProperty("caiPrice").toString();
			caiStar = detail.getProperty("caiStar").toString();
			caiDiscount = detail.getProperty("caiDiscount").toString();
			caiInfo = detail.getProperty("caiInfo").toString();
			caiOther = detail.getProperty("caiOther").toString();
			
			String[] updataKindTemp = updataKind.split(";");
			String[] caiIdTemp = caiId.split(";");
			String[] caiNameTemp = caiName.split(";");
			String[] caiKindTemp = caiKind.split(";");
			String[] caiPicTemp = caiPic.split(";");
			String[] caiPriceTemp = caiPrice.split(";");
			String[] caiStarTemp = caiStar.split(";");
			String[] caiDiscountTemp = caiDiscount.split(";");
			String[] caiInfoTemp = caiInfo.split(";");
			String[] caiOtherTemp = caiOther.split(";");
			
			for(int i = 0;i < updataKindTemp.length;i++){
				
				cai.setId(Integer.parseInt(caiIdTemp[i]));
				cai.setName(caiNameTemp[i]);
				cai.setKind(Integer.parseInt(caiKindTemp[i]));
				cai.setPicPath(caiPicTemp[i]);
				cai.setPrice(Double.parseDouble(caiPriceTemp[i]));
				cai.setStar(Double.parseDouble(caiStarTemp[i]));
				cai.setDiscount(Double.parseDouble(caiDiscountTemp[i]));
				cai.setInfo(caiInfoTemp[i]);
				cai.setOther(caiOtherTemp[i]);
				
				if(Integer.parseInt(updataKindTemp[i])==1){//增加
					SqlHelper.insertMenu(cai);
				}else if(Integer.parseInt(updataKindTemp[i])==2){//修改
					SqlHelper.updateMenu(cai);
				}else if(Integer.parseInt(updataKindTemp[i])==3){//删除
					SqlHelper.deleteMenu(cai);
				}else{
					Log.e("UpdateMenu", "updata失败");
				}
			}
			
			returnMessage = detail.getProperty("returnMessage").toString();
		}else if(updataMenuSuccess.equals("false")){
			returnMessage = detail.getProperty("returnMessage").toString();
			return returnMessage;
		}else{
			Log.e("UpdateMenu", "服务器返回UpdateMenu错误");
			returnMessage = detail.getProperty("returnMessage").toString();
			return returnMessage;
		}
		return returnMessage;
	}
	
	/**
	 * 创建订单
	 * */
	public static String dealUploadBuyList(SoapObject detail,ListModel cailist){
		String uploadBuyListSuccess,buyListId,buyListTotalPrice,returnMessage;
		
		uploadBuyListSuccess = detail.getProperty("uploadBuyListSuccess").toString();
		if(uploadBuyListSuccess.equals("true")){
			buyListId = detail.getProperty("buyListId").toString();
			buyListTotalPrice = detail.getProperty("buyListTotalPrice").toString();
			returnMessage =  detail.getProperty("returnMessage").toString();
			cailist.setId(Integer.parseInt(buyListId));
			cailist.setTotalPrice(Double.parseDouble(buyListTotalPrice));
			SqlHelper.insertBuyList(cailist);
		}else if(uploadBuyListSuccess.equals("false")){
			returnMessage = detail.getProperty("returnMessage").toString();
			return returnMessage;
		}else{
			Log.e("UploadBuyList", "服务器返回UploadBuyList错误");
			returnMessage = detail.getProperty("returnMessage").toString();
			return returnMessage;
		}
		return returnMessage;
	}
}
