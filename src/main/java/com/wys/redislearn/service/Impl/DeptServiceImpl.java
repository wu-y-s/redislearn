package com.wys.redislearn.service.Impl;

import com.wys.redislearn.dao.DeptMapper;
import com.wys.redislearn.entity.Dept;
import com.wys.redislearn.service.DeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    @Override
    public List<Dept> selectAll() {
        return deptMapper.selectAll();
    }

    @Override
    public Dept getDeptById(int id) {
        return deptMapper.getDeptById(id);
    }

    @Override
    public void save(Dept dept) {
        deptMapper.save(dept);
    }
}
