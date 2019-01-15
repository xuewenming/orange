package com.sam.orange.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sam.orange.Bo.SpuBo;
import com.sam.orange.*;
import com.sam.orange.enums.ExceptionEnum;
import com.sam.orange.exception.OrangeException;
import com.sam.orange.mapper.*;
import com.sam.orange.service.CategoryService;
import com.sam.orange.service.GoodsService;
import com.sam.orange.vo.PageResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
    @Autowired
    SpuDetailMapper spuDetailMapper;
    @Autowired
    SkuMapper skuMapper;
    @Autowired
    StockMapper stockMapper;

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

    @Transactional(rollbackFor = OrangeException.class)
    @Override
    public void saveGoods(SpuBo spuBo) {
       // 保存SPU信息
        spuBo.setSaleable(true);
        spuBo.setValid(true);
        spuBo.setCreateTime(new Date());
        spuBo.setLastUpdateTime(new Date());
        this.spuMapper.insert(spuBo);

        // 保存SpuDetial
        spuBo.getSpuDetail().setSpuId(spuBo.getId());
        this.spuDetailMapper.insert(spuBo.getSpuDetail());

        // 保存SKU和库存
        saveSkuAndStock(spuBo.getSkus(), spuBo.getId());
    }

    /**
     * 保存SKU和库存
     * @param skuList
     * @param spuId
     */
    private void saveSkuAndStock(List<Sku> skuList, Long spuId) {
        for (Sku sku : skuList) {
            if (!sku.getEnable()) {
                continue;
            }
            // SKU
            sku.setSpuId(spuId);
            sku.setCreateTime(new Date());
            sku.setLastUpdateTime(new Date());
            this.skuMapper.insert(sku);

            // 库存
            Stock stock = new Stock();
            stock.setSkuId(sku.getId());
            stock.setStock(sku.getStock());
            stockMapper.insert(stock);
        }
    }

    @Override
    public SpuDetail getSpuDetialById(Long id) {
        SpuDetail spuDetail = spuDetailMapper.selectByPrimaryKey(id);
        return spuDetail;
    }

    @Override
    public List<Sku> getSkuList(Long id) {
        SkuExample example = new SkuExample();
        example.createCriteria().andSpuIdEqualTo(id);
        List<Sku> skus = skuMapper.selectByExample(example);
        // 取出每一个skuId
        List<Long> ids = skus.stream().map(Sku::getId).collect(Collectors.toList());
        // 根据skuids查询Stocks
        List<Stock> stocks = stockMapper.getStockBySkuids(ids);
        if (CollectionUtils.isEmpty(stocks)) {
            throw new OrangeException(ExceptionEnum.FIND_STOCK_IS_NULL);
        }
        Map<Long, Integer> map = stocks.stream().collect(Collectors.toMap(Stock::getSkuId, Stock::getStock));
        skus.forEach(sku -> sku.setStock(map.get(sku.getId())));
        return skus;
    }

    @Transactional
    @Override
    public void updateGoods(SpuBo spuBo) {
        // 删除spu
        spuMapper.deleteByPrimaryKey(spuBo.getId());
        List<Sku> skus = skuMapper.getSkusBySpuId(spuBo.getId());
        if (!CollectionUtils.isEmpty(skus)) {
            List<Long> ids = skus.stream().map(sku -> sku.getId()).collect(Collectors.toList());
            // 删除 stock
            stockMapper.deleteStockBySkuIds(ids);

            // 删除 sku
            skuMapper.deleteSkusById(ids);

            // 删除 spuDetial
            spuDetailMapper.deleteByPrimaryKey(spuBo.getId());
        }
        // 保存SPU信息
        spuBo.setSaleable(true);
        spuBo.setValid(true);
        spuBo.setCreateTime(new Date());
        spuBo.setLastUpdateTime(new Date());
        this.spuMapper.insert(spuBo);

        // 保存SpuDetial
        spuBo.getSpuDetail().setSpuId(spuBo.getId());
        this.spuDetailMapper.insert(spuBo.getSpuDetail());

        // 保存SKU和库存
        saveSkuAndStock(spuBo.getSkus(), spuBo.getId());
    }
}
