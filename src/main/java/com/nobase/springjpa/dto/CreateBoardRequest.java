package com.nobase.springjpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
public class CreateBoardRequest {

    private final String title;
    private final String writer;
    private final String content;
    private final String password;
}
