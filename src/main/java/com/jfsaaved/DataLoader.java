package com.jfsaaved;

import com.jfsaaved.modules.Answer;
import com.jfsaaved.modules.Question;
import com.jfsaaved.service.AnswerService;
import com.jfsaaved.service.QuestionService;
import com.jfsaaved.solutions.Day1Solutions;
import com.jfsaaved.solutions.Day2Solutions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class DataLoader  {

    QuestionService questionService;
    AnswerService answerService;
    Day1Solutions day1Solutions;
    Day2Solutions day2Solutions;

    @Autowired
    public DataLoader(QuestionService questionService, AnswerService answerService){
        this.questionService = questionService;
        this.answerService = answerService;
        day1Solutions = new Day1Solutions();
        day2Solutions = new Day2Solutions();
    }

    @PostConstruct
    public void loadData() {
        Question question1_3= new Question("1","3",
                "Complete the definition of the method count so that it returns the number of occurrences of the character c in the string s.\n" +
                        "public static int count (char c, String s)\n");
        Answer answer1_3_1 = new Answer(question1_3, "count(\'a\',\"Saavedra\")", day1Solutions.count('a',"Saavedra") + "");
        Answer answer1_3_2 = new Answer(question1_3, "count(\'a\',\"Svedr\")", day1Solutions.count('a',"Svedr") + "");
        Answer answer1_3_3 = new Answer(question1_3, "count(\' \',\"Saavedra\")", day1Solutions.count(' ',"Saavedra") + "");
        Answer answer1_3_4 = new Answer(question1_3, "count(\'a\',\"\")", day1Solutions.count('a',"") + "");
        questionService.save(question1_3);
        answerService.save(answer1_3_1);
        answerService.save(answer1_3_2);
        answerService.save(answer1_3_3);
        answerService.save(answer1_3_4);

        Question question1_4 = new Question("1","4",
                " Complete the definition of the method replace so that it returns a string in which all occurrences of oldChar in the string s are replaced by newChar.\n" +
                        "public static String replace (String s, char oldChar, char newChar)\n");
        Answer answer1_4_1 = new Answer(question1_4, "replace(\"Saavedra\",\'a\',\'b\')",day1Solutions.replace("Saavedra",'a','b'));
        Answer answer1_4_2 = new Answer(question1_4, "replace(\"Saavedra\",\'z\',\'b\')",day1Solutions.replace("Saavedra",'z','b'));
        questionService.save(question1_4);
        answerService.save(answer1_4_1);
        answerService.save(answer1_4_2);

        Question question1_5 = new Question("1","5",
                "A hetero-literal word pair is defined as a pair of words having no letters in common.\n" +
                        "As examples, \"TERRY\" and \"FOX\" form a hetero-literal word pair\n" +
                        "\"WAYNE\" and \"GRETZKY\" do not (because of the ’E’ and ’Y’ in each word).\n" +
                        "Write a method called isHeteroPair that has two String parameters, wordA and wordB. The method should return a boolean value:\n" +
                        "true if wordA and wordB form a hetero-literal word pair and false if they do not. You may assume that all characters are uppercase letters.\n");
        Answer answer1_5_1 = new Answer(question1_5, "isHeteroPair(\"Hello\",\"Help\")", day1Solutions.isHeteroPair("Hello","Help") + "");
        Answer answer1_5_2 = new Answer(question1_5, "isHeteroPair(\"Terry\",\"Fox\")", day1Solutions.isHeteroPair("Terry","Fox") + "");
        questionService.save(question1_5);
        answerService.save(answer1_5_1);
        answerService.save(answer1_5_2);

        Question question2_1 = new Question("2","1",
                "Write a method that reverse a String:\n" +
                        "Input: s = “asdf”\n" +
                        "Output: s = “fdsa”\n" +
                        "Input: s = “Reverse a string”\n" +
                        "Output: s = “gnirts a esreveR”\n");

        Answer answer2_1_1 = new Answer(question2_1, "reverseString(\"Reverse a string\")", day2Solutions.reverseString("Reverse a string"));
        Answer answer2_1_2 = new Answer(question2_1, "reverseString(\"Saavedra\")",day2Solutions.reverseString("Saavedra"));
        Answer answer2_1_3 = new Answer(question2_1, "reverseString(\"Saavdra\")",day2Solutions.reverseString("Saavdra"));
        questionService.save(question2_1);
        answerService.save(answer2_1_1);
        answerService.save(answer2_1_2);
        answerService.save(answer2_1_3);

        Question question2_2 = new Question("2","2",
                "Write a method that compare 2 strings and return a Boolean (True / False)\n" +
                        "Boolean isEquals(String s1, String s2)\n" +
                        "String s1 = “Hello World”\n" +
                        "String s2 = “Hello world”\n" +
                        "Return = False\n" +
                        "Not to use String.equals \n");
        Answer answer2_2_1 = new Answer(question2_2, "isEquals(\"Hello World\", \"Hello world\")", day2Solutions.isEquals("Hello World", "Hello world") + "");
        Answer answer2_2_2 = new Answer(question2_2, "isEquals(\"\",\"test\")",day2Solutions.isEquals("","test")+"");
        questionService.save(question2_2);
        answerService.save(answer2_2_1);
        answerService.save(answer2_2_2);

    }

}
