package com.sam.orange.web;

import com.sam.orange.mapper.CategoryMapper;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author Sam
 * @date 2019/1/13
 * @time 22:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsControllerTest {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 测试StringUtils.join
     */
    @Test
    public void testJoin() {

        List<Long> strings = Arrays.asList(Long.valueOf("74"), Long.valueOf("75"), Long.valueOf("76"));
        List<String> names = categoryMapper.queryListCategoryNamesById(strings);
        String join = StringUtils.join(names, "/");
        System.out.println(join);
    }

}
