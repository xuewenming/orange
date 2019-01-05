package com.sam.orange.web;

import com.sam.orange.Category;
import com.sam.orange.exception.OrangeException;
import com.sam.orange.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品分类
 * @author Sam
 * @date 2019/1/4
 * @time 23:33
 */
@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    /**
     * 根据pid查询商品分类
     * @param pid
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategroyByPid(@RequestParam(name="pid",defaultValue = "0") Long pid) {
        List<Category> categories = categoryService.queryCategroyByPid(pid);
        return ResponseEntity.ok(categories);
    }

}
