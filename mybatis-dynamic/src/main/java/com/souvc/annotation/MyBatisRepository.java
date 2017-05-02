package com.souvc.annotation;

import org.springframework.stereotype.Repository;

@Repository
public @interface MyBatisRepository {

    String value() default "";

}
