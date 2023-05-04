package ro.mycode.controllers;

import ro.mycode.models.Vehicle;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlVehicle {

    private final String FILE_URL="C:\\mycode\\OOP\\Incapsularea\\ParkingSystemUML\\src\\ro\\mycode\\data\\vehicle.txt";
    private ArrayList<Vehicle> vehicles;

    public ControlVehicle(){
        this.vehicles=new ArrayList<>();
        load(FILE_URL);
    }

    public void load(String url) {
        try {
            File file = new File(FILE_URL);
            Scanner scanner = new Scanner(file);
            this.vehicles.clear();
            while (scanner.hasNextLine()){
                String text=scanner.nextLine();
                Vehicle vehicle = new Vehicle(text);
                this.vehicles.add(vehicle);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //todo:functie ce afiseaza toate vehiculele
    public void read(){
        for (int i=0; i<vehicles.size(); i++){
            System.out.println(vehicles.get(i).descriere());
        }
    }

    //todo:functie ce adauga o masina in lista, primeste constructor parametru
    public void add(Vehicle vehicle){
        this.vehicles.add(vehicle);
    }

    //todo:functie ce returneaza un vehicul, primeste vehicle number parametru
    public Vehicle findByVehicleNumber(String vehicleNumber){
        for (int i=0; i<vehicles.size(); i++){
            if (vehicles.get(i).getVehicleNumber().equals(vehicleNumber)){
                return vehicles.get(i);
            }
        }
        return null;
    }


    //todo: functie ce editeaza description, primeste constructor ca parametru
    public void editeDescription(Vehicle vehicle){
        Vehicle update=findByVehicleNumber(vehicle.getVehicleNumber());
        if (vehicle.getVehicleDescription().equals("")==false){
            update.setVehicleDescription(vehicle.getVehicleDescription());
        }
    }

    //todo: functie ce returneaza lista cu vehiculele unui client, primeste ownerId parametru
    public ArrayList<Vehicle> vehicleListFindByID(int vehicleOwnerId){
        ArrayList<Vehicle> list = new ArrayList<>();
        for (int i=0; i<vehicles.size(); i++){
            if (vehicles.get(i).getVehicleOwnerId()==vehicleOwnerId){
                list.add(vehicles.get(i));
            }
        }
        return list;
    }

    //todo: functie ce returneaza id valabil
    public int nextId(){
        if (vehicles.size()==0){
            return -1;
        }
        return vehicles.get(vehicles.size()-1).getVehicleId()+1;
    }

    //todo: functie ce returneaza un vehicul, primeste vehicleOwnerId si vehicleNumber parametri
    public Vehicle findByVehicleOwnerIdVehicleNumber(int vehicleOwnerId, String vehicleNumber){
        for (int i=0; i<vehicles.size(); i++){
            if (vehicles.get(i).getVehicleOwnerId()==vehicleOwnerId &&
                    vehicles.get(i).getVehicleNumber().equals(vehicleNumber)){
                return vehicles.get(i);
            }
        }
        return null;
    }

    //todo: functie ce elimina un vehicul din lista, primeste construcor parametru
    public void remove(Vehicle vehicle){
        this.vehicles.remove(vehicle);
    }

}
