package com.sam.orange;

import lombok.Data;

import java.io.Serializable;

/**
 * 规格参数
 * @author Sam
 */
@Data
public class SpecParam implements Serializable {
    private static final long serialVersionUID = -1851643323393198519L;
    private Long id;

    private Long cid;

    private Long groupId;

    private String name;

    private Boolean numeric;

    private String unit;

    private Boolean generic;

    private Boolean searching;

    private String segments;

}