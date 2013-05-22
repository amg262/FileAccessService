
package fileaccessservice;

import java.io.File;
import java.util.Scanner;

/**
 *
 * Console input that when used will either take the filepath to the constructor
 * or it will take the typed in file path from the console
 * 
 * @author Andy
 */
public class ConsoleInput implements InputStrategy {

    Scanner keyboard = new Scanner(System.in);
    final String PER = ".";
    private String path;


    /**
     *
     * @param path
     */
    public ConsoleInput(String path) {
        this.path = path;
    }
   
    /**
     *
     */
    public ConsoleInput(){
    }

    
    
    /**
     *
     * Method that prompts the user with different messages to get the directory and 
     * file name and extension
     * 
     * @return path
     */
    @Override
    public String getFilePath() {
        
        if (path == null){
        
        System.out.println("Enter Directory name:   (C:" + File.separatorChar + "????");
        String dir = keyboard.nextLine();

        /////////////////////////////////////////////
        System.out.println("Enter File Name:   " +   "C:" + File.separatorChar + dir + "\\????");
        String folder = keyboard.nextLine();

        ///////////////////////////////////////////////
        System.out.println("Enter File Ext:   " +   "C:" + File.separatorChar + dir + File.separatorChar + folder + ".???");
        String ext = keyboard.nextLine();
        
        path =  File.separatorChar + dir + File.separatorChar + folder + PER + ext;
        
        }
        else if (path != null) {
            path = path;
        }
        
        return path;
    }
}
