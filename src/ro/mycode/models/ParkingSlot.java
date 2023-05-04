package ro.mycode.models;

public class ParkingSlot {
    private int parkingSlotId;
    private String parkingSlotDescription;
    private String parkingSlotType;
    private String parkingSlotCarId;


    public ParkingSlot(int parkingSlotId, String parkingSlotDescription, String parkingSlotType, String parkingSlotCarId,
                       String customerAddress, String customerUsername, String customerPassword) {
        this.parkingSlotId = parkingSlotId;
        this.parkingSlotDescription = parkingSlotDescription;
        this.parkingSlotType = parkingSlotType;
        this.parkingSlotCarId = parkingSlotCarId;
    }

    public ParkingSlot(String text){
        String []split=text.split(",");
        this.parkingSlotId =Integer.parseInt(split[0]);
        this.parkingSlotDescription =split[1];
        this.parkingSlotType =split[2];
        this.parkingSlotCarId =split[3];
    }

    public int getParkingSlotId() {
        return parkingSlotId;
    }

    public void setParkingSlotId(int parkingSlotId) {
        this.parkingSlotId = parkingSlotId;
    }

    public String getParkingSlotDescription() {
        return parkingSlotDescription;
    }

    public void setParkingSlotDescription(String parkingSlotDescription) {
        this.parkingSlotDescription = parkingSlotDescription;
    }

    public String getParkingSlotType() {
        return parkingSlotType;
    }

    public void setParkingSlotType(String parkingSlotType) {
        this.parkingSlotType = parkingSlotType;
    }

    public String getParkingSlotCarId() {
        return parkingSlotCarId;
    }

    public void setParkingSlotCarId(String parkingSlotCarId) {
        this.parkingSlotCarId = parkingSlotCarId;
    }

    public String descriere(){
        String text="";
        text+="parking slot id " + parkingSlotId + "\n";
        text+="parking slot description " + parkingSlotDescription + "\n";
        text+="parking slot type " + parkingSlotType + "\n";
        text+="parking slot car id " + parkingSlotCarId + "\n";

        return text;
    }

    public String toSave(){
        return parkingSlotId +","+ parkingSlotDescription +","+ parkingSlotType +","+ parkingSlotCarId;
    }
    
}
