package com.att.training.refactoring;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

class BeforeExtractDelegate {
    @RequiredArgsConstructor
    @Getter
    class Person {
        private final int id;
        private final String name;
        private final String city;
        private final String streetName;
        private final int streetNumber;
        private final int zipCode;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("id", id)
                    .add("name", name)
                    .add("city", city)
                    .add("streetName", streetName)
                    .add("streetNumber", streetNumber)
                    .add("zipCode", zipCode)
                    .toString();
        }
    }
}

class AfterExtractDelegate {
    @RequiredArgsConstructor
    @Getter
    static class Person {
        private final int id;
        private final String name;
        private final Address address;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("id", id)
                    .add("name", name)
                    .add("city", address.getCity())
                    .add("streetName", address.getStreetName())
                    .add("streetNumber", address.getStreetNumber())
                    .add("zipCode", address.getZipCode())
                    .toString();
        }
    }

    @RequiredArgsConstructor
    @Getter
    static class Address {
        private final String city;
        private final String streetName;
        private final int streetNumber;
        private final int zipCode;
    }
}
