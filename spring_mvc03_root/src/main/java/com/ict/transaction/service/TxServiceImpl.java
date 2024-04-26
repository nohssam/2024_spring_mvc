package com.ict.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.transaction.dao.TxDAO;
import com.ict.transaction.dao.TxVO;

@Service
public class TxServiceImpl implements TxService{
	@Autowired
	private TxDAO txDAO;
	
	@Override
	public int getTxInsert(TxVO txVO) throws Exception {
		return txDAO.getTxInsert(txVO);
	}
}
