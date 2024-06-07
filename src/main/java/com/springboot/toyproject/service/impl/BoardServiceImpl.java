package com.springboot.toyproject.service.impl;

import com.springboot.toyproject.repository.BoardTransaction;
import com.springboot.toyproject.service.BoardService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    //@Autowired
    //private BoardRepository boardRepository;

    private static BoardTransaction boardTransaction;

    //정적초기화블록을 사용하여 객체생성
    static {
        try{
            boardTransaction = new BoardTransaction();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<BoardTransaction.BoardVO> list() {
        return boardTransaction.list();
    }

    @Override
    public BoardTransaction.BoardVO view(int postNo) {
        return boardTransaction.view(postNo);
    }

    @Override
    public void write(BoardTransaction.BoardVO boardVO) {
        boardVO.setCreate_date(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        boardTransaction.write(boardVO);
    }

    @Override
    public void edit(int postNo, BoardTransaction.BoardVO boardVO) {
        BoardTransaction.BoardVO bv = this.view(postNo);
        bv.setContent(boardVO.getContent());
        bv.setUpdate_date(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        boardTransaction.edit(postNo, bv);
    }

    @Override
    public void delete(int postNo) {
        boardTransaction.delete(postNo);
    }

}
