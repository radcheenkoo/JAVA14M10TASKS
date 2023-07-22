package org.example;

import org.example.firstTask.FirstTask;
import org.example.secondTask.User;
import org.example.secondTask.UserFileReader;
import org.example.secondTask.UserWriter;
import org.example.thirdTask.ReadFromFileAndMakeSomeOperation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        firstTaskTest();
        secondTaskTest();
        thirdTaskTest();
    }

    public static void firstTaskTest(){
        File file = new File("./files/fileFirstExample.txt");
        FirstTask task = new FirstTask();
        task.readAndPrintValidPhoneNumbers(file);
    }
    public static void secondTaskTest(){
        List<User> list = new ArrayList<>();


        File in = new File("./files/fileSecondExample.txt");
        File out = new File("./files/user.json");

        UserFileReader reader = new UserFileReader();
        list = reader.readDataFromFile(in);
        UserWriter writer = new UserWriter();
        writer.writeUserToJsonFile(list, out);


    }
    public static void thirdTaskTest(){
        ReadFromFileAndMakeSomeOperation readFromFile = new ReadFromFileAndMakeSomeOperation();
        File file = new File("./files/words.txt");
        readFromFile.amountOfSymbols(file);
    }
}