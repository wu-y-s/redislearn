package com.wys.redislearn.dao;

import com.wys.redislearn.entity.NewTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AccountMapper {
    public List<NewTable> selectAll();

    public NewTable getNewTableById(int id);

    public void save(NewTable newtable);

    public void del(int id);
}
