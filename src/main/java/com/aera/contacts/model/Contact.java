package com.aera.contacts.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Objects;

@Document(indexName = "contacts", createIndex = true)
public class Contact {

    @Id
    private String id;
    private String name;
    private String phoneNumber;
    private String surname;
    private String address;
    private String email;
    private Double latitude;
    private Double longitude;
    private String otherInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(getId(), contact.getId()) &&
                Objects.equals(getName(), contact.getName()) &&
                Objects.equals(getPhoneNumber(), contact.getPhoneNumber()) &&
                Objects.equals(getSurname(), contact.getSurname()) &&
                Objects.equals(getAddress(), contact.getAddress()) &&
                Objects.equals(getEmail(), contact.getEmail()) &&
                Objects.equals(getLatitude(), contact.getLatitude()) &&
                Objects.equals(getLongitude(), contact.getLongitude()) &&
                Objects.equals(getOtherInfo(), contact.getOtherInfo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPhoneNumber(), getSurname(), getAddress(), getEmail(), getLatitude(), getLongitude(), getOtherInfo());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nContact{");
        sb.append("\n\tid='").append(id).append('\'');
        sb.append(", \n\tname='").append(name).append('\'');
        sb.append(", \n\tphoneNumber='").append(phoneNumber).append('\'');
        sb.append(", \n\tsurname='").append(surname).append('\'');
        sb.append(", \n\taddress='").append(address).append('\'');
        sb.append(", \n\temail='").append(email).append('\'');
        sb.append(", \n\tlatitude=").append(latitude);
        sb.append(", \n\tlongitude=").append(longitude);
        sb.append(", \n\totherInfo='").append(otherInfo).append('\'');
        sb.append("\n}");
        return sb.toString();
    }
}
