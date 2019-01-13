package com.sam.orange.web;

import com.sam.orange.SpecGroup;
import com.sam.orange.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 规格参数
 * @author Sam
 * @date 2019/1/13
 * @time 19:05
 */
@RestController
@RequestMapping("spec")
public class SpecificationController {

    @Autowired
    SpecificationService specificationService;

    /**
     * 根据分类ID获取商品规格组名称
     * @param cid
     * @return
     */
    @GetMapping("groups/{cid}")
    public ResponseEntity<List<SpecGroup>> getSpecification(@PathVariable("cid") Long cid) {
        List<SpecGroup> specGroups = specificationService.getListSpecGroupByCid(cid);
        if ( CollectionUtils.isEmpty(specGroups)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(specGroups);
    }
}
