package com.lzwing.mybatisspringxmldemo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 8809101560720973267L;

    private Integer id;

    private String userName;

    private Integer age;
}