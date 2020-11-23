package com.wys.redislearn.service;

import com.wys.redislearn.entity.NewTable;

import java.util.List;

public interface AccountService {
    public List<NewTable> selectAll();

    public NewTable getNewTableById(int id);

    public void save(NewTable newtable);

    public void del(int id);
}
