package com.example.framework.dialog;

import cn.iolove.lui.context.RuntimeContext;
import cn.iolove.lui.service.PageService;

import com.example.dialog.DialogFactory;

import android.app.Dialog;

public class DialogModel {
	private  Dialog obj=null;
	private  static  DialogModel objf= new DialogModel();
	private DialogModel()
	{
		
	}
	
	public  void show(String objs)
	{
		obj=DialogFactory.creatRequestDialog(RuntimeContext.getInstance().rl.getActivityContext(), objs);
		obj.show();
		
	}
	public  void dismiss()
	{
		if(obj!=null)
		obj.dismiss();
		
	}
	public static  DialogModel getInstance(){return objf;}

}
