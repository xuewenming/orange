package com.sam.orange.service.impl;

import com.sam.orange.Category;
import com.sam.orange.CategoryExample;
import com.sam.orange.enums.ExceptionEnum;
import com.sam.orange.exception.OrangeException;
import com.sam.orange.mapper.CategoryMapper;
import com.sam.orange.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 商品分类
 * @author Sam
 * @date 2019/1/4
 * @time 23:34
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> queryCategroyByPid(Long pid) {
        CategoryExample example = new CategoryExample();
        CategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(pid);
        List<Category> categories = categoryMapper.selectByExample(example);
        if ( CollectionUtils.isEmpty(categories) ) {
            throw new OrangeException(ExceptionEnum.CATEGORY_NOT_FOUND);
        }
        return categories;
    }
}
