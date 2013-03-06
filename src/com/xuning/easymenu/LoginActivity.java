package com.xuning.easymenu;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity implements OnClickListener{
	TextView link;
	Button btn_login;
	EditText username_edit,userpwd_edit;
	UserModel user;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		link = (TextView)findViewById(R.id.register_link);
		link.setMovementMethod(LinkMovementMethod.getInstance());   
		
		btn_login = (Button)findViewById(R.id.signin_button);
		btn_login.setOnClickListener(this);
		
		username_edit = (EditText)findViewById(R.id.username_edit);
		userpwd_edit = (EditText)findViewById(R.id.password_edit);
		
		user = new UserModel();
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.signin_button:
			login_fun();
			break;
		default:
			break;
		}
	}
	private void login_fun() {
		if(username_edit.getText().toString().equals("")){
			showDialog("�û�������Ϊ��");
		}else if(userpwd_edit.getText().toString().equals("")){
			showDialog("���벻��Ϊ��");
		}else{
			user.setName(username_edit.getText().toString());
			user.setPassword(userpwd_edit.getText().toString());


			LoginTask task = new LoginTask(this);
			task.execute("");
		}
		
	}
	private void showDialog(String string) {
		new AlertDialog.Builder(this).setTitle("��ʾ")
									.setMessage(string)
									.setPositiveButton("ȷ��", null)
									.show();
		
	}
	
	class LoginTask extends AsyncTask<String,Integer,String>{

		ProgressDialog pdialog;
		public LoginTask(Context context){
			pdialog = new ProgressDialog(context,0);
			pdialog.setButton("ȡ��", new DialogInterface.OnClickListener(){	
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dialog.cancel();
				}
			});
			pdialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
				
				@Override
				public void onCancel(DialogInterface dialog) {
					// TODO Auto-generated method stub
					finish();
					
				}
			});
			pdialog.setCancelable(true);
			pdialog.setMax(100);
			pdialog.setTitle("��¼");
			pdialog.setMessage("");
			pdialog.setProgress(ProgressDialog.STYLE_SPINNER);
			pdialog.show();
		}
		@Override
		protected String doInBackground(String... arg0) {
			return Webservice.login(user);
		}
		@Override
		protected void onCancelled(){
			super.onCancelled();
		}
		@Override
		protected void onPostExecute(String result){
			if(result.equals(ConstantValues.rtnMsg_loginSuccess)){
				pdialog.setMessage("��¼�ɹ���");
				try {
					//Ҫ�޸�ʱ��
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pdialog.dismiss();
				//��Ҫ��Ӵ��� ������activity
			}else{
				pdialog.dismiss();
				showDialog("��¼ʧ�ܣ�ԭ��"+result);
			}
		}
		@Override
		protected void onPreExecute(){
			//��������
		}
		protected void onProgerssUpdate(Integer... values){
			//���½���
		}
	}

}
