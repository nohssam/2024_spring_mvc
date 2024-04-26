package com.ict.ex06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Service {
	
	// 인터페이스(클래스)를 자료형으로 사용
	// 변수이름과 참조하는 클래스의 id가 같을 때 사용
	@Autowired
	// 같은 이름이 없을 때는 참조 클래스의 아이디를 입력한다.
	/* @Qualifier("mariaDBDAO") */
	@Qualifier("oracleDAO")
	private DAO dao ;
	
	public Service() {}
	public Service(DAO dao) {
		this.dao = dao ;
	}
	public DAO getDao() {
		return dao;
	}
	public void setDao(DAO dao) {
		this.dao = dao;
	}
	// 사용하고 싶은 메서드
	public void biz() {
		dao.prn();
	}
}
