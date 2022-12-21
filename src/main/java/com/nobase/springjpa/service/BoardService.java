package com.nobase.springjpa.service;

import com.nobase.springjpa.dto.BoardRequest;
import com.nobase.springjpa.dto.BoardResponse;
import com.nobase.springjpa.entity.Board;
import com.nobase.springjpa.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Transactional(readOnly = true)
    public List<BoardResponse> getBoards() {

        List<Board> boardList = boardRepository.findAllByOrderByModifiedAtDesc();
        List<BoardResponse> boardResponseList = new ArrayList<>();
        for (Board board : boardList) {
            boardResponseList.add(new BoardResponse(board));
        }
        return boardResponseList;
        // 특정 정보는 빼고 반환하는 방법.
        // ... 검색해보자.
        //
    }
}
