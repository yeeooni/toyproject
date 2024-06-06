package com.springboot.toyproject.service;

import com.springboot.toyproject.vo.BoardVO;

import java.util.List;

public interface BoardService {

    List<BoardVO> list();

    BoardVO view(int id);

    void write(BoardVO boardVO);

    void edit(int no, BoardVO boardVO);

    void delete(int no);

}