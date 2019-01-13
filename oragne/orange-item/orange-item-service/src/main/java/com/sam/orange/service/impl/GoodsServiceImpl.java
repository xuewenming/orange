package com.sam.orange.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sam.orange.Bo.SpuBo;
import com.sam.orange.Spu;
import com.sam.orange.mapper.BrandMapper;
import com.sam.orange.mapper.SpuMapper;
import com.sam.orange.service.CategoryService;
import com.sam.orange.service.GoodsService;
import com.sam.orange.vo.PageResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品服务实现类
 * @author Sam
 * @date 2019/1/13
 * @time 20:29
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    SpuMapper spuMapper;
    @Autowired
    CategoryService categoryService;
    @Autowired
    BrandMapper brandMapper;

    @Override
    public PageResult<SpuBo> getAllSpuPage(String key, Boolean saleable, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<Spu> spus = spuMapper.getSpuPage(key, saleable);
        Page<Spu> pageInfo = (Page<Spu>) spus;
        long total = pageInfo.getTotal();

        List<SpuBo> spuBoList = pageInfo.getResult().stream().map(spu -> {
            SpuBo spuBo = new SpuBo();
            // 将Spu拷贝到SpuBo
            BeanUtils.copyProperties(spu,spuBo);
            // 查询分类名称
            List<String> categoryNames = categoryService.queryListCategoryNamesById(Arrays.asList(spu.getCid1(), spu.getCid2(), spu.getCid3()));
            spuBo.setCname(StringUtils.join(categoryNames,"/"));
            spuBo.setBname(brandMapper.selectByPrimaryKey(spu.getBrandId()).getName());
            return spuBo;
        }).collect(Collectors.toList());

        return new PageResult<>(total, spuBoList);
    }
}
