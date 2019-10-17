package com.lucene.search.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucene.search.Dao.ClientDao;

@Service
public class ClientService extends BaseService{
    
	@Autowired
	private ClientDao clientDao;
	
	public String getClientInfo(){
		return clientDao.getInfo();
	}
}
