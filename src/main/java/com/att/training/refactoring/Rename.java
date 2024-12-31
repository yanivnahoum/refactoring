package com.att.training.refactoring;

import lombok.extern.slf4j.Slf4j;

/*
 Why should we care about naming?
 * Improves Readability: Clear and descriptive names make the code easier to understand.
 * Enhances Maintainability: Code is easier to maintain and modify when the purpose of variables and methods is clear.
 * Reduces Cognitive Load: Developers can grasp the functionality without having to decipher ambiguous or misleading names.

 Best Practices for Naming
 * Be Descriptive: Names should explain the purpose and usage.
 * Use Pronounceable Names: If you can’t pronounce it, you can’t discuss it without sounding awkward.
 * Avoid Encodings: Don’t use prefixes or suffixes that add no meaningful information.
 * Use Searchable Names: Ensure that the names are searchable and not generic.

Naming Conventions
* Class/Interface Names: Should be nouns and written in PascalCase.
* Method Names: Should be verbs or verb phrases and written in camelCase.
* Variable Names: Should be nouns and written in camelCase.
  * Use plural for collections (list/arrays/sets)
  * Use ValuesByKey for maps. Another option is keyToValue
* Constant Names (private static final immutable types): Should be written in uppercase with words separated by underscores.
* Package Names: Should be written in lowercase and follow the reverse domain name convention.
* Enums: single
* Enum Instances: Should be written in uppercase with words separated by underscores.

String baseUrl = ...
class UserDao {...} // not UserDAO

When naming public methods, think about the use site (where it'll get called):
class OrderProcessor {
    public void process() {...} // not processOrder()  ==> orderProcessor.process() is less redundant
}
int orderCount; // not cnt
private static final int MAX_RETRIES = 3;
package org.springframework.beans; // not org.spring_framework.beans or org.springFramework.beans
enum Status { // not StatusEnum or Statuses
    NOT_RUNNING, PENDING, RUNNING, COMPLETED
}
*/

record Customer(long id, String fullName, double credit) {}

record Order(double total, double discount, Customer customer) {}

@Slf4j
class OrderProcessor {
    public void p(Order o) {
        // total price
        double t = o.total();
        // discount
        double d = o.discount();
        // customer credit
        double c = o.customer().credit();

        if (t > 100) {
            d = t * 0.10;
        }

        t = t - d;

        if (c >= t) {
            log.info("Order processed successfully");
        } else {
            log.info("Insufficient credit");
        }
    }
}
