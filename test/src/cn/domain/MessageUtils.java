package cn.domain;

public class MessageUtils {
	public static String getStringbyStat(int stat)
	{
		if(stat==MessageData.RESPONSE_LOGIN_SUCCESS)
			return "��½�ɹ�";
		else
			if(stat==MessageData.RESPONSE_LOGIN_FAIL)
			{
				return "������˻�����";
			}
			else if(stat==MessageData.SERVICE_ERROR)
			{
				return "�޷����ӵ���������������ڲ�����";
			}
		return "";
	}

}
