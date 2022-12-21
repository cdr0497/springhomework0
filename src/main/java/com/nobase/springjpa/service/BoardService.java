package com.nobase.springjpa.service;

import com.nobase.springjpa.dto.BoardRequest;
import com.nobase.springjpa.entity.Board;
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

    public List<Board> callBoardList() {
        return boardRepository.findAll();
    }
}
