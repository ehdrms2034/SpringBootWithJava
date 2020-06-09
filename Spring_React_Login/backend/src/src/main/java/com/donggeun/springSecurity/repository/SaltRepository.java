package com.donggeun.springSecurity.repository;

import com.donggeun.springSecurity.model.Salt;
import org.springframework.data.repository.CrudRepository;

public interface SaltRepository extends CrudRepository<Salt,Long> {

}
