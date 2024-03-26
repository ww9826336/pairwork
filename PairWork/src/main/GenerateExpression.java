package main;

import java.util.Random;

public class GenerateExpression {
    private static final String[] OPERATORS = {"+", "-", "×", "÷"};
    private static final int MIN_OPERAND = 1;   // 假设操作数的最小值为1
    private static final int MIN_EXPRESSION_PARTS = 2; // 表达式至少包含两部分（两个操作数和一个操作符）
    private static final int MAX_RECURSION_DEPTH = 3; // 表达式的最大递归深度
    private static final Random random=new Random();

    public static String generateExpression(int minParts, int maxParts,int MaxNumber) {
        if (minParts > maxParts || minParts < MIN_EXPRESSION_PARTS) {
            throw new IllegalArgumentException("Invalid range for expression parts");
        }

        int parts = minParts + random.nextInt(maxParts - minParts + 1);

        if (parts<3) {
            return generateSimpleExpression(parts,MaxNumber);
        } else {
            return generateComplexExpression(parts,MaxNumber);
        }
    }

    private static String generateSimpleExpression(int parts,int MaxNumber) {
        StringBuilder sb = new StringBuilder();
        if(parts==1){
            if(random.nextBoolean()) sb.append(generateTrueFraction(MaxNumber));
            else sb.append(generateOperand(MaxNumber));
            sb.append(' ');
            return sb.toString();
        }
        int flat=0;
        for (int i = 0; i < parts - 1; i++) {
            if(random.nextInt(5)==1) sb.append(generateTrueFraction(MaxNumber));
            else sb.append(generateOperand(MaxNumber));
            sb.append(' ');
            String Op;
            Op=OPERATORS[random.nextInt(OPERATORS.length)];
            if(Op=="-")flat++;
            sb.append(Op);
            sb.append(' ');
        }
        if(random.nextInt(5)==1) sb.append(generateTrueFraction(MaxNumber));
        else sb.append(generateOperand(MaxNumber));
        //
        /*if(flat!=0 ) {
            String str = sb.toString();
            String[] calculate = str.split("-");
            Fraction f1 = ExpressionParsing.evaluate(calculate[0]);
            Fraction f2 = ExpressionParsing.evaluate(calculate[1]);
            Fraction f3 = f1.divide(f2);
            if (f3.numerator < f3.denominator) return generateSimpleExpression(parts, MaxNumber);
        }/* else if (calculate.length == 3) {
                f1 = f1.subtract(f2);
                f2 = ExpressionParsing.evaluate(calculate[2]);
                f3 = f1.divide(f2);
                if (f3.numerator < f3.denominator) return generateSimpleExpression(parts, MaxNumber);
            }
        }
            /*else if(calculate.length==4){
                f1=f1.subtract(f2);
                f2=ExpressionParsing.evaluate(calculate[2]);
                f3=f1.divide(f2);
                if(f3.numerator<f3.denominator)return  generateSimpleExpression(parts,MaxNumber);
                else{
                    f1=f1.subtract(f2);
                    f2=ExpressionParsing.evaluate(calculate[3]);
                    f3=f1.divide(f2);
                    if(f3.numerator<f3.denominator)return  generateSimpleExpression(parts,MaxNumber);
                }
            }
        }*/
        return sb.toString();
    }

    private static String generateComplexExpression(int parts, int MaxNumber) {
        if (random.nextBoolean() ) {
            return generateSimpleExpression(parts,MaxNumber);
        }
        int subParts = random.nextInt(parts-1)+1;
        String left = generateSimpleExpression(subParts,MaxNumber);
        String right = generateSimpleExpression(parts - subParts,MaxNumber);
        if(subParts==1||parts-subParts==1)
            return subParts==1?left+OPERATORS[random.nextInt(OPERATORS.length)] + "(" + right + ")":
                    "(" + left +")" + OPERATORS[random.nextInt(OPERATORS.length)] +right;
        return "(" + left +")" + OPERATORS[random.nextInt(OPERATORS.length)] + "(" + right + ")";
    }

    private static int generateOperand(int MAX_OPERAND) {
        return MIN_OPERAND + random.nextInt(MAX_OPERAND - MIN_OPERAND + 1);
    }
    public static String generateTrueFraction(int MAX_OPERAND){
        int denominator=random.nextInt(9)+1;//分母不等于0；
        int numerator=random.nextInt(9)+1;
        while (numerator >= denominator) {
            numerator = random.nextInt(9) + 1;
            denominator = random.nextInt(9) + 1;
        }
        int wholePart=random.nextInt(MAX_OPERAND);
        if(wholePart==0)return numerator+"/"+denominator;
        return wholePart+"'"+numerator+"/"+denominator;
    }

}
