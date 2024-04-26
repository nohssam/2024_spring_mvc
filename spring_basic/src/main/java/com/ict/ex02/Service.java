package com.ict.ex02;

public class Service {
	// 1. OracleDAO oracleDAO = new OracleDAO();
	// 2. MariaDBDAO mariaDBDAO = new MariaDBDAO();
	
	// 인터페이스(클래스)를 자료형으로 사용
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
		// oracleDAO , MariaDBDAO => prn 메서드 실행
		// 1. oracleDAO.prn();
		// 2. mariaDBDAO.prn();
		
		dao.prn();
	}
}
