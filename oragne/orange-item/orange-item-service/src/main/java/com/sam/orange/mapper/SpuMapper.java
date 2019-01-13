package com.sam.orange.mapper;

import com.sam.orange.Spu;
import com.sam.orange.SpuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpuMapper {
    long countByExample(SpuExample example);

    int deleteByExample(SpuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Spu record);

    int insertSelective(Spu record);

    List<Spu> selectByExample(SpuExample example);

    Spu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Spu record, @Param("example") SpuExample example);

    int updateByExample(@Param("record") Spu record, @Param("example") SpuExample example);

    int updateByPrimaryKeySelective(Spu record);

    int updateByPrimaryKey(Spu record);

    /**
     *  根据参数查询商品信息
     * @param key
     * @param saleable
     * @return
     */
    List<Spu> getSpuPage(@Param("key") String key, @Param("saleable") Boolean saleable);

}