package com.sparta.item02.repository;

import com.sparta.item02.domain.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {

    List<Memo> findAllByOrderByUpdatedAtDesc();
}
