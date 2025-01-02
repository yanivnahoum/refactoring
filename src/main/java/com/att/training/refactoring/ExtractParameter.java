package com.att.training.refactoring;

import java.util.List;

/*
When should we extract parameters?
* Enhancing Reusability: When extracting parameters can help reuse the method in different contexts
with different values.
 */
class BeforeExtractParameter {
    public boolean isAnyoneOverAge18(List<Person> persons) {
        return persons.stream()
                .anyMatch(person -> person.age() >= 18);
    }

    public boolean isAnyoneOverAge60(List<Person> persons) {
        return persons.stream()
                .anyMatch(person -> person.age() >= 60);
    }
}

class AfterExtractParameter {
    public boolean isAnyoneOverAge18(List<Person> persons) {
        return isAnyoneOverAge(persons, 18);
    }

    public boolean isAnyoneOverAge60(List<Person> persons) {
        return isAnyoneOverAge(persons, 60);
    }

    private boolean isAnyoneOverAge(List<Person> persons, int age) {
        return persons.stream()
                .anyMatch(person -> person.age() >= age);
    }
}
