package com.sam.orange;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * （标准产品单位） ，一组具有共同属性的商品集
 * @author Sam
 */
@Data
public class Spu implements Serializable {
    private static final long serialVersionUID = 3196141072994797015L;
    private Long id;

    private String title;

    private String subTitle;

    private Long cid1;

    private Long cid2;

    private Long cid3;

    private Long brandId;

    private Boolean saleable;

    private Boolean valid;

    private Date createTime;

    private Date lastUpdateTime;

}