package cn.domain;

import java.io.Serializable;

public class Message  implements Serializable{

	private static final long serialVersionUID = -2580586858218373532L;
	public int LoginType ;//
	public String user;
	public String password;
	public int State;
	public Student stu=new Student();
	

}
