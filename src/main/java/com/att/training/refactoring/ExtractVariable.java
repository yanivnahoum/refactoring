package com.att.training.refactoring;

/*
When to Use Extract Variable
* Complex Expressions: When you have a long or complicated expression, extracting parts of it into variables can make the code clearer.
* Repeated Expressions: If the same expression is used multiple times, extracting it into a variable can reduce redundancy.
* Magic Numbers/Strings: When you have hard-coded values (magic numbers or strings), extracting them into meaningful variables can make the code self-explanatory.
* Improving Readability: When the intention of the code is not immediately clear, extracting variables can make the purpose of each part of the expression more obvious.
*/

record Person(String name, int age) {}

class BeforeExtractVariable {
    public double calculateFinalPrice(double price, int quantity, double discount) {
        return price * quantity - discount + (price * quantity - discount) * 0.18; // 18% VAT
    }

    public boolean isEligibleForDiscount(int age, double totalAmount) {
        return age >= 60 && totalAmount > 1000;
    }
}

class AfterExtractVariable {
    private static final double VAT = 0.18;

    // Extract variable & constant
    public double calculateFinalPrice(double price, int quantity, double discount) {
        double totalPrice = price * quantity;
        double discountedPrice = totalPrice - discount;
        double tax = discountedPrice * VAT;
        return discountedPrice + tax;
    }

    public boolean isEligibleForDiscount(int age, double totalAmount) {
        // Now it's clear why we're testing for age > 60
        boolean isSeniorCitizen = age >= 60;
        return isSeniorCitizen && totalAmount > 1000;
    }
}
