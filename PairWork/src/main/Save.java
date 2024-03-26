package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Save {
    public static void saveQuestionsToFile(List<Question> questions, String fileName1) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName1))) {
            for (Question question : questions) {
                writer.write(question.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("无法保存题目到文件: " + e.getMessage());
        }
    }
        public static void saveAnswerToFile(List<Question> questions, String fileName1){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName1))) {
            for (Question question : questions) {
                writer.write(question.answerString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("无法保存答案到文件: " + e.getMessage());
        }
    }
}
