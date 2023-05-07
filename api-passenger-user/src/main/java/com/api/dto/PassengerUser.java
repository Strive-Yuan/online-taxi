package com.api.dto;

import java.time.LocalDateTime;

public class PassengerUser {
    private Long id;
    private LocalDateTime gmtCreate; //创建时间
    private LocalDateTime gmtModified; //修改时间
    private String passengerPhone; //手机号
    private String passengerName; //乘客名
    private Integer passengerGender; //性别(0:女，1:男)
    private Integer state; //状态(0：有效,1:无效)


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getPassengerPhone() {
        return passengerPhone;
    }

    public void setPassengerPhone(String passengerPhone) {
        this.passengerPhone = passengerPhone;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Integer getPassengerGender() {
        return passengerGender;
    }

    public void setPassengerGender(Integer passengerGender) {
        this.passengerGender = passengerGender;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
