package com.amaker.dao;

import java.util.List;

import com.amaker.bean.CollectionBean;

public interface CollDao {

	public void save(CollectionBean bean);

	public void update(CollectionBean bean);

	public void delete(String [] s);

	public List list();
	
	public CollectionBean get(int id);
}
