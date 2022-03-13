package com.yusuf.aktog.student_management.exception;

public class EnrollmentLimitException extends RuntimeException{
    public EnrollmentLimitException(String message) {
        super(message);
    }
}