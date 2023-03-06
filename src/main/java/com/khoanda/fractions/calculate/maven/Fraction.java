/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.khoanda.fractions.calculate.maven;

/**
 *
 * @author Admin
 */
public class Fraction {

    int numerator;
    int denominator;

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add(Fraction f) {
        int newDenominator = this.denominator * f.denominator;
        int newNumerator = this.numerator * f.denominator + this.denominator * f.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction sub(Fraction f) {
        int newDenominator = this.denominator * f.denominator;
        int newNumerator = this.numerator * f.denominator - this.denominator * f.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction mul(Fraction f) {
        int newDenominator = this.denominator * f.denominator;
        int newNumerator = this.numerator * f.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction div(Fraction f) {
        int newDenominator = this.denominator * f.numerator;
        int newNumerator = this.numerator * f.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public int GCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }

    public void simplify() {
        int GCD = GCD(this.numerator, this.denominator);
        this.numerator = this.numerator / GCD;
        this.denominator = this.denominator / GCD;

        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }

    public static String printFraction(Fraction f) {
        f.simplify();
        return f.numerator + "/" + f.denominator;
    }

}
