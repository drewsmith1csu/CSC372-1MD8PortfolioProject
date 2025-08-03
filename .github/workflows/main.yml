
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main extends Algorithm {
    public static void main(String[] args) throws IOException {

        /*
         * 
         * This is the information of the file that is located in the folder.
         */
        File file = new File("C:\\Users\\bryan\\git-repo\\CSC372\\MOD_8\\CarList.txt"); // file path
        // This is where all the cars will be stored, a linkedlist of cars named garage
        LinkedList<Car> garage = new LinkedList<Car>();

        // These are cars that will be placed into the garage, manually inserted
        Car chevy = new Car("Chevy", "Cobalt", 2007);
        Car Mazda = new Car("Mazda", "Sport", 20.2);
        Car Ford = new Car("Ford", "F-150", 15.2);

        // All cars added to the garage.
        garage.add(chevy);
        garage.add(Mazda);
        garage.add(Ford);

        /*
         * This is the switch statement that will give the user the ability to read and
         * write into the text file
         * 1 to print the garage
         * 2 to write into the garage
         * 3 to quit
         * This will be in a do-while loop
         */
        int choice = 0;
        Scanner scann = new Scanner(System.in);

        // This will read all file of the garage
        // FileInputStream fileInput = new FileInputStream(file);

        do {
            System.out.println(
                    "This is the garage interface, here we will interact with a text file for the following options:");
            System.out.println("1 to print the garage\n2 to write into the garage\n3 to quit");

            choice = scann.nextInt();
            switch (choice) {
                /*
                 * Case 1 will open the file
                 * read the text to the garage linked list
                 * sort the garage by ascending order
                 * print to screen
                 */
                case 1:
                    System.out.println("Here is the content of the file: ");

                    try (FileInputStream fileInput = new FileInputStream(file)) {
                        readText(garage, fileInput);
                        numSort(garage);
                        // Best for loop for best results
                        for (Car car : garage) {
                            System.out.print(car);
                        }
                    } catch (IOException e) {
                        System.out.println("Error reading file:" + e);
                    }
                    break;
                /*
                 * Case 2 will open the file to write new cars
                 */
                case 2:

                    System.out.println("Opening the garage file");
                    writeGarage(garage, file);
                    break;
                /*
                 * This will close the do while loop
                 * this will close the program and return a thank you message
                 */
                case 3:

                    System.out.println("Thank you for using the program");
                    break;

                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
        } while (choice != 3);

        scann.close();
    }

}
