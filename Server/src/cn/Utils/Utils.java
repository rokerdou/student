package cn.Utils;

public class Utils {
	public static String getDeptByclssId(String cls)
	{
		if(cls.trim().startsWith("01"))
		{
			return "通信学院";
		}
		if(cls.trim().startsWith("08"))
		{
			return "自动化学院";
		}
		if(cls.trim().startsWith("03"))
		{
			return "计算机学院";
		}
		if(cls.trim().startsWith("04"))
		{
			return "传媒学院";
		}
		if(cls.trim().startsWith("05"))
		{
			return "光电学院";
		}
		if(cls.trim().startsWith("06"))
		{
			return "外国语学院";
		}
		return "";
		
	}

}
