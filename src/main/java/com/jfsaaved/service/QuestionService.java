package com.jfsaaved.service;

import com.jfsaaved.modules.Question;
import com.jfsaaved.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        super();
        this.questionRepository = questionRepository;
    }

    public List<Question> list(){
        return questionRepository.findAllByOrderByQuestionAsc();
    }

    public Question get(Long id){
        return questionRepository.findById(id).orElse(null);
    }

    public void save(Question question){
        questionRepository.save(question);
    }
}
