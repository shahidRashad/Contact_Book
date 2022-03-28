package com.example.contactbook;

public class ContactModel {
    private String contactName;
    private String contactNo;
    private String contactEmail;

    public ContactModel(String contactName, String contactNo, String contactEmail) {
        this.contactName = contactName;
        this.contactNo = contactNo;
        this.contactEmail = contactEmail;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
