package com.wys.redislearn.service;

import com.wys.redislearn.entity.Dept;

import java.util.List;

public interface DeptService {
    public List<Dept> selectAll();

    public Dept getDeptById(int id);

    public void save(Dept dept);
}
