
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Algorithm extends Car {

    /*
     * numSort will sort the mpg of each car into ascending order.
     * 
     */

    public static void numSort(LinkedList<Car> Garage) {

        int min;
        for (int i = 0; i < Garage.size() - 1; i++) {
            min = i;
            for (int j = i + 1; j < Garage.size(); j++) {
                if (Garage.get(j).getMpg() < Garage.get(min).getMpg()) {
                    Car temp = Garage.get(i);
                    Garage.set(i, Garage.get(j));
                    Garage.set(j, temp);
                }

            }
        }
    }

    /*
     * 
     * This will read a file into my arraylist
     * Need a way to try catch for the file (FileNotFoundException)
     * 
     */
    public static void readText(LinkedList<Car> garage, FileInputStream fileInput) throws FileNotFoundException{


        try (Scanner scan = new Scanner(fileInput)){
            while (scan.hasNextLine()) {

                String line = scan.nextLine().trim(); //grabs the next line and removes any extra blank space
                //Check for empty lines in the text document to skip
                if(line.isEmpty()){
                    continue;
                }
                //Skips the lines that are not in proper formatting. 
                String[] words = line.split("\\s+"); // Splits the line into 3 different words 
                if(words.length < 3){
                    System.out.println("Skipped line not in proper Make Model MPG format" + line);
                }

                // The words array will be split abd properly formatted. Make and model with take words[0] & words[1]
                String make = words[0];
                String model = words[1];  
                double mpg;

                // MPG will be check to to ensure it is a double. If it is, it will be accepted as a car and inserted to the garage linkedlist and text file. 
                try{
                    mpg = Double.parseDouble(words[2]);
                    if(mpg > 0){
                        Car car = new Car(make, model, mpg);
                        garage.add(car);
                    }else{
                        //this will return an error if there is a negative MPG in the car
                        System.out.println("Skipping car with the invalid MPG:" + line); 
                    }
                } catch (NumberFormatException e){
                    System.out.println("Invalid MPG value for: " + line);
                } 
            } 
        }
    }

    /*
     * writeGarage will give the user the ability to write a new car into the text document. 
     * 
     */
    public static void writeGarage(LinkedList<Car> garage, File file) throws IOException{

        String make = "";
        String model = "";
        Double mpg = 0.00;
        boolean flag = false;
        Scanner scan = new Scanner(System.in);

        try (BufferedWriter output = new BufferedWriter(new FileWriter(file, true))) {
            System.out.println("You will be writing into the garage text file\n. The format to enter a new car is Make Model MPG.\n");
            System.out.println("If a car is more than one word, please attach them with a dash");

            while(!flag){
                flag = true;
                try{
                    System.out.println("Please enter the Make of the vehicle: ");
                    make = scan.nextLine().trim();
                    
                    System.out.println("Please enter the Model of the vehicle: ");
                    model = scan.nextLine().trim();
                    
                    System.out.println("Please enter the MPG of the vehicle: ");
                    mpg = scan.nextDouble();
                    //scan.nextLine();
                    continue;
                    
                }catch(Exception e){
                    System.out.println(e.getMessage());
                    System.out.println("Error with the input formatting");
                    scan.nextLine();
                    flag = false;
                    continue;
                }
            }
            System.out.println("Saving: "+ make + " " + model + " " + mpg);
            output.append(make + " " + model + " " + mpg + "\n");
            output.flush();
            
        }
    }
}
