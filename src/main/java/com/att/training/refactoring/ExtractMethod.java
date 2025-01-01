package com.att.training.refactoring;

/*
When should we extract methods?
* Large Methods: When a method is too long and does multiple things, extracting parts of it into
separate methods can improve clarity.
* Duplicated Code: When the same block of code is repeated in multiple places, extracting it into
a method can reduce redundancy.
* Improving Readability: When the intention of the code is not immediately clear, extracting methods
can make its purpose of more obvious.
 */

import lombok.experimental.StandardException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@StandardException
class ValidationException extends RuntimeException {}
record Student(String name, double mathGrade, double scienceGrade, double literatureGrade) {}

class BeforeExtractMethod {

    @Slf4j
    static class StudentReport {
        public void generate(Student student) {
            // Calculate average grade
            double averageGrade = (student.mathGrade() + student.scienceGrade() + student.literatureGrade()) / 3;

            // Determine grade level
            String gradeLevel;
            if (averageGrade >= 90) {
                gradeLevel = "A";
            } else if (averageGrade >= 80) {
                gradeLevel = "B";
            } else if (averageGrade >= 70) {
                gradeLevel = "C";
            } else if (averageGrade >= 60) {
                gradeLevel = "D";
            } else {
                gradeLevel = "F";
            }

            // Print report
            log.info("""
                    Student: {} \
                    Average Grade: {} \
                    Grade Level: {}\
                    """, student.name(), averageGrade, gradeLevel);
        }
    }

    enum Gender {MALE, FEMALE}

    record Person(String name, int age, Gender gender) {}

    @UtilityClass
    static class PersonValidator {
        static void validate(Person person) {
            if (person.gender() == Gender.MALE && person.age() < 18) {
                throw new ValidationException("Male minors are not allowed!");
            }
        }
    }
}

class AfterExtractMethod {

    @Slf4j
    static class StudentReport {

        public void generate(Student student) {
            double averageGrade = calculateAverageGrade(student);
            String gradeLevel = determineGradeLevel(averageGrade);
            printReport(student, averageGrade, gradeLevel);
        }

        private double calculateAverageGrade(Student student) {
            return (student.mathGrade() + student.scienceGrade() + student.literatureGrade()) / 3;
        }

        private String determineGradeLevel(double averageGrade) {
            String gradeLevel;
            if (averageGrade >= 90) {
                gradeLevel = "A";
            } else if (averageGrade >= 80) {
                gradeLevel = "B";
            } else if (averageGrade >= 70) {
                gradeLevel = "C";
            } else if (averageGrade >= 60) {
                gradeLevel = "D";
            } else {
                gradeLevel = "F";
            }
            return gradeLevel;
        }

        private void printReport(Student student, double averageGrade, String gradeLevel) {
            log.info("""
                    Student: {} \
                    Average Grade: {} \
                    Grade Level: {}\
                    """, student.name(), averageGrade, gradeLevel);
        }
    }

    enum Gender {MALE, FEMALE}

    record Person(String name, int age, Gender gender) {}

    @UtilityClass
    static class PersonValidator {
        static void validate(Person person) {
            if (isAMaleMinor(person)) {
                throw new ValidationException("Male minors are not allowed!");
            }
        }

        private static boolean isAMaleMinor(Person person) {
            return person.gender() == Gender.MALE && person.age() < 18;
        }
    }
}
