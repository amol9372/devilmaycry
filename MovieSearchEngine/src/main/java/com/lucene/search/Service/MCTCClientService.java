package com.lucene.search.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lucene.search.Dao.MCTCClientDao;

@Repository
public class MCTCClientService extends ClientService {
    
	@Autowired
	private MCTCClientDao clientDao;

	public String getClientInfo() {
		return clientDao.getInfo();
	}
}
