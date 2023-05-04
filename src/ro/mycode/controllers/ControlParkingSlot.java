package ro.mycode.controllers;

import ro.mycode.models.ParkingSlot;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlParkingSlot {

    private final String FILE_PATH="C:\\mycode\\OOP\\Incapsularea\\ParkingSystemUML\\src\\ro\\mycode\\data\\parkingSlot.txt";
    private ArrayList<ParkingSlot> parkingSlots;

    public ControlParkingSlot(){
        this.parkingSlots=new ArrayList<>();
        load();
    }

    private void load(){
        try {
            File file = new File(FILE_PATH);
            Scanner scanner = new Scanner(file);
            this.parkingSlots.clear();
            while (scanner.hasNextLine()){
                String text= scanner.nextLine();
                ParkingSlot parkingSlot = new ParkingSlot(text);
                this.parkingSlots.add(parkingSlot);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //todo: functie ce afiseaza toate locurile de parcare
    public void read(){
        for (int i=0; i<parkingSlots.size(); i++){
            System.out.println(parkingSlots.get(i).descriere());
        }
    }

    //todo: functie ce adauga un loc de paracare in lista, primeste constructor parametru
    public void add(ParkingSlot parkingSlot){
        this.parkingSlots.add(parkingSlot);
    }

    //todo: functie ce returneaza un loc de paracare, primeste type parametru
    public ParkingSlot findByType(String username){
        for (int i=0; i<parkingSlots.size(); i++){
            if (parkingSlots.get(i).getParkingSlotType().equals(username)){
                return parkingSlots.get(i);
            }
        }
        return null;
    }

    //todo: fundtie ce editeaza description, primeste constructor ca parametru
    public void edit(ParkingSlot parkingSlot){
        ParkingSlot edit= findByType(parkingSlot.getParkingSlotType());
        if (parkingSlot.getParkingSlotDescription().equals("")==false){
            edit.setParkingSlotDescription(parkingSlot.getParkingSlotDescription());
        }
    }
}
