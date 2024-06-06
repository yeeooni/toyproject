package com.springboot.toyproject.repository;

import com.springboot.toyproject.vo.BoardVO;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardRepository {
    //DB를 연결하기 전 임시로 Map을 형성하여 처리하도록 구현
    //서버 재기동 시 모든 데이터는 초기화 됨

    private final Map<Integer, BoardVO> boardMap = new HashMap<>();
    private static int seq = 0;

    public void write(BoardVO boardVO) {
        boardVO.setNo(++seq);
        boardMap.put(boardVO.getNo(), boardVO);
    }

    public void edit(int no, BoardVO boardVO) {
        boardVO.setNo(no);
        boardMap.put(boardVO.getNo(), boardVO);
    }

    public void delete(int no){
        boardMap.remove(no);
    }

    public List<BoardVO> list() {
        return new ArrayList<>(boardMap.values());
    }

    public BoardVO view(int no) {
        return boardMap.get(no);
    }

}
