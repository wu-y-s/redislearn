package com.wys.redislearn.dao;

import com.wys.redislearn.entity.Dept;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface DeptMapper {
    public List<Dept> selectAll();

    public Dept getDeptById(int id);

    public void save(Dept dept);
}
