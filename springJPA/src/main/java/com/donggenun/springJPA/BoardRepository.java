package com.donggenun.springJPA;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board,Long> {

    List<Board> findByTitle(String searchKeyword);

    Page<Board> findByTitleContaining(String keyword, Pageable paging);
}
