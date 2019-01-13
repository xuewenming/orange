package com.sam.orange;

import lombok.Data;

import java.io.Serializable;

@Data
public class Specification implements Serializable {

    private static final long serialVersionUID = -4420850351461436459L;
    private Long categoryId;

    private String specifications;

}