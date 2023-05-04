package ro.mycode.controllers;

import ro.mycode.models.User;
import ro.mycode.models.Vehicle;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlUser {

    private final String FILE_PATH="C:\\mycode\\OOP\\Incapsularea\\ParkingSystemUML\\src\\ro\\mycode\\data\\user.txt";
    private ArrayList<User> users;

    public ControlUser(){
        this.users=new ArrayList<>();
        load(FILE_PATH);
    }

    private void load(String path) {
        try {
            File file = new File(FILE_PATH);
            Scanner scanner = new Scanner(file);
            this.users.clear();
            while (scanner.hasNextLine()){
                String text=scanner.nextLine();
                User user = new User(text);
                this.users.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //todo: functie ce afiseza toti userii
    public void read(){
        for (int i=0; i<users.size(); i++){
            System.out.println(users.get(i).descriere());
        }
    }


    //todo: functie ce adauga un user in lita
    public void add(User user){
        this.users.add(user);
    }

    //todo: functie ce returneaza user, primeste email parametru
    public User findByEmail(String email){
        for (int i=0; i<users.size();i++){
            if (users.get(i).getUserEmail().equals(email)){
                return users.get(i);
            }
        }
        return null;
    }

    //todo: functie ce editeaza date si adress, primeste constructor ca parametru
    public void editDateAdress(User user){
        User update=findByEmail("MysticDreamer24@fictitiousmail.com");
        if ((user.getUserDate()==0)==false){
            update.setUserDate(user.getUserDate());
        }
        if (user.getUserAdress().equals("")==false){
            update.setUserAdress(user.getUserAdress());
        }
    }






}
