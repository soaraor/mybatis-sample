package com.souvc.annotation;

import org.springframework.stereotype.Repository;

/**
 * 将某个包中带有指定注解标记的Mapper接口扫描，转化成MapperFactoryBean对象
 */
@Repository
public @interface MyBatisRepository {

    String value() default "";

}
