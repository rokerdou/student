package cn.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Student  implements Serializable{
	private static final long serialVersionUID = -12972974393123L;
	public String id;
	public String name;
	public ArrayList<StuCourse> courseArray = new ArrayList<StuCourse>();
	public String dep;
	public String sex;
	public String cardid;
	public String password;
	public String classgrade;
	public String classid;
	public String province;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<StuCourse> getCourseArray() {
		return courseArray;
	}
	public void setCourseArray(ArrayList<StuCourse> courseArray) {
		this.courseArray = courseArray;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getClassgrade() {
		return classgrade;
	}
	public void setClassgrade(String classgrade) {
		this.classgrade = classgrade;
	}
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}

}
