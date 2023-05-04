package ro.mycode.models;

public class Duration {

    private int durationId;
    private String durationName;
    private String durationType;
    private String durationDescription;
    private String durationTime;

    public Duration(int durationId, String durationName, String durationType, String durationDescription, String durationTime) {
        this.durationId = durationId;
        this.durationName = durationName;
        this.durationType = durationType;
        this.durationDescription = durationDescription;
        this.durationTime = durationTime;
    }

    public Duration(String text){
        String split[]=text.split(",");
        this.durationId=Integer.parseInt(split[0]);
        this.durationName=split[1];
        this.durationType=split[2];
        this.durationDescription=split[3];
        this.durationTime=split[4];
    }

    public int getDurationId() {
        return durationId;
    }

    public void setDurationId(int durationId) {
        this.durationId = durationId;
    }

    public String getDurationName() {
        return durationName;
    }

    public void setDurationName(String durationName) {
        this.durationName = durationName;
    }

    public String getDurationType() {
        return durationType;
    }

    public void setDurationType(String durationType) {
        this.durationType = durationType;
    }

    public String getDurationDescription() {
        return durationDescription;
    }

    public void setDurationDescription(String durationDescription) {
        this.durationDescription = durationDescription;
    }

    public String getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(String durationTime) {
        this.durationTime = durationTime;
    }

    public String descriere(){
        String text="";
        text+="duration id " + durationId + "\n";
        text+="duration name " + durationName + "\n";
        text+="duration type " + durationType + "\n";
        text+="duration description " + durationDescription + "\n";
        text+="duration time " + durationTime + "\n";
        return text;
    }

    public String toSave(){
        return durationId+","+durationName+","+durationType+","+durationDescription+","+durationTime;
    }
}
