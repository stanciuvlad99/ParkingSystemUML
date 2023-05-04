package ro.mycode.controllers;

import ro.mycode.models.Duration;
import ro.mycode.models.ParkingSlot;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlDuration {

    private final String FINAL_URL="C:\\mycode\\OOP\\Incapsularea\\ParkingSystemUML\\src\\ro\\mycode\\data\\duration.txt";
    private ArrayList<Duration> durations;

    public ControlDuration(){
        this.durations=new ArrayList<>();
        load(FINAL_URL);
    }

    private void load(String url) {
        try {
            File file = new File(FINAL_URL);
            Scanner scanner = new Scanner(file);
            this.durations.clear();
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                Duration duration = new Duration(text);
                this.durations.add(duration);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //todo: functie ce afiseaza toate tipurile de durata
    public void read(){
        for (int i=0; i<durations.size(); i++){
            System.out.println(durations.get(i).descriere());
        }
    }

    //todo: functie ce adauga un tip de duratie de parcare in lista, primeste constructor parametru
    public void add(Duration duration){
        this.durations.add(duration);
    }

    //todo: functie ce returneaza un tip de duratie de parcare
    public Duration findByName(String name){
        for (int i=0; i<durations.size(); i++){
            if (durations.get(i).getDurationName().equals(name)){
                return durations.get(i);
            }
        }
        return null;
    }

    //todo: functie ce editeaza name, type, description si time, primeste constructor parametru
    public void edit(Duration duration){
        Duration edit=findByName(duration.getDurationName());
        if (duration.getDurationType().equals("")==false){
            edit.setDurationType(duration.getDurationType());
        }
        if (duration.getDurationDescription().equals("")==false){
            edit.setDurationDescription(duration.getDurationDescription());
        }
        if (duration.getDurationTime().equals("")==false){
            edit.setDurationTime(duration.getDurationTime());
        }
    }
}
