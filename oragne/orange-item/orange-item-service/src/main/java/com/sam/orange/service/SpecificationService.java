package com.sam.orange.service;

import com.sam.orange.SpecGroup;
import com.sam.orange.SpecParam;

import java.util.List;

/**
 * 规格服务接口
 * @author Sam
 * @date 2019/1/13
 * @time 19:15
 */
public interface SpecificationService {

    /**
     * 根据分类ID获取商品规格组
     * @param cid
     * @return
     */
    List<SpecGroup> getListSpecGroupByCid(Long cid);

    /**
     * 根据分类ID获取规格参数
     * @param cid
     * @return
     */
    List<SpecParam> getListSpecParamByCid(Long cid);
}
