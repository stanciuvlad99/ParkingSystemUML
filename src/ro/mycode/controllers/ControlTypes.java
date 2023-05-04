package ro.mycode.controllers;

import ro.mycode.models.Types;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlTypes {

    private final String FILE_URL="C:\\mycode\\OOP\\Incapsularea\\ParkingSystemUML\\src\\ro\\mycode\\data\\type.txt";
    private ArrayList<Types> types;

    public ControlTypes(){
        this.types=new ArrayList<>();
        load(FILE_URL);
    }

    private void load(String url){
        try {
            File file = new File(FILE_URL);
            Scanner scanner = new Scanner(file);
            this.types.clear();
            while (scanner.hasNextLine()){
                String text=scanner.nextLine();
                Types types = new Types(text);
                this.types.add(types);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //todo: functie ce afiseaza toate tipurile de parcare
    public void read(){
        for (int i=0; i<types.size(); i++){
            System.out.println(types.get(i).descriere());
        }
    }

    //todo: functie de adauga o tip de parcare in lista
    public void add(Types types){
        this.types.add(types);
    }

    //todo: functie ce returneaza un tip de parcare, primeste name parametru
    public Types findByName(String name){
        for (int i=0; i<types.size(); i++){
            if (types.get(i).getTypeName().equals(name)){
                return types.get(i);
            }
        }
        return null;
    }

    //todo: functie ce editeaza description, primeste constructor ca parametru
    public void edit(Types types){
        Types edit = findByName(types.getTypeName());
        if (types.getTypeDescription().equals("")==false){
            edit.setTypeDescription(types.getTypeDescription());
        }
    }

}
