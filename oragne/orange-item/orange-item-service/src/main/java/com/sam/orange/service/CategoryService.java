package com.sam.orange.service;

import com.sam.orange.Category;

import java.util.List;

/**
 * 商品分类
 * @author Sam
 * @date 2019/1/4
 * @time 23:34
 */
public interface CategoryService {
    /**
     * 根据pid查询商品分类
     * @param pid
     * @return
     */
    List<Category> queryCategroyByPid(Long pid);

    /**
     * 根据cids 查询分类名称
     * @param cids
     * @return
     */
    List<String> queryListCategoryNamesById(List<Long> cids);
}
