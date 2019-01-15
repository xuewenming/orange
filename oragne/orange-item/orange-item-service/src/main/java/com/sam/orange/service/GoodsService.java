package com.sam.orange.service;

import com.sam.orange.Bo.SpuBo;
import com.sam.orange.Sku;
import com.sam.orange.SpuDetail;
import com.sam.orange.vo.PageResult;

import java.util.List;

/**
 * 商品服务接口
 * @author Sam
 * @date 2019/1/13
 * @time 20:24
 */
public interface GoodsService {

    /**
     * 根据参数查询Spu商品信息
     * @param key 搜索关键字
     * @param saleable 是否上下架
     * @param page 当前页
     * @param rows 每页显示商品数
     * @return
     */
    PageResult<SpuBo> getAllSpuPage(String key, Boolean saleable, Integer page, Integer rows);


    /**
     * 保存商品信息
     * @param spuBo
     */
    void saveGoods(SpuBo spuBo);

    /**
     * 根据spuId查询Spu详情
     * @param id
     * @return
     */
    SpuDetail getSpuDetialById(Long id);

    /**
     * 根据skuId查询Sku信息
     * @param id
     * @return
     */
    List<Sku> getSkuList(Long id);

    /**
     * 更新商品信息
     * @param spuBo
     */
    void updateGoods(SpuBo spuBo);
}
