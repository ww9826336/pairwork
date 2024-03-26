package main;

import java.io.*;

public class CorrectExpression {
    //checkFile是输入进来的待检测答案文件
    //answerFile是系统根据题目做出来的正确答案
    public static void check(String checkFile ,String answersFile) throws IOException {
        BufferedReader readerCheck = new BufferedReader(new InputStreamReader(new FileInputStream(checkFile)));
        BufferedReader answerCheck = new BufferedReader(new InputStreamReader(new FileInputStream(answersFile)));
        String checkLine = "";
        String answerLine = "";
        String correct = "";
        String wrong = "";
        int correctNum = 0;
        int wrongNum = 0;
        while ((checkLine = readerCheck.readLine()) != null && (answerLine = answerCheck.readLine()) != null){
            String[] checkString = checkLine.split("\\.");//将答案编号与答案分割
            String[] answerString = answerLine.split("\\.");
            if(checkString[1].equals(answerString[1])){//如果答案相同则操作correct字符串
                if (correct.equals("")){//如果是第一个相同答案则直接添加编号
                    correct = answerString[0];
                    correctNum++;
                }
                else{
                    correct = correct+","+answerString[0];
                    correctNum++;
                }
            }else{//同理如果答案不一致则操作wrong字符串
                if (wrong.equals("")){
                    wrong = answerString[0];
                    wrongNum++;
                }
                else{
                    wrong = wrong+","+answerString[0];
                    wrongNum++;
                }
            }
        }
        readerCheck.close();
        answerCheck.close();
        OutputStreamWriter resultWriter = new OutputStreamWriter(new FileOutputStream(new File("D:\\Grade.txt")), "UTF-8");
        resultWriter.append("Correct:"+correctNum+"("+correct+")");
        resultWriter.append("\n");
        resultWriter.append("Wrong:"+wrongNum+"("+wrong+")");
        resultWriter.close();
        System.out.println("Correct:"+correctNum+"("+correct+")");
        System.out.println("Wrong:"+wrongNum+"("+wrong+")");
    }
}
