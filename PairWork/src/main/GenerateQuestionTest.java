package main;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenerateQuestionTest {
    @Test
    public void generateTest(){
        int[] numberOfQuestions={10,100,1000,10000};
        int[] maxNumber={1,10,100};
        //10道题生成
        List<Question> questions1=GenerateQuestion.generateQuestions(numberOfQuestions[0],maxNumber[0]);
        System.out.println(questions1);
        System.out.println("--------------");


        //100道题生成
        List<Question> questions2=GenerateQuestion.generateQuestions(numberOfQuestions[1],maxNumber[2]);
        System.out.println(questions2);
        System.out.println("--------------");

        //1000道题
        List<Question> questions3=GenerateQuestion.generateQuestions(numberOfQuestions[2],maxNumber[1]);
        System.out.println(questions3);
        System.out.println("--------------");


        //10000道题生成
        List<Question> questions4=GenerateQuestion.generateQuestions(numberOfQuestions[3],maxNumber[1]);
        System.out.println(questions1);
        System.out.println("--------------");
    }

}