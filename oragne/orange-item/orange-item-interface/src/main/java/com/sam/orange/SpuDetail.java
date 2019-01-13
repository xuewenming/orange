package com.sam.orange;


import lombok.Data;

import java.io.Serializable;

/**
 * Spu纵切扩展表
 * @author Sam
 */
@Data
public class SpuDetail implements Serializable {

    private static final long serialVersionUID = -7992695716059479014L;
    private Long spuId;

    private String genericSpec;

    private String specialSpec;

    private String packingList;

    private String afterService;

    private String description;


}