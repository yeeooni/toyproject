package com.springboot.toyproject.vo;

import lombok.Data;

@Data
public class BoardVO {

    private int postNo;

    private String title;
    private String content;
    private String writer;

    private String create_date;
    private String update_date;

}
