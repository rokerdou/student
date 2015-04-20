package cn.domain;

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

	public static Message addNewStudent(String id, String name, String pwd,
			String sex, String clssid, String clssgrade, String cardid,String provin) {
		Message ms= new Message();
		ms.State=MessageData.REQUEST_ADDSTU;
		ms.stu.id=id;
		ms.stu.name=name;
		ms.stu.password=pwd;
		ms.stu.sex=sex;
		ms.stu.classid=clssid;
		ms.stu.classgrade=clssgrade;
		ms.stu.cardid=cardid;
		if(provin!=null)
		{
			if(provin.trim().length()>0)
			ms.stu.province=provin;
		}

		
		return ms;
	}
}
