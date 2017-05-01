package com.souvc.dao;

import com.souvc.entity.EMP;
import com.souvc.entity.EMPExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EMPMapper {
    int countByExample(EMPExample example);

    int deleteByExample(EMPExample example);

    int deleteByPrimaryKey(Integer empno);

    int insert(EMP record);

    int insertSelective(EMP record);

    List<EMP> selectByExample(EMPExample example);

    EMP selectByPrimaryKey(Integer empno);

    int updateByExampleSelective(@Param("record") EMP record, @Param("example") EMPExample example);

    int updateByExample(@Param("record") EMP record, @Param("example") EMPExample example);

    int updateByPrimaryKeySelective(EMP record);

    int updateByPrimaryKey(EMP record);
}