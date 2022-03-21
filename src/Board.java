import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    private Field[] fields = new Field[40];

    public Board(String[] fieldsData) {

        setFields(fieldsData);
    }

    private void setFields(String[] fieldsData) {
        String[] fieldData;
        int id;
        String fieldType;
        String label;
        int cost;
        int income;
        int seriesId;
        int counter = 0;


        //todo: instantiere felter af forskellig type på baggrund af værdien i fieldType
        for (String s : fieldsData) {
            fieldData = s.split(",");
            id = Integer.parseInt(fieldData[0].trim());
            fieldType = fieldData[1].trim();
            label = fieldData[2].trim();
            cost = Integer.parseInt(fieldData[3].trim());
            income = Integer.parseInt(fieldData[4].trim());
            seriesId = Integer.parseInt(fieldData[5].trim());

            Field field = null;
            System.out.println(fieldData[1]);

            switch (fieldType) {

                case "Start":
                    field = new Start(id, label, cost, income);
                    break;

                case "Plot":
                    field = new Plot(id, label, cost, income, seriesId);
                    break;

                case "Tax":
                    field = new Tax(id, label, cost, income);
                    break;

                case "Chance":
                    field = new Chance(id, label, cost, income);
                    break;

                case "ShippingLine":
                    field = new ShippingLine(id, label, cost, income, seriesId);
                    break;

                case "Brewery":
                    field = new Brewery(id, label, cost, income, seriesId);
                    break;

                case "Prison":
                    field = new Prison(id, label, cost, income);
                    break;

                case "Visit":
                    field = new Visit(id, label, cost, income);
                    break;

                case "Bonus":
                    field = new Bonus(id, label, cost, income);
                    break;

            }

            fields[counter] = field;
            counter++;

        }


//        fields[0] = new Start(1,"Start", 0, 4000);
    }

    public Field getField(int playerPosition) {

        return fields[playerPosition - 1];
    }

}
