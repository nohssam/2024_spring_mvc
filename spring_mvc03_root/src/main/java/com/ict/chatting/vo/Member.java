package com.ict.chatting.vo;

import java.sql.Date;

public class Member implements java.io.Serializable  {
	private static final long serialVersionUID = 8027014658748663307L;
	
	
	//Field
	private String memberID;      //회원아이디
	private String memberPWD;       //비밀번호
	private String memberNicname;
	private String memberName;      //이름
	private Date birth;       //생년월일
	private String gender;			//성별
	private String email;          //이메일
	private String address;        //주소
	private String photoFilename;    //회원사진파일명
	private Date resign;         //회원탈퇴
	private String adminYN;        //관리자여부
	private String signType;       //로그인 종류
	private String actLimit;        //사용제약
	private Date registDate;       //등록일자 
	private Date modifiedDate;     //최종수정일자
	private int memberAuth;        //회원인증


	
	
	
	//Constructor
	public Member() {
		super();
	}



	public Member(String memberID, String memberPWD, String memberNicname, String memberName, Date birth, String gender, String email,
			String address, String photoFilename, Date resign, String adminYN, String signType, String actLimit, Date registDate,
			Date modifiedDate, int memberAuth) {
		super();
		this.memberID = memberID;
		this.memberPWD = memberPWD;
		this.memberNicname = memberNicname;
		this.memberName = memberName;
		this.birth = birth;
		this.email = email;
		this.address = address;
		this.photoFilename = photoFilename;
		this.resign = resign;
		this.adminYN = adminYN;
		this.signType = signType;
		this.actLimit = actLimit;
		this.registDate = registDate;
		this.modifiedDate = modifiedDate;
		this.memberAuth = memberAuth;
	}



	//getters and setters
	public String getMemberID() {
		return memberID;
	}



	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}



	public String getMemberPWD() {
		return memberPWD;
	}



	public void setMemberPWD(String memberPWD) {
		this.memberPWD = memberPWD;
	}

	public String getMemberNicname() {
		return memberNicname;
	}



	public void setMemberNicname(String memberNicname) {
		this.memberNicname = memberNicname;
	}


	public String getMemberName() {
		return memberName;
	}



	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}



	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPhotoFilename() {
		return photoFilename;
	}



	public void setPhotoFilename(String photoFilename) {
		this.photoFilename = photoFilename;
	}



	public Date getResign() {
		return resign;
	}



	public void setResign(Date resign) {
		this.resign = resign;
	}



	public String getAdminYN() {
		return adminYN;
	}



	public void setAdminYN(String adminYN) {
		this.adminYN = adminYN;
	}



	public String getSignType() {
		return signType;
	}



	public void setSignType(String signType) {
		this.signType = signType;
	}



	public String getActLimit() {
		return actLimit;
	}



	public void setActLimit(String actLimit) {
		this.actLimit = actLimit;
	}



	public Date getRegistDate() {
		return registDate;
	}



	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}



	public Date getModifiedDate() {
		return modifiedDate;
	}



	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	public int getMemberAuth() {
		return memberAuth;
	}



	public void setMemberAuth(int memberAuth) {
		this.memberAuth = memberAuth;
	}


	
	
	
	@Override
	public String toString() {
		return "Member [memberID=" + memberID + ", memberPWD=" + memberPWD + ", memberNicname=" + memberNicname + ", memberName=" + memberName
				+ ", birth=" + birth +  ", gender=" + gender + ", email=" + email + ", address=" + address + ", photoFilename=" + photoFilename + ", resign="
				+ resign + ", adminYN=" + adminYN + ", signType=" + signType + ", actLimit=" + actLimit
				+ ", registDate=" + registDate + ", modifiedDate=" + modifiedDate +  ", memberAuth=" + memberAuth + "]";
	}




	
	
	
	
}
