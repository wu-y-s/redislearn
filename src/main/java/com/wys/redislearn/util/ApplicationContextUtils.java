package com.wys.redislearn.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component//获取工厂对象
public class ApplicationContextUtils implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context=applicationContext;
    }

    public static Object getBean(String id){
        return context.getBean(id);
    }

    public static Object getBean(String id,Class clazz){
        return context.getBean(id,clazz);
    }
}
