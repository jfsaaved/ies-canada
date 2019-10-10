package com.jfsaaved.repository;

import com.jfsaaved.modules.Answer;
import com.jfsaaved.modules.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
    List<Answer> findAllByOrderByIdAsc();
}
