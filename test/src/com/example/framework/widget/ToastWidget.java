package com.example.framework.widget;

import cn.iolove.lui.context.RuntimeContext;
import android.widget.Toast;

public class ToastWidget {
	public   void show(final String msg)
	{
		RuntimeContext.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Toast.makeText(RuntimeContext.getInstance().rl.getActivityContext(), msg, Toast.LENGTH_SHORT).show();
	
			}
		});
		
		
	}

}
