package com.sam.orange.web;

import com.sam.orange.Bo.SpuBo;
import com.sam.orange.Sku;
import com.sam.orange.SpuDetail;
import com.sam.orange.enums.ExceptionEnum;
import com.sam.orange.exception.OrangeException;
import com.sam.orange.service.GoodsService;
import com.sam.orange.vo.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * 商品列表Controller
 * @author Sam
 * @date 2019/1/13
 * @time 20:17
 */
@Slf4j
@RestController
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    /**
     * 查询所有Spu商品
     * @param key 搜索关键字
     * @param saleable 是否上下架
     * @param page 当前页
     * @param rows 每页显示商品数
     * @return
     */
    @GetMapping("spu/page")
    public ResponseEntity<PageResult<SpuBo>> getAllSpuPage(
            @RequestParam(value = "key",required = false) String key,
            @RequestParam(value = "saleable", required = false) Boolean saleable,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows
    ) {
        PageResult<SpuBo> pageResult = goodsService.getAllSpuPage(key,saleable,page,rows);
        if ( null == pageResult ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(pageResult);
    }

    /**
     * 保存商品信息
     * @param spuBo
     * @return
     */
    @PostMapping("goods")
    public ResponseEntity<PageResult<Void>> saveGoods(@RequestBody SpuBo spuBo) {
        try {
            goodsService.saveGoods(spuBo);
        } catch (Exception e) {
            log.error("保存商品失败,{}",e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * 商品详细信息
     * @param id
     * @return
     */
    @GetMapping("spu/detail/{id}")
    public ResponseEntity<SpuDetail> getSpuDetial(@PathVariable("id") Long id) {
        SpuDetail spuDetail = goodsService.getSpuDetialById(id);
        if (Objects.equals(spuDetail, null)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(spuDetail);
    }

    /**
     * 商品详细信息-Sku
     * @param id
     * @return
     */
    @GetMapping("sku/list")
    public ResponseEntity<List<Sku>> getSkuList(@RequestParam("id") Long id) {
        List<Sku> skus = goodsService.getSkuList(id);
        if (CollectionUtils.isEmpty(skus)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(skus);
    }

    @PutMapping("goods")
    public ResponseEntity<Void> updateGoods(@RequestBody SpuBo spuBo) {
        try {
            goodsService.updateGoods(spuBo);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            log.error("商品更新失败",e);
            throw new OrangeException(ExceptionEnum.UPDATE_GOODS_FIELD);
        }
    }


}
