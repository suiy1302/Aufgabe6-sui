package main.manager;

import main.goods.Liquid;
import main.goods.Pallet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PalletManager {

    private static Pallet[] pallets;

    public static void main(String[] args) {
        pallets = preloadInitialDataSet();

        //todo: print all pallets (incl. weight and total value)
    }


    /**
     * Loads an initial data set from the file inputdata.csv
     *
     * * @return a Pallet[], will never be null but may have length 0
     */
    public static Pallet[] preloadInitialDataSet() {
        BufferedReader br = null;
        try {
            //Create reader to read input files
            br = new BufferedReader(new FileReader("inputdata.csv"));
            //Create list to store data from file
            ArrayList<Pallet> pallets = new ArrayList<Pallet>();
            String line;
            //Read each line from file
            while ((line = br.readLine()) != null) {
                if (line.charAt(0) == '\uFEFF') {
                    line = line.substring(1);
                }
                //Split line by ';'
                String[] splits = line.split(";");
                System.out.println("Line: " + line);

                //todo: Create Pallets (Liquid, Solid, or UnitLoad) with data read from line
                Pallet p = null;

                //End here
                pallets.add(p);
            }
            //convert list into array
            return pallets.toArray(new Pallet[pallets.size()]);

        } catch (Exception e) {
            // Some failure handling
            System.out.println("There was an error while trying to load the initial data set:");
            e.printStackTrace();
            return new Pallet[0];
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Unable to close reader.");
            }
        }
    }

}
