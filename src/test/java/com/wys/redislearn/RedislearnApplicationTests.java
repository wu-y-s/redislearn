package com.wys.redislearn;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wys.redislearn.entity.Dept;
import com.wys.redislearn.entity.NewTable;
import com.wys.redislearn.service.AccountService;
import com.wys.redislearn.service.DeptService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.List;
import java.util.Map;

@SpringBootTest
class RedislearnApplicationTests {

    @Autowired
    private AccountService accountService;

    @Autowired
    private DeptService deptService;

    @Autowired
    private RedisTemplate redisTemplate;



    @Test
    public void selectAll(){
        List<NewTable> newTableList=accountService.selectAll();
        System.out.println(newTableList);
    }

    @Test
    public void selectAllD(){
        List<Dept> newDeptList=deptService.selectAll();
        System.out.println(newDeptList);
    }

    @Test
    public void cc(){
        selectAll();
        System.out.println("---------");
        selectAll();
    }

    @Test
    public void getAccountById(){
        NewTable newTable=accountService.getNewTableById(55);
        System.out.println(newTable);
    }

    @Test
    public void getDeptById(){
        Dept dept=deptService.getDeptById(2);
        System.out.println(dept);
    }

    @Test
    public void save(){
        NewTable a=new NewTable("李");
        accountService.save(a);
    }

    @Test
    public void del(){
        accountService.del(7);
    }



    @Test
    public void xx(){
        Jackson2JsonRedisSerializer j=new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        j.setObjectMapper(objectMapper);

        redisTemplate.setKeySerializer(new StringRedisSerializer());//list,string,set,zset
        redisTemplate.setValueSerializer(j);
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(j);



        NewTable nt=new NewTable(111,"2");
        redisTemplate.opsForValue().set("usr",nt);

//        Map<String,String> map=(Map<String,String>) redisTemplate.opsForValue().get("usr");
//        NewTable nt2=new NewTable();
//        nt2.setName(map.get("name"));
//        System.out.println(nt2);
        NewTable nt2=(NewTable) redisTemplate.opsForValue().get("usr");
        System.out.println(nt2);
    }

}
