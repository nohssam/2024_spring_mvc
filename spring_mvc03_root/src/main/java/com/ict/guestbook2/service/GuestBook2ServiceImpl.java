package com.ict.guestbook2.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ict.guestbook2.dao.GuestBook2DAO;
import com.ict.guestbook2.dao.GuestBook2VO;

@Service
public class GuestBook2ServiceImpl implements GuestBook2Service{
	private static final Logger logger = LoggerFactory.getLogger(GuestBook2ServiceImpl.class);
	
	@Autowired
	private GuestBook2DAO gb2dao;

	@Override
	public List<GuestBook2VO> getGuestBook2List() {
		return  gb2dao.getGuestBook2List();
	}

	@Override
	public GuestBook2VO getGuestBook2Detail(String idx) {
		return gb2dao.getGuestBook2Detail(idx);
	}

	@Override
	public int getGuestBook2Insert(GuestBook2VO vo) {
		return  gb2dao.getGuestBook2Insert(vo);
	}

	@Override
	public int getGuestBook2Delete(String idx) {
		return gb2dao.getGuestBook2Delete(idx);
	}

	@Override
	public int getGuestBook2Update(GuestBook2VO vo) {
		return gb2dao.getGuestBook2Update(vo);
	}

	
}






