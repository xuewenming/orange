package com.sam.orange;

import lombok.Data;

import java.io.Serializable;

/**
 * 品牌
 * @author Sam
 * @date 2019/1/5
 * @time 00:15
 */
@Data
public class Brand implements Serializable {
    private static final long serialVersionUID = 6206869671121379939L;

    private Long id;

    private String name;

    private String image;

    private String letter;

}