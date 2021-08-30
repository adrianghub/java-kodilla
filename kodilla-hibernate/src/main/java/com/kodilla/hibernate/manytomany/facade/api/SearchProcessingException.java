package com.kodilla.hibernate.manytomany.facade.api;

public class SearchProcessingException extends Exception {

        public static String ERR_NOT_FOUND_COMPANY = "Company not found";
        public static String ERR_NOT_FOUND_EMPLOYEE = "Employee not found";

        public SearchProcessingException(String message) {
            super(message);
        }
}
