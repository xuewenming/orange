package com.sam.orange.service.impl;

import com.sam.orange.SpecGroup;
import com.sam.orange.SpecGroupExample;
import com.sam.orange.mapper.SpecGroupMapper;
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

    @Override
    public List<SpecGroup> getListSpecGroupByCid(Long cid) {

        SpecGroupExample example = new SpecGroupExample();
        example.createCriteria().andCidEqualTo(cid);
        List<SpecGroup> specGroups = specGroupMapper.selectByExample(example);
        return specGroups;
    }
}
