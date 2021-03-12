package com.amaker.dao;

import java.util.List;

import com.amaker.bean.Stu;

public interface StuDao {

	public void save(Stu s);

	public List list();
}
