package com.springboot.toyproject.service.impl;

import com.springboot.toyproject.repository.BoardRepository;
import com.springboot.toyproject.service.BoardService;
import com.springboot.toyproject.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public List<BoardVO> list() {
        return boardRepository.list();
    }

    @Override
    public BoardVO view(int no) {
        return boardRepository.view(no);
    }

    @Override
    public void write(BoardVO boardVO) {
        boardVO.setCreate_date(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        boardRepository.write(boardVO);
    }

    @Override
    public void edit(int no, BoardVO boardVO) {
        BoardVO bv = this.view(no);
        bv.setContent(boardVO.getContent());
        bv.setUpdate_date(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        boardRepository.edit(bv.getNo(), bv);
    }

    @Override
    public void delete(int no) {
        boardRepository.delete(no);
    }

}
