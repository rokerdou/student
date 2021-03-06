package com.example.Service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaObject;
import org.keplerproject.luajava.LuaState;

import com.example.framework.dialog.DialogModel;

import cn.domain.Message;
import cn.domain.MessageData;
import cn.domain.MessageFactory;
import cn.domain.MessageUtils;
import cn.iolove.debug.LOG;
import cn.iolove.lui.context.RuntimeContext;
import cn.iolove.lui.service.PageService;
import cn.iolove.lui.thread.Method;
import cn.iolove.lui.thread.ThreadFactory;

public class Service  {
	LuaState stat =PageService.getInstance().getTopPage().getState();
	int result;
	LuaObject succ;
	LuaObject failed;
	Socket ss;
	public String ip="192.168.191.2";
	public int port=123;

	
	public synchronized void starts(Method m) {
		// TODO Auto-generated method stub
	ThreadFactory.getWorkThread(m).start();
	

	}
	private void exeFucInlua(LuaObject fuc,Object [] args)
	{
		if(fuc.isFunction())
		{
			
			try {
				fuc.call( args);
			
			} catch (LuaException e) {
				
				RuntimeContext.showLuaError(stat.toString(-1));
				e.printStackTrace();
			}
		}
	
		
	}
	protected Message Request(Message RequestMsg)
	{
		Message mm=null;
		try {
			java.net.InetAddress address =java.net.InetAddress.getByName(ip);
			ss = new Socket(address, port);
		
			ss.setSoTimeout(5000);
			ObjectOutputStream oos = new ObjectOutputStream((ss.getOutputStream()));
			ObjectInputStream ois =new ObjectInputStream((ss.getInputStream()));
			
			oos.writeObject(RequestMsg);
			oos.flush();
		
	
			mm = (Message)ois.readObject();
			return mm;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			mm= new Message();
			mm.State=MessageData.SERVICE_ERROR;
			e.printStackTrace();
			return mm;
			
		}	finally
		{
			try {
				if(ss!=null)
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		

	
	}
	public synchronized void Login(final String name,final String pwd,final int type,final LuaObject success, final LuaObject fail)
	{
		succ=success;
		failed=fail;
		starts(new Method() {
			
			@Override
			public void Work() {			
					Message ms = Request(MessageFactory.Login(name, pwd, type));
					LOG.i(this, "login state "+ms.State);
					if(ms.State==MessageData.RESPONSE_LOGIN_SUCCESS)
					{
						Object [] obj = {ms.stu};
						exeFucInlua(success,obj);
						
					}else
					{
						Object [] obj = {MessageUtils.getStringbyStat(ms.State)};
						exeFucInlua(fail,obj);
					}
		}
		});


	}
	public synchronized void addNewStudent(final String id,final String name,
			final String pwd,final String sex,
			final String clssid,final String clssgrade,final String cardid,
			final String provines,
			final LuaObject success, final LuaObject fail)
	{
		succ=success;
		failed=fail;
		starts(new Method() {
			
			@Override
			public void Work() {
				if(id!=null&&name!=null&&pwd!=null&&sex!=null&&clssid!=null&&clssgrade!=null&&cardid!=null
						&&(id.trim().length()>0&&name.trim().length()>0&pwd.trim().length()>0&&sex.trim().length()>0&&clssid.trim().length()>0&&clssgrade.trim().length()>0&&cardid.trim().length()>0)
						)
						{
						Message ms = Request(MessageFactory.addNewStudent(id, name, pwd,sex,
								clssid,clssgrade,cardid,provines));
						if(ms.State==MessageData.RESPONSE_ADDSTU_SUCCESS)
						{
							Object [] obj = {MessageUtils.getStringbyStat(ms.State)};
							exeFucInlua(success,obj);
							
						}else
						{
							Object [] obj = {MessageUtils.getStringbyStat(ms.State)};
							exeFucInlua(fail,obj);
						}
					}
				else
				{
					Object [] obj = {new String("数据格式不匹配")};
					exeFucInlua(fail,obj);
				}

		}
		});


	}

}
