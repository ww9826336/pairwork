package main;

public class Fraction {
    public int numerator;  // 分子
    public int denominator;  // 分母

    // 构造函数
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        //if (numerator < 0 || denominator < 0) {
            //throw new IllegalArgumentException("Both numerator and denominator must be positive");
        //}
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    // 约分
    private void reduce() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    // 计算最大公约数
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // 加法
    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + this.denominator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // 减法
    public Fraction subtract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - this.denominator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // 乘法
    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // 除法
    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    // 转换为字符串
    @Override
    public String toString() {
        if(numerator==0)return numerator+"";
        if(Math.abs(numerator)>=Math.abs(denominator)){
            if(denominator==1)return numerator+"";
            else if(denominator==-1)return -numerator+"";
            else
            {
                int whole=numerator/denominator;
                return whole+"'"+(numerator-whole*denominator)+"/"+denominator;
            }
        }

        return numerator + "/" + denominator;
    }

}
