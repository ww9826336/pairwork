package main;

import java.util.Stack;

public class ExpressionParsing {
    // 计算表达式的值
    public static Fraction evaluate(String expression) {
        Stack<Character> operators = new Stack<>();
        Stack<Fraction> value = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                // 处理多位数，例如"123"
                int number = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    number = number * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                int denominator=1;
                int numerator=number;
                //真分数处理,’后面是形如8/9的形式，共占据4个字符
                if(i < expression.length() && expression.charAt(i)=='\''){
                    i++;
                    numerator = (expression.charAt(i++)-'0');
                    i++;
                    denominator = (expression.charAt(i++)-'0');
                    numerator+=number*denominator;
                }
                else if(i < expression.length() && expression.charAt(i)=='/'){
                    i++;
                    denominator= (expression.charAt(i++)-'0');
                }
                value.push(new Fraction(numerator,denominator));
                i--; // 因为for循环也会增加i，所以需要减一以避免跳过字符
            } else if(c==' '||c=='=') {
            }//遇到空格符救跳过；
            else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                // 计算括号内的表达式
                while (!operators.isEmpty() && operators.peek() != '(') {
                    value.push(applyOp(operators.pop(), value.pop(), value.pop()));
                }
                // 弹出左括号
                if (!operators.isEmpty()) {
                    operators.pop();
                }
            } else if (isOperator(c)) {
                while (!operators.isEmpty() &&operators.peek()!='('&& hasPrecedence(c, operators.peek())) {
                    value.push(applyOp(operators.pop(), value.pop(), value.pop()));
                }
                operators.push(c);
            }
        }

        // 处理剩余的运算符
        while (!operators.isEmpty()) {
            value.push(applyOp(operators.pop(), value.pop(), value.pop()));
        }
        return value.pop();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '×' || c == '÷';
    }

    private static Fraction applyOp(char op, Fraction f1, Fraction f2) {
        switch (op) {
            case '+': return f1.add(f2);
            case '-': return f2.subtract(f1);
            case '×': return f1.multiply(f2);
            case '÷': return f2.divide(f1); //
            default:return new Fraction(1,1);
        }
    }

    private static boolean hasPrecedence(char op1, char op2) {//op1的优先级更低或相等时返回true;
        return (op1 != '×' && op1 != '÷') || (op2 != '+' && op2 != '-');
    }
}

