package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
        int numberOfQuestions = -1; // 初始化为一个无效值
        int maxNumber = -1;
        String filename1 = "";
        String filename2 = "";
        if (args.length < 2) {
            System.err.println("输入参数至少两个");
            return;
        }
        for (String arg : args) {
            if (arg.startsWith("-n")) {
                try {
                    numberOfQuestions = Integer.parseInt(arg.substring(2));// -n后面的值控制题目的数目
                } catch (NumberFormatException e) {
                    System.err.println("Invalid argument after -n: " + arg);
                    System.exit(1); // 非零退出码表示错误
                }
                System.out.println(numberOfQuestions);
            }
            if (arg.startsWith("-r")) {
                try {
                    maxNumber = Integer.parseInt(arg.substring(2));// -n后面的值控制题目的数目
                } catch (NumberFormatException e) {
                    System.err.println("Invalid argument after -r: " + arg);
                    System.exit(1); // 非零退出码表示错误
                }
                System.out.println(maxNumber);
            }
            if (arg.startsWith("-e")) {
                try {
                    filename1 = arg.substring(2);// -n后面的值控制题目的数目
                } catch (NumberFormatException e) {
                    System.err.println("Invalid argument after -e: " + arg);
                    System.exit(1); // 非零退出码表示错误
                }
                System.out.println(filename1);
            }
            if (arg.startsWith("-a")) {
                try {
                    filename2 = arg.substring(2);// -n后面的值控制题目的数目
                } catch (NumberFormatException e) {
                    System.err.println("Invalid argument after -a: " + arg);
                    System.exit(1); // 非零退出码表示错误
                }
                System.out.println(filename2);
            }
        }
        if ((numberOfQuestions != -1 && maxNumber != -1) || (!filename1.equals("") && !filename2.equals("")))
            //如果参数同时结对出现
        {
            if (numberOfQuestions != -1 && maxNumber != -1)
                GenerateQuestion.generateQuestions(numberOfQuestions, maxNumber);
            if (!filename1.equals("") && !filename2.equals("")) {
                BufferedReader exercise = new BufferedReader(new InputStreamReader(new FileInputStream(filename1)));
                int QuestionNumber = 0;
                String Expression = "";
                List<Question> questions = new ArrayList<>();
                while ((Expression = exercise.readLine()) != null) {
                    QuestionNumber++;
                    String answer = ExpressionParsing.evaluate(Expression).toString();
                    questions.add(new Question(QuestionNumber, Expression, answer));
                }
                Save.saveAnswerToFile(questions, "D:\\SyAnswer.txt");//保存系统计算出的答案到文件中去
                CorrectExpression.check(filename2,"D:\\SyAnswer.txt");
            }

        }
        else
        {
            System.err.println("参数输入方式不对");
        }
    }
}
