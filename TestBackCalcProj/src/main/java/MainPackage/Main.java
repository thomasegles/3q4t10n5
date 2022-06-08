package MainPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ///home/thomas/Documents/HTL/AUD/BackCalcProject/TestCSV.csv
        //getFilePathFromConsole();

        double[][] c = new double[][] {{2, 7, 1}, {3, -2, 8}, {1, 5, 3}};
        double[][] c2 = new double[][] {{2, 7, 1, 4},{3, -2, 8, 9},{1, 5, 3, 8.64},{6, -29, 51.959999999999994, 77}};
        CalcMatrix calcMatrix = new CalcMatrix(c);
        calcMatrix.calcBack();
        calcMatrix.showMatrices();
    }

    public static void getFilePathFromConsole() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter file path: ");
        String path = sc.nextLine();
        System.out.println("Path: " + path);
        readFile(path);
    }

    public static void readFile(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String item = br.readLine();
            while(item != null) {
                System.out.println(item);
                item = br.readLine();
            }
            br.close();
        } catch (Exception ex) {

        }
    }
}
