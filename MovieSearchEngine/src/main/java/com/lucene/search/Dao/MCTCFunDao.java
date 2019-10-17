package com.lucene.search.Dao;

import org.springframework.stereotype.Repository;

@Repository
public class MCTCFunDao extends FunDao{
  
	public String getFun(){
		return "MCTC is doing fun";
	}
} 
