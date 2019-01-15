package com.sam.orange.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sam.orange.Brand;
import com.sam.orange.enums.ExceptionEnum;
import com.sam.orange.exception.OrangeException;
import com.sam.orange.mapper.BrandMapper;
import com.sam.orange.service.BrandService;
import com.sam.orange.vo.PageResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品品牌实现类
 * @author Sam
 * @date 2019/1/6
 * @time 0:12
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public PageResult<Brand> queryBrandPage(String key, Integer page, Integer rows, String sortBy, Boolean desc) {
        // 使用PageHelper进行分页
        PageHelper.startPage(page, rows);
        if (StringUtils.isNoneBlank()) {
            key = key.toUpperCase();
        }
        // 根据条件查询SQL
        List<Brand> brands = brandMapper.queryBrandPage(key, sortBy, desc);
        // 封装到Page
        Page<Brand> pageInfo = (Page<Brand>) brands;
        // 总条数
        long total = pageInfo.getTotal();

        return new PageResult(total,pageInfo);
    }

    @Transactional(rollbackFor = OrangeException.class)
    @Override
    public void addBrand(Brand brand, List<Long> cids) {
        brand.setId(null);
        int brandNum = brandMapper.addBrand(brand);
        if( brandNum == 0 ) {
            throw new OrangeException(ExceptionEnum.BRAND_INSERT_ERROR);
        }

        int categroyAndBrandNum = brandMapper.addBrandAndCategroy(cids, brand.getId());
        if ( categroyAndBrandNum == 0) {
            throw new OrangeException(ExceptionEnum.CATEGROYANDBRAND_INSERT_ERROR);
        }
    }

    @Override
    public List<Brand> getBrandById(Long cid) {
        List<Brand> brands = brandMapper.getCateGroyAndBrandByCid(cid);
        return brands;
    }
}
