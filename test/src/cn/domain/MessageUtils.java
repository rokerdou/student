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
			else if(stat==MessageData.RESPONSE_ADDSTU_SUCCESS)
			{
				return "录入学生成功";
			}
			else if(stat == MessageData.RESPONSE_ADDSTU_FAIL)
			{
				return "录入失败";
			}
		return "";
	}

}
