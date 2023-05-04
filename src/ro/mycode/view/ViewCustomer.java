package ro.mycode.view;

import ro.mycode.controllers.ControlDuration;
import ro.mycode.controllers.ControlParkingSlot;
import ro.mycode.controllers.ControlTypes;
import ro.mycode.controllers.ControlVehicle;
import ro.mycode.models.Customer;
import ro.mycode.models.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewCustomer {

    private Customer customer;
    private ControlTypes controlTypes;
    private ControlDuration controlDuration;
    private ControlVehicle controlVehicle;
    private ControlParkingSlot controlParkingSlot;

    public ViewCustomer() {
        this.customer = new Customer("1,Alexandtu Mihalache,0712345678,FizzyPenguin89@email.com,Bucuresti,FizzyPenguin89,pass123");
        this.controlTypes = new ControlTypes();
        this.controlDuration = new ControlDuration();
        this.controlVehicle = new ControlVehicle();
        this.controlParkingSlot = new ControlParkingSlot();
        play();
    }

    private void menu() {
        System.out.println("Apasati tasta 1 pentru a vedea tipurile de parcari");
        System.out.println("Apasati tasta 2 pentru a vedea duratele parcarii");
        System.out.println("Apasati tasat 3 pentru a vedea masinile dumeavoastra");
        System.out.println("Apasati tasta 4 pentru a adauga o masina in baza de date");
        System.out.println("Apasati tasat 5 pentru a elimia un vehicul");
        System.out.println("Apasati tasta 6 pentru a edita descrierea masinii");
    }

    private void play() {
        menu();
        boolean running = true;
        while (running) {
            Scanner scanner = new Scanner(System.in);
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    afisareTipuriParcari();
                    break;
                case 2:
                    afisareDurateParcari();
                case 3:
                    vehiculePersonale();
                    break;
                case 4:
                    adaugareVehicul();
                    break;
                case 5:
                    eliminareVehicul();
                    break;
                case 6:
                    editareDescreire();
                    break;
                default:
                    break;
            }

        }
    }


    private void afisareTipuriParcari() {
        controlTypes.read();
    }

    private void afisareDurateParcari() {
        controlDuration.read();
    }

    private void vehiculePersonale() {
        ArrayList<Vehicle> list = controlVehicle.vehicleListFindByID(customer.getCustomerId());
        for (int i = 0; i < list.size(); i++) {
            Vehicle vehicle = controlVehicle.findByVehicleNumber(list.get(i).getVehicleNumber());
            System.out.println(vehicle.descriere());
        }
    }

    private void adaugareVehicul() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numarul vehiculului");
        String numar = scanner.nextLine();
        Vehicle verificare = controlVehicle.findByVehicleNumber(numar);
        if (verificare == null) {
            System.out.println("Introduceti marca vehicului");
            String marca = scanner.nextLine();
            System.out.println("Introduceti tipul vehicului");
            String tip = scanner.nextLine();
            System.out.println("Introcueti descrierea masinii");
            String descriere = scanner.nextLine();
            Vehicle vehicle = new Vehicle(controlVehicle.nextId(), customer.getCustomerId(), numar, marca, tip, descriere);
            controlVehicle.add(vehicle);
            System.out.println("Vehiculul a fost adaugat cu succes");
        } else {
            System.out.println("Masina exista de in baza de date");
        }
    }

    public void eliminareVehicul() {
        System.out.println("Introduceti numarul vehicului");
        Scanner scanner = new Scanner(System.in);
        String numar = scanner.nextLine();
        Vehicle vehicle = controlVehicle.findByVehicleOwnerIdVehicleNumber(customer.getCustomerId(), numar);
        if (vehicle != null) {
            controlVehicle.remove(vehicle);
            System.out.println("Vehiculul a fost eliminat cu succes");
        } else {
            System.out.println("Vehicului cu cu numarul '" + numar + "' nu exista in baza de date");
        }

    }

    private void editareDescreire() {
        System.out.println("Introduceti numarul autovehicului");
        Scanner scanner = new Scanner(System.in);
        String numar = scanner.nextLine();
        Vehicle vehicle = controlVehicle.findByVehicleOwnerIdVehicleNumber(customer.getCustomerId(), numar);
        if (vehicle != null) {
            System.out.println("Introduceti noua descriere");
            String descriere = scanner.nextLine();
            controlVehicle.editeDescription(new Vehicle(vehicle.getVehicleId(), vehicle.getVehicleOwnerId(),
                    vehicle.getVehicleNumber(), vehicle.getVehicleCompany(), vehicle.getVehicleType(), descriere));
            System.out.println("Vehicului i s-a facut update cu succes");
        } else {
            System.out.println("Vehicului cu cu numarul '" + numar + "' nu exista in baza de date");
        }
    }

}
