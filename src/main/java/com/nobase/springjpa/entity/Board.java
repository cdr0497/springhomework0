package com.nobase.springjpa.entity;

import com.nobase.springjpa.dto.CreateBoardRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity // 엔티티는 유일해야함. 유일성을 띄게하기 위해 @Id 를 만들어준다.
@NoArgsConstructor  // 기본 생성자 없으면 에러 난다 = > 나중에 JPA 에서 sql 작성할 때 필요하다는 모양이다.
public class Board extends TimeStamp {
    // 제목, 작성자명, 작성 내용, 작성 날짜를 조회하기
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String writer;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String password;
    //작성 날짜는 상속 받아 처리함.



    public Board(CreateBoardRequest createBoardRequest) {
        this.title = createBoardRequest.getTitle();
        this.writer = createBoardRequest.getWriter();
        this.password = createBoardRequest.getPassword();
        this.content = createBoardRequest.getContent();
    }

    public void update(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    public boolean isValidPassword(String inputPassword){
        if(inputPassword.equals(this.password)) {
            return true;
        }else{
            return false;
        }
    }
}
