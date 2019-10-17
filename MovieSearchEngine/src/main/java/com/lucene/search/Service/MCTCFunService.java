package com.lucene.search.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucene.search.Dao.FunDao;

@Service
public class MCTCFunService extends FunService{
   
	@Autowired
	private FunDao funDao;
	
	public String doFun(){
		return funDao.getFun();
	}
}
