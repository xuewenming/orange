package com.sam.orange.service.impl;

import com.sam.orange.SpecGroup;
import com.sam.orange.SpecGroupExample;
import com.sam.orange.SpecParam;
import com.sam.orange.SpecParamExample;
import com.sam.orange.mapper.SpecGroupMapper;
import com.sam.orange.mapper.SpecParamMapper;
import com.sam.orange.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品规格服务实现类
 * @author Sam
 * @date 2019/1/13
 * @time 19:17
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    SpecGroupMapper specGroupMapper;
    @Autowired
    SpecParamMapper specParamMapper;

    @Override
    public List<SpecGroup> getListSpecGroupByCid(Long cid) {

        SpecGroupExample example = new SpecGroupExample();
        example.createCriteria().andCidEqualTo(cid);
        List<SpecGroup> specGroups = specGroupMapper.selectByExample(example);
        return specGroups;
    }

    @Override
    public List<SpecParam> getListSpecParamByCid(Long cid) {
        SpecParamExample example = new SpecParamExample();
        example.createCriteria().andCidEqualTo(cid);
        List<SpecParam> specParams = specParamMapper.selectByExample(example);
        return specParams;
    }
}
