package com.sam.orange.mapper;

import com.sam.orange.SpecGroup;
import com.sam.orange.SpecGroupExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecGroupMapper {
    long countByExample(SpecGroupExample example);

    int deleteByExample(SpecGroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SpecGroup record);

    int insertSelective(SpecGroup record);

    List<SpecGroup> selectByExample(SpecGroupExample example);

    SpecGroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SpecGroup record, @Param("example") SpecGroupExample example);

    int updateByExample(@Param("record") SpecGroup record, @Param("example") SpecGroupExample example);

    int updateByPrimaryKeySelective(SpecGroup record);

    int updateByPrimaryKey(SpecGroup record);
}