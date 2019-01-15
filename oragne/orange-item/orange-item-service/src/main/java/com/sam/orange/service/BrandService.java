package com.sam.orange.service;

import com.sam.orange.Brand;
import com.sam.orange.vo.PageResult;

import java.util.List;

/**
 * 商品品牌服务层接口
 * @author Sam
 * @date 2019/1/6
 * @time 0:11
 */
public interface BrandService {
    /**
     *
     * @param key 搜索字段
     * @param page 分页字段-当前页
     * @param rows 分页字段-每页数据
     * @param sortBy 排序字段
     * @param desc 是否排序
     * @return
     */
    PageResult<Brand> queryBrandPage(String key, Integer page, Integer rows, String sortBy, Boolean desc);

    /**
     * 新增品牌
     * @param brand
     * @param cids
     */
    void addBrand(Brand brand, List<Long> cids);

    /**
     * 根据分类ID查询商品品牌
     * @param cid
     * @return
     */
    List<Brand> getBrandById(Long cid);
}
