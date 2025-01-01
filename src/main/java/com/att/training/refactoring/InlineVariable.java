package com.att.training.refactoring;

/*
When to Use Inline Variable
* Single Use Variables: When a variable is assigned a value and then used only once,
inlining the variable can reduce unnecessary complexity.
* Redundant Variables: When a variable merely holds an intermediate result that doesn't need a separate name.
* Improving Readability: When the variable name does not add additional clarity or context to the code.
* Eliminating Temporary Variables: To reduce the number of temporary variables and simplify the code structure.
 */

import lombok.extern.slf4j.Slf4j;

@Slf4j
class BeforeInlineVariable {
    double calculateTotalPrice(double price, int quantity) {
        double totalPrice = price * quantity;
        return totalPrice;
    }

    void log(Person person) {
        var name = person.name();
        var age = person.age();
        log.info("Name: {}, Age: {}", name, age);
    }
}

@Slf4j
class AfterInlineVariable {
    double calculateTotalPrice(double price, int quantity) {
        return price * quantity;
    }

    void log(Person person) {
        log.info("Name: {}, Age: {}", person.name(), person.age());
    }
}
