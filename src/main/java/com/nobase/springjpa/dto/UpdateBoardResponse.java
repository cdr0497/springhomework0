package com.nobase.springjpa.dto;

import com.nobase.springjpa.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UpdateBoardResponse {
    private String title;
    private String writer;
    private String content;

    public UpdateBoardResponse(Board tempBoard) {
        this.title = tempBoard.getTitle();
        this.writer = tempBoard.getWriter();
        this.content = tempBoard.getContent();
    }
}
