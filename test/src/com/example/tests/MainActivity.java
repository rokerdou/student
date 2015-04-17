package com.example.tests;

import com.example.Service.Service;
import com.example.dialog.DialogFactory;
import com.example.framework.dialog.DialogModel;
import com.example.framework.widget.ToastWidget;


import cn.iolove.lui.Activity.BootActivity;
import cn.iolove.lui.service.Registry;
import cn.iolove.lui.service.Registry.RegistryAdapter;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends BootActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Registry.getInstance().bindAdapter(new RegistryAdapter() {
			
			@Override
			public void addRegister(Registry obj) {
				obj.register("busy",DialogModel.getInstance());
				obj.registerInlua("busy");
				obj.register("login",new Service());
				obj.registerInlua("login");
				obj.register("toast",new ToastWidget());
				obj.registerInlua("toast");

				
			}
		});
		super.onCreate(savedInstanceState);
		
		//setContentView(R.layout.activity_main);
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
