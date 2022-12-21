package com.nobase.springjpa.dto;

import com.nobase.springjpa.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponse {
    // 제목, 작성자명, 작성 내용, 작성 날짜
    private String title;
    private String writer;
    private String content;
    private String createdAt;

    public BoardResponse(Board board) {
        this.title = board.getTitle();
        this.writer = board.getWriter();
        this.content = board.getContent();
        this.createdAt = String.valueOf(board.getCreatedAt());
    }
}
