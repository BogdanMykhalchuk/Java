package Habibulin.io;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dreawalker on 24.04.2017.
 */
public class FileManager {
    public static void main(String[] args) {

        ConsoleHelper.writeMessage("Enter file path") ;
        String stringFilePath = ConsoleHelper.readString();
        ConsoleHelper.writeMessage("Enter folder path") ;
        String stringFolderPath = ConsoleHelper.readString();
//        ConsoleHelper.writeMessage("Enter new folder path") ;
//        String stringNewFolderPath = ConsoleHelper.readString();


        Path filePath = Paths.get(stringFilePath);
        Path folderPath = Paths.get(stringFolderPath);

        Path relativePath = folderPath.relativize(filePath);
        Path resolvePath = folderPath.resolve(filePath);
//        System.out.println(relativePath);
        System.out.println(resolvePath);
//        Path newFolderPath = Paths.get(stringNewFolderPath);

//        if(Files.notExists(newFolderPath)) {
//            try {
//                Files.createDirectories(newFolderPath);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

//        Path newFilePath = filePath.getFileName();
//        Path newPath = Paths.get(stringFolderPath, newFilePath.toString());
//
//        System.out.println(newPath);

//        try {
//            Files.copy(filePath, newPath);
//        } catch(IOException e) {
//            e.printStackTrace();
//        }

//        System.out.println(filePath);
//        System.out.println(folderPath);
    }
}
