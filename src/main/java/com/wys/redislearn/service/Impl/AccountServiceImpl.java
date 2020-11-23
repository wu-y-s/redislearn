package com.wys.redislearn.service.Impl;

import com.wys.redislearn.dao.AccountMapper;
import com.wys.redislearn.entity.NewTable;
import com.wys.redislearn.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public List<NewTable> selectAll() {
        return accountMapper.selectAll();
    }

    @Override
    public NewTable getNewTableById(int id) {
        return accountMapper.getNewTableById(id);
    }

    @Override
    public void save(NewTable newtable) {
        accountMapper.save(newtable);
    }

    @Override
    public void del(int id) {
        accountMapper.del(id);
    }
}
