package org.example.firstTask;

import java.io.*;
import java.util.Scanner;
import java.util.StringJoiner;


public class FirstTask {
    public  void readAndPrintValidPhoneNumbers(File file) {
        String str = read(file);
        String[] strings = str.split("\n");

        for (String s: strings) {
            if (isValidPhoneNumber(s)){
                System.out.println(s);
            }
        }

    }
    private String read(File file){
        StringJoiner stringJoiner = new StringJoiner("\n");
        try (Scanner sc = new Scanner(file)){
            while (sc.hasNextLine()){
                stringJoiner.add(sc.nextLine());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return stringJoiner.toString();
    }


    private boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}")) {
            return true;
        }
        if (phoneNumber.matches("\\(\\d{3}\\) \\d{3}-\\d{4}")) {
            return true;
        }
        return false;
    }


}
