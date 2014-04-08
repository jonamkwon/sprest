package com.wmp.user.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	@Pattern(regexp="^[_0-9a-zA-Z-]+@[0-9a-zA-Z]+(.[_0-9a-zA-Z-]+)*$", message=" 이메일 형식만 가능 합니다.")
	private String email;	
	@Pattern(regexp="^[A-Za-z0-9]{6,20}$", message=" 비밀번호는 숫자와 영문자 조합으로 6~20자리를 사용해야 합니다.")
	private String passwd;
	@Pattern(regexp="^[가-힝]{2,}$", message=" 2글자 이상 한글만 사용해야 합니다.")
	private String name;
	@Pattern(regexp="^[0-9]*$", message=" '-' 없이 숫자만 입력해주세요. ")
	private String mobile;
	
	public User() {}

	public User(String email, String passwd, String name, String mobile) {
		this.email = email;
		this.passwd = passwd;
		this.name = name;
		this.mobile = mobile;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [email=" + email + ", passwd=" + passwd + ", name=" + name
				+ ", mobile=" + mobile + "]";
	}
	
	
	
}
