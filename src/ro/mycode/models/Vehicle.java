package ro.mycode.models;

public class Vehicle {

    private int vehicleId;
    private int vehicleOwnerId;
    private String vehicleNumber;
    private String vehicleCompany;
    private String vehicleType;
    private String vehicleDescription;

    public Vehicle(int vehicleId, int vehicleOwnerId, String vehicleNumber, String vehicleCompany, String vehicleType, String vehicleDescription) {
        this.vehicleId = vehicleId;
        this.vehicleOwnerId = vehicleOwnerId;
        this.vehicleNumber = vehicleNumber;
        this.vehicleCompany = vehicleCompany;
        this.vehicleType = vehicleType;
        this.vehicleDescription = vehicleDescription;
    }

    public Vehicle(String text){
        String []split=text.split(",");
        this.vehicleId=Integer.parseInt(split[0]);
        this.vehicleOwnerId=Integer.parseInt(split[1]);
        this.vehicleNumber=split[2];
        this.vehicleCompany=split[3];
        this.vehicleType=split[4];
        this.vehicleDescription=split[5];
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getVehicleOwnerId() {
        return vehicleOwnerId;
    }

    public void setVehicleOwnerId(int vehicleOwnerId) {
        this.vehicleOwnerId = vehicleOwnerId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleCompany() {
        return vehicleCompany;
    }

    public void setVehicleCompany(String vehicleCompany) {
        this.vehicleCompany = vehicleCompany;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleDescription() {
        return vehicleDescription;
    }

    public void setVehicleDescription(String vehicleDescription) {
        this.vehicleDescription = vehicleDescription;
    }

    public String descriere(){
        String text="";
        text+="vehicle id " + vehicleId+ "\n";
        text+="vehicle owner id " + vehicleOwnerId + "\n";
        text+="vehicle number " + vehicleNumber + "\n";
        text+="vehicle company " + vehicleCompany + "\n";
        text+="vehicle type " + vehicleType + "\n";
        text+="vehicle description " + vehicleDescription + "\n";
        return text;
    }

    public String toSave(){
        return vehicleId+","+vehicleOwnerId+","+vehicleNumber+","+vehicleCompany+","+vehicleType+","+vehicleDescription;
    }
}
