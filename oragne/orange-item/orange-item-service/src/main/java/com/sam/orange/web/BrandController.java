package com.sam.orange.web;

import com.sam.orange.Brand;
import com.sam.orange.service.BrandService;
import com.sam.orange.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品品牌
 * @author Sam
 * @date 2019/1/5
 * @time 23:54
 */
@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    /**
     * 查询品牌列表
     * @param key 搜索字段 默认为空
     * @param page 分页字段-当前页 默认为1
     * @param rows 分页字段-每页记录 默认为5
     * @param sortBy 排序字段, 默认为空
     * @param desc 是否排序，默认为false
     * @return
     */
    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandPage(
            @RequestParam(value = "key",required = false) String key,
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "desc") Boolean desc
    ){
        PageResult<Brand> pageResult = brandService.queryBrandPage(key,page,rows,sortBy,desc);
        if( null == pageResult && pageResult.getList().size() == 0 ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(pageResult);
    }

    /**
     * 新增品牌
     * @param brand
     * @param cids 商品分类id
     * @return
     */
    @PostMapping(value = "")
    public ResponseEntity<Void> addBrand(Brand brand, @RequestParam("cids")List<Long> cids) {
        brandService.addBrand(brand, cids);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
