package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionParsingTest {
    @Test
    public void evaluateTest(){
        String[] args={"1+7=","(13+5)-8=","3×4+7'5/4=","3÷4+5'1/4"};
        //简单加法测试
        Fraction test1=ExpressionParsing.evaluate(args[0]);
        System.out.println(test1.toString());
        System.out.println("-------------------");

        //复杂加减法测试
        Fraction test2=ExpressionParsing.evaluate(args[1]);
        System.out.println(test2.toString());
        System.out.println("-------------------");


        //引入真分数以及乘法测试
        Fraction test3=ExpressionParsing.evaluate(args[2]);
        System.out.println(test3.toString());
        System.out.println("-------------------");


        //引入真分数以及除法测试
        Fraction test4=ExpressionParsing.evaluate(args[3]);
        System.out.println(test4.toString());
        System.out.println("-------------------");
    }

}