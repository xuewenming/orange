package com.sam.orange;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品规格组信息
 * @author Sam
 */
@Data
public class SpecGroup implements Serializable {
    private static final long serialVersionUID = -3227316483275936132L;

    private Long id;

    private Long cid;

    private String name;
}