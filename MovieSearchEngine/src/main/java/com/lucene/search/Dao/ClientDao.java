package com.lucene.search.Dao;

import org.springframework.stereotype.Repository;

@Repository
public class ClientDao extends BaseDao{
  
	public String getInfo(){
		return "No Client";
	}
} 
