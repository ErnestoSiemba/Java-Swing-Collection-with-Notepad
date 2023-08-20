import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class createFile {
    public static void main(String[] args) {
        // creating a file in java
        try {
            File myobj = new File("filename.txt");
            if (myobj.createNewFile()) {
                System.out.println("File " + myobj.getName() + " created successfully");

            } else {
                System.out.println("The file " + myobj.getName() + " already exists");

            }
        } catch (IOException exception) {
            System.out.println("An error occurred, please try again!");
        } finally {
            System.out.println("This is how we navigate the file system in Java");
        }

        // Writing to a file in java
        try {
            FileWriter writeToFile = new FileWriter("filename.txt");
            writeToFile.write("This is how we navigate the java file system!!");
            //noinspection SpellCheckingInspection
            writeToFile.write("\nAnd java is now so interesting and i pitty those people who didn't completely learn it..");
            writeToFile.close();
            System.out.println("Successfully wrote to a file: " );
        } catch (IOException e) {
            System.out.println("An Error occurred!!");
            e.printStackTrace();
        }

        // Reading the contents of a file.

        try {
            File myFile = new File("filename.txt");
            // use the scanner class to read the file
            Scanner myReader = new Scanner(myFile);
            while(myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }
        catch (FileNotFoundException exception) {
            System.out.println("The file does not exist and error occurred ");
        }
        finally {
            System.out.println("Files seem to be complicated but it's all fun!!");
        }

        // Getting the file information

        try {
            File myObj = new File("filename.txt");
            if (myObj.exists()) {
                System.out.println("Filename: " + myObj.getName());
                System.out.println("Absolute path: " + myObj.getAbsolutePath());
                System.out.println("Writeable: " + myObj.canWrite());
                System.out.println("Readable: " + myObj.canRead());
                System.out.println("Absolute File" + myObj.getAbsoluteFile());
            } else {
                System.out.println("The file does not exist!!");
            }

        } catch (Exception e) {
            System.out.println("An error occurred!!");
            e.printStackTrace();
        }
        finally {
            System.out.println("Programming in java is now interesting");
        }

        // Delete a file in java
        try {
            File myObj = new File("filename.txt");
            if (myObj.delete()) {
                System.out.println("File: " + myObj.getName() + " has been deleted successfully");
            } else {
                System.out.println("File could not be deleted!");
            }
        }
        catch (Exception e) {
            System.out.println("An error occurred and the file could not be deleted");
            e.printStackTrace();

        }

        // Deleting a folder
        try {
            File myNewFile = new File("C:\\Users\\user\\desktop\\Test");
            if (myNewFile.delete()) {
                System.out.println("Folder " + myNewFile.getName() + " deleted successfully");
            } else {
                System.out.println("Failed to delete the folder " + myNewFile.getName());
            }
        }
        catch (Exception exception) {
            System.out.println("An error occurred and the folder could not be deleted!!");
            exception.printStackTrace();
        }


    }
}