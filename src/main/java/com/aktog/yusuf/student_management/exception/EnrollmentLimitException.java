package com.aktog.yusuf.student_management.exception;

public class EnrollmentLimitException extends RuntimeException{
    public EnrollmentLimitException(String message) {
        super(message);
    }
}