package com.springboot.toyproject.repository;

import com.springboot.toyproject.vo.BoardVO;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardRepository {

    private final Map<Integer, BoardVO> boardMap = new HashMap<>();
    private static int seq = 0;

    public List<BoardVO> list() {
        return new ArrayList<>(boardMap.values());
    }

    public BoardVO view(int postNo) {
        return boardMap.get(postNo);
    }

    public void write(BoardVO boardVO) {
        boardVO.setPostNo(++seq);
        boardMap.put(boardVO.getPostNo(), boardVO);
    }

    public void edit(int postNo, BoardVO boardVO) {
        boardVO.setPostNo(postNo);
        boardMap.put(boardVO.getPostNo(), boardVO);
    }

    public void delete(int postNo){
        boardMap.remove(postNo);
    }

}
