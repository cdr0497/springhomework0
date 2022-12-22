package com.nobase.springjpa.controller;

import com.nobase.springjpa.dto.CreateBoardRequest;
import com.nobase.springjpa.dto.CallBoardResponse;
import com.nobase.springjpa.dto.UpdateBoardRequest;
import com.nobase.springjpa.dto.UpdateBoardResponse;
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
    public Board writePost(@RequestBody CreateBoardRequest createBoardRequest){
        return boardService.createPost(createBoardRequest);
    }
    // 게시글 조회 -
    // 게시글 전체 조회 - 최신순 정렬
   @GetMapping("/boards")
    public List<CallBoardResponse> getBoards(){
        return boardService.getBoards();
    }
    // 특정 게시글 조회
    @GetMapping("boards/{boardId}")
    public CallBoardResponse getBoard(@PathVariable Long boardId) {
        return boardService.getBoards(boardId);
    }

    // 게시글 수정
    @PutMapping("boards/{boardId}")
    public UpdateBoardResponse updateBoard(@PathVariable Long boardId, @RequestBody UpdateBoardRequest updateBoardRequest){
        return boardService.updateBoard(boardId, updateBoardRequest);
    }
    // 데이터와 비빌번호를 같이 받아 서버에서 비밀번호 일치 여부 확인 후  제목,작성자명,작성 내용 수정하고 클라이언트로 반환
    // 게시글 삭제
    // ㅔ param > parameter > /posts/1?inputPassword= 123
    @DeleteMapping("/boards/{boardId}") // @DeleteMapping 은 Body 를 보내지 못한다.
    public String deletePost(@PathVariable Long boardId, @RequestParam String inputPassword) {   //@RequestParam? 파라미터 ? 매개변수 ? 지정 매겨변수 1개
        return boardService.deleteBoard(boardId, inputPassword);
    }



}
