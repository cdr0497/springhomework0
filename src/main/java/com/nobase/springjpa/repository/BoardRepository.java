package com.nobase.springjpa.repository;

import com.nobase.springjpa.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}