package com.nobase.springjpa.controller;

import com.nobase.springjpa.dto.BoardRequest;
import com.nobase.springjpa.dto.BoardResponse;
import com.nobase.springjpa.entity.Board;
import com.nobase.springjpa.service.BoardService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    // 게시글 작성 - 저장된 게시글 Client로 반환
    @PostMapping("/boards")
    public Board writePost(@RequestBody BoardRequest boardRequest){

        return boardService.createPost(boardRequest);
    }
    // 게시글 조회 -
    // 게시글 전체 조회 - 최신순 정렬

   @GetMapping("/boards")
    public List<BoardResponse> getBoards(){
        return boardService.getBoards();
    }


    // 게시글 수정
    // 게시글 삭제
    /*@DeleteMapping("/posts/{id}")
    public String deletePost() {
    }*/



}
