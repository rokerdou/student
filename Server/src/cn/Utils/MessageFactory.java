package cn.Utils;

import cn.domain.Message;
import cn.domain.MessageData;

public class MessageFactory {
	public static Message Login(String name,String pwd,int Type)
	{
		Message ms= new Message();
		ms.LoginType=Type;
		ms.password=pwd;
		ms.user=name;
		ms.State=MessageData.REQUEST_LOGIN;
		return ms;
	}


}
