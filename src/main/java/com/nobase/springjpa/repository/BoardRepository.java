package com.nobase.springjpa.repository;

import com.nobase.springjpa.dto.BoardResponse;
import com.nobase.springjpa.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByOrderByModifiedAtDesc();


}
