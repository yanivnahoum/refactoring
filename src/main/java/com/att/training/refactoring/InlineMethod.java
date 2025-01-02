package com.att.training.refactoring;

/*
When should we inline methods?
* Simple Methods: When a method's body is very simple, such as a single line of code, and does not add
significant abstraction.
* Redundant Methods: When a method simply delegates to another method without adding additional logic or value.
 */
class BeforeInlineMethod {
    record Rectangle(int width, int length) {
        public int getArea() {
            return calculateArea();
        }

        private int calculateArea() {
            return width * length;
        }
    }
}

class AfterInlineMethod {
    record Rectangle(int width, int length) {
        public int getArea() {
            return width * length;
        }
    }
}
