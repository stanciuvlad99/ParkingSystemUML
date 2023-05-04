package ro.mycode.controllers;

import ro.mycode.models.Customer;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlCustomer {

    private final String FILE_URL="C:\\mycode\\OOP\\Incapsularea\\ParkingSystemUML\\src\\ro\\mycode\\data\\customer.txt";
    private ArrayList<Customer> customers;

    public ControlCustomer(){
        this.customers=new ArrayList<>();
        load();
    }

    private void load() {
        try {
            File file = new File(FILE_URL);
            Scanner scanner = new Scanner(file);
            this.customers.clear();
            while (scanner.hasNextLine()){
                String text= scanner.nextLine();
                Customer customer = new Customer(text);
                this.customers.add(customer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //todo: functie ce afiseaza toti clientii
    public void read(){
        for (int i=0; i<customers.size(); i++){
            System.out.println(customers.get(i).descriere());
        }
    }

    //todo: functie ce adauga un client in lista, primeste constructor parametru
    public void add(Customer customer){
        this.customers.add(customer);
    }

    //todo: functie ce returneaza un client, primeste email parametru
    public Customer findByEmail(String email){
        for (int i=0; i<customers.size(); i++){
            if (customers.get(i).getCustomerEmail().equals(email)){
                return customers.get(i);
            }
        }
        return null;
    }

    //todo: functie ce editeaz mobile,adress,password, primeste constructor parametru
    public void edit(Customer customer){
        Customer edit=findByEmail(customer.getCustomerEmail());
        if (customer.getCustomerMobile().equals("")==false){
            edit.setCustomerMobile(customer.getCustomerMobile());
        }
        if (customer.getCustomerAddress().equals("")==false){
            edit.setCustomerAddress(customer.getCustomerAddress());
        }
        if (customer.getCustomerPassword().equals("")==false){
            edit.setCustomerPassword(customer.getCustomerPassword());
        }
    }
}
