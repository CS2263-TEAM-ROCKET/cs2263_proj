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

@NoArgsConstructor @AllArgsConstructor @ToString
public class StateManager {

    //Variables
    Gson gson = new Gson();

    //Methods
    //Methods for saving

    /**
     * Saves the game with the current state
     * @param file full path name of the directory to save to
     * @param fileName specific file name to make/save
     * @param state current state to save
     * @return a boolean to confirm save
     */
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

    /**
     * Used to create a file if none already exists
     * @param file name
     * @return returns the file to save to
     */
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

    /**
     * Gets the game state from a given file.
     * @param file to get from
     * @return the stateObject to load from
     * @throws FileNotFoundException
     */
    public StateObject loadData(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        StateObject newState = new StateObject();
        if (scanner.hasNext()) {
            String json = scanner.nextLine();
            newState = gson.fromJson(json, StateObject.class);
            scanner.close();
            System.out.println("File read.");
        }
        return newState;
    }
}
