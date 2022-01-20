package home;

import javafx.beans.property.SimpleStringProperty;


public class SbTable {
    private SimpleStringProperty Sb_no,SBName,Name,Contact_no,description;
    public SbTable(String Sb_no, String SBName,
                   String Name, String Contact_no,
                   String description) {
        this.Sb_no = new SimpleStringProperty(Sb_no);
        this.SBName = new SimpleStringProperty(SBName);
        this.Name = new SimpleStringProperty(Name);
        this.Contact_no = new SimpleStringProperty(Contact_no);
        this.description = new SimpleStringProperty(description);
    }

    public String getSb_no() {
        return Sb_no.get();
    }

    public SimpleStringProperty sb_noProperty() {
        return Sb_no;
    }

    public void setSb_no(String sb_no) {
        this.Sb_no.set(sb_no);
    }

    public String getSBName() {
        return SBName.get();
    }

    public SimpleStringProperty SBNameProperty() {
        return SBName;
    }

    public void setSBName(String SBName) {
        this.SBName.set(SBName);
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

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }
}
