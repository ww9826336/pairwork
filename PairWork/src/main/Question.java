package main;

public class Question {
    private  final int questionNumber;
    private final String expression;
    private final String answer;

    public Question(int questionNumber, String expression, String answer) {
        this.questionNumber = questionNumber;
        this.expression = expression;
        this.answer = answer;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public String getExpression() {
        return expression;
    }

    public String answerString(){
        return questionNumber + ". " +answer;
    }

    @Override
    public String toString() {
        return  questionNumber + ". " + expression + " = " ;
    }

}
