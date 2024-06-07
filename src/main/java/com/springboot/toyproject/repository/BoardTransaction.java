package com.springboot.toyproject.repository;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardTransaction {

    private final static Map<Integer, BoardVO> boardMap = new HashMap<>();
    private static int seq = 0;

    public List<BoardVO> list(){
        return new ArrayList<>(boardMap.values());
    }

    public BoardVO view(int postNo){
        return boardMap.get(postNo);
    }

    public void write(BoardVO boardVO){
        boardVO.setPostNo(++seq);
        boardMap.put(boardVO.getPostNo(), boardVO);
    }

    public void edit(int postNo, BoardVO boardVO){
        boardVO.setPostNo(postNo);
        boardMap.put(boardVO.getPostNo(), boardVO);
    }

    public void delete(int postNo){
        boardMap.remove(postNo);
    }

    //Nested class
    //inner class
    @Data
    public class BoardVO {
        private int postNo;

        private String title;
        private String content;
        private String writer;

        private String create_date;
        private String update_date;

    }

}
