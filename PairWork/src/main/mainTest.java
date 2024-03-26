package main;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class mainTest {
    @Test
    public void TestMain() throws IOException {
        //随机生成题目测试
        String[] args={"-n10","-r10"};
        main.main(args);
        System.out.println("------------------");


        //判断对错
        String[] args1={"-eD:\\Exercises.txt","-aD:\\Answers.txt"};
        main.main(args1);
        System.out.println("------------------");


        //全部正确传入
        String[] args2={"-n10","-r10","-eD:\\Exercises.txt","-aD:\\Answers.txt"};
        main.main(args2);
        System.out.println("------------------");


        //错误输入
        String[] args3={"-n10"};
        main.main(args3);
        System.out.println("------------------");


        //不成对出现正确参数
        String[] args4={"-n10","-eD:\\Exercises.txt"};
        main.main(args4);
        System.out.println("-------------------");


        //输入三个参数
        String[] args5={"-r10","-n10","-eD:\\Exercises.txt"};
        main.main(args5);
        System.out.println("-------------------");
    }
}