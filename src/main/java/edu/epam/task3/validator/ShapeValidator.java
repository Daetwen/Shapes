package edu.epam.task3.validator;

public class ShapeValidator {

    public static boolean checkIsStringArrayValid(String array){
        boolean result = true;
        if (array == null || array.isEmpty()) {
            result = false;
        }
        for (int i = 0; i < array.length() - 1; i++) {
            if((array.charAt(i) < '0' && array.charAt(i) != ' ' && array.charAt(i) != '-' && array.charAt(i) != '.') ||
                    (array.charAt(i) > '9' && array.charAt(i) != ' ' && array.charAt(i) != '-' && array.charAt(i) != '.')) {
                result = false;
            }
        }
        return result;
    }
}
