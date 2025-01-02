package com.att.training.refactoring;

import lombok.RequiredArgsConstructor;

/*
When should we extract fields?
* Shared Values: When a value is used in multiple methods and should be stored in a single location
to ensure consistency.
* Repeated Calculations: When a calculation or value is repeatedly computed in multiple methods,
extracting it to a field can enhance performance and readability.
 */
class BeforeExtractField {

    static class Order {
        public double calculateTotalPrice(double basePrice, double taxRate) {
            double taxAmount = basePrice * taxRate;
            return basePrice + taxAmount;
        }

        public double calculateDiscountedPrice(double basePrice, double taxRate, double discountRate) {
            double taxAmount = basePrice * taxRate;
            double discountedPrice = basePrice - (basePrice * discountRate);
            return discountedPrice + taxAmount;
        }
    }

    static class RectangleCalculator {
        public double calculateArea(double length, double width) {
            return length * width;
        }

        public double calculatePerimeter(double length, double width) {
            return 2 * (length + width);
        }
    }
}

class AfterExtractField {

    @RequiredArgsConstructor
    static class Order {
        private final double taxRate;

        public double calculateTotalPrice(double basePrice) {
            double taxAmount = basePrice * taxRate;
            return basePrice + taxAmount;
        }

        public double calculateDiscountedPrice(double basePrice, double discountRate) {
            double taxAmount = basePrice * taxRate;
            double discountedPrice = basePrice - (basePrice * discountRate);
            return discountedPrice + taxAmount;
        }
    }

    @RequiredArgsConstructor
    static class RectangleCalculator {
        private final double length;
        private final double width;

        public double calculateArea() {
            return length * width;
        }

        public double calculatePerimeter() {
            return 2 * (length + width);
        }
    }
}
