import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //static BankAccount[] accounts = new BankAccount[3];

    //static ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
    static ArrayList<Player> players = new ArrayList<Player>();
    static int MAX = 6;


    public static void main(String[] arg) {
        UI ui = new UI();

        try {
            readGameData();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            ui.createAccounts();
            // ui.manageAccount();
        }

        //byg spilleplade
        String[] fieldsDataArray = readFieldsData();
        Board board = new Board(fieldsDataArray);
        //todo: call gameloop(w. while)
        saveGameData();

        //tester hvad der står på samtlige konti <- Denis
        printAccounts();
        System.out.println(board.getField(40));
    }


    private static void readGameData() throws FileNotFoundException {
        File file = new File("src/data.txt");
        Scanner scan = null;

        scan = new Scanner(file);

        while (scan.hasNextLine()) {
            String[] values = scan.nextLine().split(":");
            int converted_int = Integer.parseInt(values[1]);
            Player p = new Player(values[0], converted_int);
            //  BankAccount account = new BankAccount(values[0],converted_float);
            players.add(p);
        }
    }

    public static String[] readFieldsData() {
        String[] fieldsArray = new String[40];
        File file = new File("src/fields.txt");
        int counter = 0;
        try {
            Scanner scan = null;
            scan = new Scanner(file);
            scan.nextLine(); //ignorer den første linje i filen

            while (scan.hasNextLine()) {

                fieldsArray[counter] = scan.nextLine();
                counter++;
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return fieldsArray;
    }

    public static void printAccounts() {
        for (Player a : Main.players) {
            System.out.println(a);
        }
    }

    /*
        private static void showMenu() {
            System.out.println("Press Q to quit");
            System.out.println("Press C to create Bank Account");
            System.out.println("Press T to do transaction");
        }

     */
    public static void saveGameData() {
        String gameData = "";
        try {
            FileWriter writer = new FileWriter(("src/data.txt"));
            for (Player a : players) {
                gameData += a;
            }
            writer.write(gameData);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}