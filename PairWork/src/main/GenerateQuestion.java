package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateQuestion {
    public static List<Question> generateQuestions(int numberOfQuestions,int MaxNumber) {
        List<Question> questions = new ArrayList<>();
        for (int i = 1; i <= numberOfQuestions; i++) {
            String expression = GenerateExpression.generateExpression(2, 4,MaxNumber);
            Fraction Tanswer=ExpressionParsing.evaluate(expression);
            if(Tanswer.numerator<0||Tanswer.denominator<0)
            {
                i--;
                continue;
            }
            String answer = ExpressionParsing.evaluate(expression).toString();
            questions.add(new Question(i, expression, answer));
        }
        return questions;
    }
}
