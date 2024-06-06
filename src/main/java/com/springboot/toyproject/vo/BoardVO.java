package com.springboot.toyproject.vo;

import lombok.Data;

@Data
public class BoardVO {

    private int no;

    private String title;
    private String content;
    private String writer;
    private String writer_phone;
    private String writer_email;

    private String create_date;
    private String update_date;

}
