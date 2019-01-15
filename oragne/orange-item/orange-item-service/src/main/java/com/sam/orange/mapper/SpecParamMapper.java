package com.sam.orange.mapper;

import com.sam.orange.SpecParam;
import com.sam.orange.SpecParamExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecParamMapper {
    long countByExample(SpecParamExample example);

    int deleteByExample(SpecParamExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SpecParam record);

    int insertSelective(SpecParam record);

    List<SpecParam> selectByExample(SpecParamExample example);

    SpecParam selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SpecParam record, @Param("example") SpecParamExample example);

    int updateByExample(@Param("record") SpecParam record, @Param("example") SpecParamExample example);

    int updateByPrimaryKeySelective(SpecParam record);

    int updateByPrimaryKey(SpecParam record);
}