package br.com.neves.book_service.infra.utils;

public class ValidationMessageFormatter {
    public static String formatValidationMessage(String field, String message){
        return "O campo '" + field + "' " + message;
    }
}
