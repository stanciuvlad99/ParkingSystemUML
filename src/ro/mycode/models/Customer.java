package ro.mycode.models;

public class Customer {

    private int customerId;
    private String customerName;
    private String customerMobile;
    private String customerEmail;
    private String customerAddress;
    private String customerUsername;
    private String customerPassword;


    public Customer(int customerId, String customerName, String customerMobile, String customerEmail,
                    String customerAddress, String customerUsername, String customerPassword) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerMobile = customerMobile;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerUsername = customerUsername;
        this.customerPassword = customerPassword;
    }

    public Customer(String text){
        String split[]=text.split(",");
        this.customerId=Integer.parseInt(split[0]);
        this.customerName=split[1];
        this.customerMobile=split[2];
        this.customerEmail=split[3];
        this.customerAddress=split[4];
        this.customerUsername=split[5];
        this.customerPassword=split[6];
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String descriere() {
        String text = "";
        text += "customer id " + customerId + "\n";
        text += "customer name " + customerName + "\n";
        text += "customer mobile " + customerMobile + "\n";
        text += "customer email " + customerEmail + "\n";
        text += "customer address " + customerAddress + "\n";
        text += "customer username " + customerUsername + "\n";
        text += "customer password " + customerPassword + "\n";
        return text;
    }

    public String toSave() {
        return customerId +","+customerName+","+customerMobile+","+customerEmail+","+ customerAddress +","+
                customerUsername+","+customerPassword;
    }
}
