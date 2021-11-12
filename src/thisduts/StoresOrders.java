package thisduts;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class StoresOrders {
    private ArrayList<Order> storeOrders = new ArrayList<>();

    public static final DecimalFormat df2 = new DecimalFormat( "#0.00" );

    public void Export(File file){
        if (file.exists()) {
            System.out.println("File already exists.");
            System.exit(1);
        }
        try {
            PrintWriter pw = new PrintWriter(file);
            for (int i = 0; i < storeOrders.size(); i++){
                pw.print("Phone number: " + storeOrders.get(i).getPNumber() + "\n");
                for (int j = 0; j < storeOrders.get(i).getSize(); j++) {
                    pw.print("\t" + storeOrders.get(i).getPizza(j) + "\n");
                }
                pw.print("Total Price: " + df2.format(storeOrders.get(i).getTotal()) + "\n\n");
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void add(Order order) {
        storeOrders.add(order);
    }

    public int getSize() {
        return storeOrders.size();
    }

    public String getPNumber(int index) {
        return storeOrders.get(index).getPNumber();
    }

    public void remove(int index){
        storeOrders.remove(index);
    }

    public double getPrice(int index) {
        return storeOrders.get(index).getTotal();
    }

    public int getOrderSize(int index) {
        return storeOrders.get(index).getSize();
    }

    public String getPizza(int index, int pizza) {
        return storeOrders.get(index).getPizza(pizza);
    }
}
