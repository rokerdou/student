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
			else if(stat==MessageData.RESPONSE_ADDSTU_SUCCESS)
			{
				return "¼��ѧ���ɹ�";
			}
			else if(stat == MessageData.RESPONSE_ADDSTU_FAIL)
			{
				return "¼��ʧ��";
			}
		return "";
	}

}
