package ro.mycode.models;

public class Types {

    private int typeId;
    private String typeName;
    private String typeDescription;

    public Types(int typeId, String typeName, String typeDescription) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.typeDescription = typeDescription;
    }

    public Types(String text){
        String []split=text.split(",");
        this.typeId=Integer.parseInt(split[0]);
        this.typeName=split[1];
        this.typeDescription=split[2];
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public String descriere(){
        String text="";
        text+="type id " + typeId + "\n";
        text+="type name " + typeName + "\n";
        text+="type description " + typeDescription + "\n";
        return text;
    }

    public String toSave(){
        return typeId+","+typeName+","+typeDescription;
    }
}
