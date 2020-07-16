
package com.example.miniproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("PassengerID")
    @Expose
    private String passengerID;
    @SerializedName("CoachNo")
    @Expose
    private String coachNo;
    @SerializedName("SeatNo")
    @Expose
    private Integer seatNo;
    @SerializedName("IsBoarded")
    @Expose
    private Integer isBoarded;
    @SerializedName("AllocatedTo")
    @Expose
    private Integer allocatedTo;
    @SerializedName("WLSequence")
    @Expose
    private Integer wLSequence;
    @SerializedName("PNR")
    @Expose
    private String pNR;
    @SerializedName("BoardingFrom")
    @Expose
    private String boardingFrom;
    @SerializedName("BoardingUpto")
    @Expose
    private String boardingUpto;
    @SerializedName("ConfirmationStatus")
    @Expose
    private String confirmationStatus;
    @SerializedName("PassengerMAsterID")
    @Expose
    private Integer passengerMAsterID;
    @SerializedName("Age")
    @Expose
    private String age;
    @SerializedName("Gender")
    @Expose
    private String gender;
    @SerializedName("PassengerName")
    @Expose
    private String passengerName;
    @SerializedName("TrainID")
    @Expose
    private String trainID;
    @SerializedName("TrainMasterID")
    @Expose
    private String trainMasterID;
    @SerializedName("TrainNumber")
    @Expose
    private String trainNumber;
    @SerializedName("TrainName")
    @Expose
    private String trainName;

    public String getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(String passengerID) {
        this.passengerID = passengerID;
    }

    public String getCoachNo() {
        return coachNo;
    }

    public void setCoachNo(String coachNo) {
        this.coachNo = coachNo;
    }

    public Integer getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(Integer seatNo) {
        this.seatNo = seatNo;
    }

    public Integer getIsBoarded() {
        return isBoarded;
    }

    public void setIsBoarded(Integer isBoarded) {
        this.isBoarded = isBoarded;
    }

    public Integer getAllocatedTo() {
        return allocatedTo;
    }

    public void setAllocatedTo(Integer allocatedTo) {
        this.allocatedTo = allocatedTo;
    }

    public Integer getWLSequence() {
        return wLSequence;
    }

    public void setWLSequence(Integer wLSequence) {
        this.wLSequence = wLSequence;
    }

    public String getPNR() {
        return pNR;
    }

    public void setPNR(String pNR) {
        this.pNR = pNR;
    }

    public String getBoardingFrom() {
        return boardingFrom;
    }

    public void setBoardingFrom(String boardingFrom) {
        this.boardingFrom = boardingFrom;
    }

    public String getBoardingUpto() {
        return boardingUpto;
    }

    public void setBoardingUpto(String boardingUpto) {
        this.boardingUpto = boardingUpto;
    }

    public String getConfirmationStatus() {
        return confirmationStatus;
    }

    public void setConfirmationStatus(String confirmationStatus) {
        this.confirmationStatus = confirmationStatus;
    }

    public Integer getPassengerMAsterID() {
        return passengerMAsterID;
    }

    public void setPassengerMAsterID(Integer passengerMAsterID) {
        this.passengerMAsterID = passengerMAsterID;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getTrainID() {
        return trainID;
    }

    public void setTrainID(String trainID) {
        this.trainID = trainID;
    }

    public String getTrainMasterID() {
        return trainMasterID;
    }

    public void setTrainMasterID(String trainMasterID) {
        this.trainMasterID = trainMasterID;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

}
