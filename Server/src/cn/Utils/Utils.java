package cn.Utils;

public class Utils {
	public static String getDeptByclssId(String cls)
	{
		if(cls.trim().startsWith("01"))
		{
			return "ͨ��ѧԺ";
		}
		if(cls.trim().startsWith("08"))
		{
			return "�Զ���ѧԺ";
		}
		if(cls.trim().startsWith("03"))
		{
			return "�����ѧԺ";
		}
		if(cls.trim().startsWith("04"))
		{
			return "��ýѧԺ";
		}
		if(cls.trim().startsWith("05"))
		{
			return "���ѧԺ";
		}
		if(cls.trim().startsWith("06"))
		{
			return "�����ѧԺ";
		}
		return "";
		
	}

}
