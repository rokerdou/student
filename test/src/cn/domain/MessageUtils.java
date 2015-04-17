package cn.domain;

public class MessageUtils {
	public static String getStringbyStat(int stat)
	{
		if(stat==MessageData.RESPONSE_LOGIN_SUCCESS)
			return "登陆成功";
		else
			if(stat==MessageData.RESPONSE_LOGIN_FAIL)
			{
				return "密码或账户错误";
			}
			else if(stat==MessageData.SERVICE_ERROR)
			{
				return "无法连接到服务器或服务器内部错误";
			}
		return "";
	}

}
