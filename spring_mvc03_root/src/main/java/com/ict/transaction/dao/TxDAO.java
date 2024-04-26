package com.ict.transaction.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Repository
public class TxDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	public int getTxInsert(TxVO txVO) throws Exception {
//      트랜잭션 처리 이전
//		try {
//		int result = 0 ;
//	
//		result += sqlSessionTemplate.insert("card.cardInsert", txVO);
//		result += sqlSessionTemplate.insert("card.ticketInsert",txVO);
//	
//		return result;
//		}catch (Exception e) {
//			System.out.println(e);
//		}
		
		int result = 0 ;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status =  transactionManager.getTransaction(def);
		try {
			result += sqlSessionTemplate.insert("card.cardInsert", txVO);
			result += sqlSessionTemplate.insert("card.ticketInsert",txVO);	
			transactionManager.commit(status);
			System.out.println("결재성공, 발권성공");
			return result;
		} catch (Exception e) {
			transactionManager.rollback(status);
			System.out.println("결재취소, 발권취소");
		}
		return -1 ;
	}
}















