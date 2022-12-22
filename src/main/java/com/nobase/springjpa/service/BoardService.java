package com.nobase.springjpa.service;

import com.nobase.springjpa.dto.CreateBoardRequest;
import com.nobase.springjpa.dto.CallBoardResponse;
import com.nobase.springjpa.dto.UpdateBoardRequest;
import com.nobase.springjpa.dto.UpdateBoardResponse;
import com.nobase.springjpa.entity.Board;
import com.nobase.springjpa.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Call;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    // 게시글 생성
    public Board createPost(CreateBoardRequest createBoardRequest) {
        Board board = new Board(createBoardRequest);
        boardRepository.save(board);
        return board;
    }
    // 게시글 전체 조회
    @Transactional(readOnly = true)
    public List<CallBoardResponse> getBoards() {

        List<Board> boardList = boardRepository.findAllByOrderByModifiedAtDesc();
        List<CallBoardResponse> callBoardResponseList = new ArrayList<>();
        for (Board board : boardList) {
            callBoardResponseList.add(new CallBoardResponse(board));
        }
        return callBoardResponseList;
        // 특정 정보는 빼고 반환하는 방법.
        // ... 검색해보자.
        //
    }

    // 특정 게시글 조회
    public CallBoardResponse getBoards(Long boardId){
        Board board = boardRepository.findById(boardId).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없소"));
        CallBoardResponse callBoardResponse = new CallBoardResponse(board);
        return callBoardResponse;
    }

    // 게시글 수정
    @Transactional // 이놈 달아두면 repository.save() 안 해도 저장이 된다.
    public UpdateBoardResponse updateBoard(Long boardId, UpdateBoardRequest updateBoardRequest) {
        Board tempBoard = boardRepository.findById(boardId).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없소"));
        if(tempBoard.isValidPassword(updateBoardRequest.getPassword())){
            tempBoard.update(updateBoardRequest.getTitle(), updateBoardRequest.getWriter(), updateBoardRequest.getContent());
            UpdateBoardResponse updateBoardResponse = new UpdateBoardResponse(tempBoard);
            return updateBoardResponse;
        }else {
            throw new IllegalStateException("없따!");
        }
    }


    public void deleteBoard(Long boardId, String inPutPassword) {
        Board tempBoard = boardRepository.findById(boardId).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없소"));

        if(tempBoard.isValidPassword(inPutPassword)){
            boardRepository.delete(tempBoard);
        }else {
            throw new IllegalStateException("잘못된 비번임");
        }
    }
}