package com.nobase.springjpa.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
public class BoardRequest {

    private String title;
    private String writer;
    private String content;
    private String password;
}
