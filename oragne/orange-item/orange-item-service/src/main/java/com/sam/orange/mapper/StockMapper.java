package com.sam.orange.mapper;

import com.sam.orange.Stock;
import com.sam.orange.StockExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StockMapper {
    long countByExample(StockExample example);

    int deleteByExample(StockExample example);

    int deleteByPrimaryKey(Long skuId);

    int insert(Stock record);

    int insertSelective(Stock record);

    List<Stock> selectByExample(StockExample example);

    Stock selectByPrimaryKey(Long skuId);

    int updateByExampleSelective(@Param("record") Stock record, @Param("example") StockExample example);

    int updateByExample(@Param("record") Stock record, @Param("example") StockExample example);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);

    /**
     * 根据skuids查询Stock
     * @param ids
     * @return
     */
    List<Stock> getStockBySkuids(@Param("ids") List<Long> ids);

    /**
     * 根据skuids删除Stock信息
     * @param ids
     */
    void deleteStockBySkuIds(@Param("ids") List<Long> ids);
}