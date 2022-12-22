package com.nobase.springjpa.dto;

import com.nobase.springjpa.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateBoardRequest {

    private String title;
    private String writer;
    private String content;
    private String password;

    public UpdateBoardRequest(Board board) {
        this.title = board.getTitle();
        this.writer = board.getWriter();
        this.content = board.getContent();
        this.password = board.getPassword();
    }
}
