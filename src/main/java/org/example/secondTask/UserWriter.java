package org.example.secondTask;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UserWriter {
    public void writeUserToJsonFile(List<User> list, File file){
        try (FileWriter writer = new FileWriter(file)){
            Gson gson = new Gson();
            gson.toJson(list,writer);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
