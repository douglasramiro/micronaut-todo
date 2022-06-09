package com.amazon.wwso.fc.repository;

import com.amazon.wwso.fc.model.Todo;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
}
