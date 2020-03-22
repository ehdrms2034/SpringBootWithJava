package com.donggeun.springSecurity.repository;

import com.donggeun.springSecurity.model.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {

    Member findByUsername(String username);

}
