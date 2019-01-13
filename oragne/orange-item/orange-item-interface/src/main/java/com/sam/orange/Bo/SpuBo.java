package com.sam.orange.Bo;

import com.sam.orange.Spu;
import com.sam.orange.SpuDetail;
import lombok.Data;

/**
 * 商品业务对象
 * @author Sam
 * @date 2019/1/13
 * @time 21:31
 */
@Data
public class SpuBo extends Spu {
    /**
     * 分类名称
     */
    private String cname;
    /**
     * 品牌名称
     */
    private String bname;

    /**
     * SPU商品信息
     */
    private SpuDetail spuDetail;
}
