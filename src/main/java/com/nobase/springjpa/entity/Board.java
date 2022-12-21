package com.nobase.springjpa.entity;

import com.nobase.springjpa.dto.BoardRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
public class Board extends TimeStamp {
    // 제목, 작성자명, 작성 내용, 작성 날짜를 조회하기
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String writer;
    private String content;
    private String password;
    //작성 날짜는 상속 받아 처리함.

    public Board(BoardRequest boardRequest) {
        this.title = boardRequest.getTitle();
        this.writer = boardRequest.getWriter();
        this.password = boardRequest.getPassword();
        this.content = boardRequest.getContent();
    }
}
