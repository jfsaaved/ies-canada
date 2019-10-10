package com.jfsaaved.service;


import com.jfsaaved.modules.Answer;
import com.jfsaaved.modules.Question;
import com.jfsaaved.repository.AnswerRepository;
import com.jfsaaved.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    private AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        super();
        this.answerRepository = answerRepository;
    }

    public List<Answer> list(){
        return answerRepository.findAllByOrderByIdAsc();
    }

    public Answer get(Long id){
        return answerRepository.findById(id).orElse(null);
    }

    public void save(Answer answer){
        answerRepository.save(answer);
    }
}
