package com.sam.orange.vo;

import lombok.Data;

import java.util.List;

/**
 * 分页类
 * @author Sam
 * @date 2019/1/6
 * @time 0:05
 */
@Data
public class PageResult<T> {
    /**
     * 总条数
     */
    private Long total;
    /**
     * 总页数
     */
    private Long totalPage;
    /**
     * 当前页数据
     */
    private List<T> list;

    public PageResult() {
    }

    public PageResult(Long total,  List<T> list) {
        this.total = total;
        this.list = list;
    }

    public PageResult(Long total, Long totalPage, List<T> list) {
        this.total = total;
        this.totalPage = totalPage;
        this.list = list;
    }
}
