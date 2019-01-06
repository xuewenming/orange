package com.sam.orange.mapper;

import com.sam.orange.Brand;
import com.sam.orange.BrandExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    long countByExample(BrandExample example);

    int deleteByExample(BrandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Brand record);

    int insertSelective(Brand record);

    List<Brand> selectByExample(BrandExample example);

    Brand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByExample(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

    /**
     * 根据条件查询品牌列表
     * @param key
     * @param sortBy
     * @param desc
     * @return
     */
    List<Brand> queryBrandPage(@Param("key") String key, @Param("sortBy") String sortBy, @Param("desc") Boolean desc);
}