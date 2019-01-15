package com.sam.orange.mapper;

import com.sam.orange.Sku;
import com.sam.orange.SkuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SkuMapper {
    long countByExample(SkuExample example);

    int deleteByExample(SkuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Sku record);

    int insertSelective(Sku record);

    List<Sku> selectByExample(SkuExample example);

    Sku selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Sku record, @Param("example") SkuExample example);

    int updateByExample(@Param("record") Sku record, @Param("example") SkuExample example);

    int updateByPrimaryKeySelective(Sku record);

    int updateByPrimaryKey(Sku record);

    /**
     * 根据spuid查询Sku信息
     * @param spuId
     * @return
     */
    List<Sku> getSkusBySpuId(@Param("spuId") Long spuId);

    /**
     * 根据skuids删除sku信息
     * @param skuIds
     */
    void deleteSkusById(@Param("skuIds") List<Long> skuIds);
}