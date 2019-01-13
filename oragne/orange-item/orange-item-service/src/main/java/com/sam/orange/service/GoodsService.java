package com.sam.orange.service;

import com.sam.orange.Bo.SpuBo;
import com.sam.orange.vo.PageResult;

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
}
