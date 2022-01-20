package home;

import javafx.beans.property.SimpleStringProperty;

public class PrtTable {
    // String AN,Name,Contact_no,address,sbNo,skills;
    private SimpleStringProperty AN,Name,Contact_no,address,sbNo,skills;

    public PrtTable(String AN, String name,
                    String contact_no, String address,
                    String sbNo,String sk) {
        this.AN = new SimpleStringProperty(AN);
        this.Name = new SimpleStringProperty(name);
        this.Contact_no = new SimpleStringProperty(contact_no);
        this.address = new SimpleStringProperty(address);
        this.sbNo = new SimpleStringProperty(sbNo);
        this.skills=new SimpleStringProperty(sk);
    }


    public String getAN() {
        return AN.get();
    }

    public SimpleStringProperty ANProperty() {
        return AN;
    }

    public void setAN(String AN) {
        this.AN.set(AN);
    }

    public String getName() {
        return Name.get();
    }

    public SimpleStringProperty nameProperty() {
        return Name;
    }

    public void setName(String name) {
        this.Name.set(name);
    }

    public String getContact_no() {
        return Contact_no.get();
    }

    public SimpleStringProperty contact_noProperty() {
        return Contact_no;
    }

    public void setContact_no(String contact_no) {
        this.Contact_no.set(contact_no);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getSbNo() {
        return sbNo.get();
    }

    public SimpleStringProperty sbNoProperty() {
        return sbNo;
    }

    public void setSbNo(String sbNo) {
        this.sbNo.set(sbNo);
    }

    public String getSkills() { return skills.get(); }

    public SimpleStringProperty skillsProperty() {return skills;}

    public void setSkills(String skills) {this.skills.set(skills);}
}
