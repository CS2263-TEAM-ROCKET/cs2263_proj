package edu.isu.cs2263.proj.data;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@NoArgsConstructor @RequiredArgsConstructor @AllArgsConstructor @ToString
public class StateManager {

    //Variables
    Gson gson = new Gson();

    //Methods
    //Methods for saving
    public boolean saveData(File file, String fileName, StateObject state){
        boolean saved = false;
        try {
            if (file.isDirectory()) {
                file = this.createFile(file + "/" + fileName);
                FileWriter writer = new FileWriter(file, true);
                String json = gson.toJson(state);
                writer.write(json);
                writer.write("\n");
                System.out.println("Wrote to file: " + file);
                writer.close();
                saved = true;
            }
            else {
                System.out.println("Problem saving.");
            }
        }
        catch (IOException e){
            System.out.println("An error occurred while saving.");
            e.printStackTrace();
        }
        return saved;
    }

    private File createFile(String file) {
        File write_file = new File(file);
        try {
            if (write_file.createNewFile()) {
                System.out.println("File create: " + write_file.getName());
            } else {
                System.out.println("File may already exist.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred creating a file.");
            e.printStackTrace();
        }
        return write_file;
    }

    //Methods for loading
    public boolean loadData(File file, StateObject state) throws FileNotFoundException {
        boolean loaded = false;
        Scanner scanner = new Scanner(file);
        StateObject newState = new StateObject();
        if (scanner.hasNext()) {
            String json = scanner.nextLine();
            newState = gson.fromJson(json, StateObject.class);
            scanner.close();
            System.out.println("File read.");
            loaded = true;
        }
        state = newState;
        return loaded;
    }
}
