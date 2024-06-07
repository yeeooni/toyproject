package com.springboot.toyproject.service;

import com.springboot.toyproject.repository.BoardTransaction;

import java.util.List;

public interface BoardService {

    List<BoardTransaction.BoardVO> list();

    BoardTransaction.BoardVO view(int postNo);

    void write(BoardTransaction.BoardVO boardVO);

    void edit(int postNo, BoardTransaction.BoardVO boardVO);

    void delete(int postNo);

}