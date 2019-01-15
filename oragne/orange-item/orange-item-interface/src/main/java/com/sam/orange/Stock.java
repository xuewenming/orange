package com.sam.orange;

import lombok.Data;

import java.io.Serializable;

/**
 *库存对应的商品
 * @author Sam
 */
@Data
public class Stock implements Serializable {
    private static final long serialVersionUID = 585328041042198362L;
    private Long skuId;

    private Integer seckillStock;

    private Integer seckillTotal;

    private Integer stock;

}