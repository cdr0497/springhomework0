package com.nobase.springjpa.service;

import com.nobase.springjpa.dto.BoardRequest;
import com.nobase.springjpa.entity.Board;
import com.nobase.springjpa.repository.BoardListMapping;
import com.nobase.springjpa.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public Board createPost(BoardRequest boardRequest) {
        Board board = new Board(boardRequest);
        boardRepository.save(board);
        return board;
    }

    public List<BoardListMapping> callBoardList() {
        return boardRepository.findAllBy();
        // 특정 정보는 빼고 반환하는 방법.
        // ... 검색해보자.
        //
    }
}
