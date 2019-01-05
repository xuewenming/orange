package com.sam.orange;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品分类
 * @author Sam
 * @date 2019/1/4
 * @time 23:27
 */
@Data
public class Category implements Serializable {
    private static final long serialVersionUID = 2404533835225965970L;
    private Long id;

    private String name;

    private Long parentId;

    private Boolean isParent;

    private Integer sort;
}