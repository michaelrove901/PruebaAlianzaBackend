package com.example.pruebaGML.dto;
import java.time.LocalDateTime;
import java.util.Date;
public class ClienteDTO {

    private Long id;
    private String keyClient;
    private String name;
    private String email;
    private String phone;
    private Date dateAdded;
    private Date startDate;
    private Date endDate;

    public ClienteDTO() {
    }

    public ClienteDTO(Long id, String keyClient, String name, String email, String phone, Date dateAdded, Date startDate, Date endDate) {
        this.id = id;
        this.keyClient = keyClient;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dateAdded = dateAdded;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyClient() {
        return keyClient;
    }

    public void setKeyClient(String keyClient) {
        this.keyClient = keyClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

