package com.quanjiakan.gohome.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity implements IActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}


	public Object getParamter(int type){
		return null;
	}
	public void showMyDialog(int type){

	}
	public void dismissMyDialog(int type){

	}
	public void onSuccess(int type,int httpResponseCode,Object result){

	}
	public void onError(int type,int httpResponseCode,Object errorMsg){

	}
}
