package ru.geekbrains.java_1.lesson_d;

import java.io.*;
import java.util.Scanner;

public class FileOperation {

    public static void unionFile(String source, String target)  throws IOException{

        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;

        fileInputStream = new FileInputStream(source);
        fileOutputStream = new FileOutputStream(target,true);

        Scanner sc = new Scanner(fileInputStream);
        PrintStream ps = new PrintStream(fileOutputStream);

        while(sc.hasNext()){
             ps.println(sc.nextLine());
        }

        fileOutputStream.flush();
        fileOutputStream.close();
        fileInputStream.close();
    }

    public static boolean searchWord(String source, String word) throws IOException{
        FileInputStream fileInputStream = new FileInputStream(source);
        Scanner sc = new Scanner(fileInputStream);

        while(sc.hasNext()){
            if(sc.findInLine(word) != null)
                return true;
            sc.nextLine();
        }
        return false;
    }

    public static boolean searchWordDir(String path , String word) throws  IOException, NullPointerException{
        File file = new File(path );
        File[] allFile;
        allFile = file.listFiles();

        for (int i = 0; i < allFile.length ; i++) {
            if(searchWord(path  + "\\" + allFile[i].getName(), word))
                return true;
        }
        return false;
    }
    public static void main(String[] arg){

        String file1 = "C:\\Users\\111\\IdeaProjects\\geekbrains\\fileReader\\src\\ru\\geekbrains\\java_1\\lesson_d\\files\\File_1";
        String file2 = "C:\\Users\\111\\IdeaProjects\\geekbrains\\fileReader\\src\\ru\\geekbrains\\java_1\\lesson_d\\files\\File_2";
        String file3 = "C:\\Users\\111\\IdeaProjects\\geekbrains\\fileReader\\src\\ru\\geekbrains\\java_1\\lesson_d\\files\\File_3";
        String path = "C:\\Users\\111\\IdeaProjects\\geekbrains\\fileReader\\src\\ru\\geekbrains\\java_1\\lesson_d\\files";

        String searchWordFile = "C:\\Users\\111\\IdeaProjects\\geekbrains\\fileReader\\src\\ru\\geekbrains\\java_1\\lesson_d\\files\\File_2";
        String searchWord = "soldier";
        String result = null;
        try{

            unionFile(file1,file3);
            unionFile(file2,file3);

            result = (searchWord(searchWordFile, searchWord)) ? " is found." : " was not found.";
            System.out.println("The word '" + searchWord + "'" + result);

            result = (searchWordDir(path , searchWord)) ? " is found in: " + path : " was not found in:  " + path;
            System.out.println("The word '" + searchWord + "'" + result);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
//        catch (NullPointerException e){
//            System.out.println(e.getMessage());
//        }


    }

}
