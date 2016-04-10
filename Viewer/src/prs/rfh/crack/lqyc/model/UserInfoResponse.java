package prs.rfh.crack.lqyc.model;

import java.util.Date;

/**
 * ��ȡ������Ϣʵ����
 * @author renfh
 *
 */
public class UserInfoResponse{
//	{
//	    "data":{
//	        "Jgid":"117001",
//	        "Xxzh":"51513605",
//	        "PassWord":null,
//	        "Xybh":"1170285772",
//	        "Sfzh":"120222199208203614",
//	        "xm":"任缚昊",
//	        "jxmc":"龙泉驾校",
//	        "id_type":null,
//	        "password":"714f263e-dea4-46c6-bdc0-2f1a6b7183c1"
//	    },
//	    "code":0,
//	    "message":""
//	}
	String Jgid;
	public boolean equals(UserInfoResponse userInfo) {
		if(this.getXxzh().equals(userInfo.getXxzh())&&
				this.getDealdate().split("\\|")[0].equals(userInfo.getDealdate().split("\\|")[0]))return true;
		else return false;
	}

	@Override
	public String toString() {
		return "UserInfoResponse [Jgid=" + Jgid + ", Xxzh=" + Xxzh + ", PassWord=" + PassWord + ", Xybh=" + Xybh
				+ ", Sfzh=" + Sfzh + ", xm=" + xm + ", jxmc=" + jxmc + ", id_type=" + id_type + ", code=" + code
				+ ", password=" + password + ", message=" + message +  ", dealdate=" + dealdate + "]";
	}
	String dealdate;
	/**
	 * 获取约车时间
	 */
	public String getDealdate() {
		return dealdate;
	}

	public void setDealdate(String dealdate) {
		this.dealdate = dealdate;
	}
	String Xxzh;
	String PassWord;
	String Xybh;
	String Sfzh;
	String xm;
	String jxmc;
	String id_type;
	String code;
	String password;
	String message;
	/*
	 * ���кţ�����117001����֪�������
	 */
	public String getJgid() {
		return Jgid;
	}
	
	public void setJgid(String jgid) {
		Jgid = jgid;
	}
	/*
	 * �û��˺ţ�51513605��
	 */
	public String getXxzh() {
		return Xxzh;
	}
	public void setXxzh(String xxzh) {
		Xxzh = xxzh;
	}
	/**
	 * ���룬һ��Ϊ��
	 */
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	
	/**
	 * ѧԱ��ţ�1170285772��
	 */
	public String getXybh() {
		return Xybh;
	}
	public void setXybh(String xybh) {
		Xybh = xybh;
	}
	/**
	 * ���֤��
	 */
	public String getSfzh() {
		return Sfzh;
	}
	public void setSfzh(String sfzh) {
		Sfzh = sfzh;
	}
	/**
	 * ����
	 */
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	/**
	 * ��У����
	 * @return
	 */
	public String getJxmc() {
		return jxmc;
	}
	public void setJxmc(String jxmc) {
		this.jxmc = jxmc;
	}
	/**
	 * id���ͣ���֪�������
	 */
	public String getId_type() {
		return id_type;
	}
	public void setId_type(String id_type) {
		this.id_type = id_type;
	}
	/**
	 * ���ص���Ϣ���룬0Ӧ����ָ��½�ɹ�
	 */
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * ���룬������ã��ɷ���������õ���ÿ�ζ���һ��
	 */
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * ������Ϣ���ɹ�ʱΪ��
	 */
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
