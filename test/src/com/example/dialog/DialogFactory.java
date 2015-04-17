package com.example.dialog;

import com.example.util.Utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;


public class DialogFactory {
	public static Dialog creatRequestDialog(final Context context, String tip) {

		final Dialog dialog = new Dialog(context,com.example.tests.R.style.dialog);
		dialog.setContentView(com.example.tests.R.layout.progressbar);
		Window window = dialog.getWindow();
		WindowManager.LayoutParams lp = window.getAttributes();
		int width = Utils.getScreenWidth(context);
		lp.width = (int) (0.6 * width);

		TextView titleTxtv = (TextView) dialog.findViewById(com.example.tests.R.id.progressbar);
		{
			titleTxtv.setText(tip);
		}
		dialog.setCanceledOnTouchOutside(false);
		dialog.setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
				   switch (keyCode) {  
		            case KeyEvent.KEYCODE_BACK:  
		            	
		            return false;  
				   }
				   return false;
			}
		});
		
		
		return dialog;
	}
}
