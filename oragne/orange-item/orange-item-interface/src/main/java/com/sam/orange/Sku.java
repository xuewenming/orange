package com.sam.orange;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 库存量单位
 * @author Sam
 */
@Data
public class Sku implements Serializable {
    private static final long serialVersionUID = -1123232939656019447L;
    private Long id;

    private Long spuId;

    private String title;

    private String images;

    private Long price;

    private String indexes;

    private String ownSpec;

    private Boolean enable;

    private Date createTime;

    private Date lastUpdateTime;

    /**
     * 库存信息
     */
    private Integer stock;

}