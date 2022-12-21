package com.nobase.springjpa.repository;

public interface BoardListMapping {
    //제목, 작성자명, 작성 내용, 작성 날짜를 조회하기
    public String getTitle();
    public String getWriter();
    public String getContent();

}
