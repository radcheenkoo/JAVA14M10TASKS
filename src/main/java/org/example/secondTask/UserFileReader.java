package org.example.secondTask;

import com.sun.source.tree.WhileLoopTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserFileReader {
    public List<User> readDataFromFile(File file){
        List<User> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))){

            reader.readLine();
            String data;

            while((data = reader.readLine()) != null){
                String[] arr = data.split(" ");

                if (arr.length == 2){
                    String name = arr[0];
                    int age = Integer.parseInt(arr[1]);
                    list.add(new User(name,age));

                }
            }

        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return list;
    }
}
