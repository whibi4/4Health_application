package com.yobitrust.forhealth_app.datas;

public class Payload {
    private double heartBeat ;
    private double temperature ;
    private double bloodSugar ;
    private double cholesterol ;
    private String bloodPressure;
    private double bloodIron;

    public Payload(double heartBeat, double temperature, double bloodSugar, double cholesterol, String bloodPressure, double bloodIron) {
        this.heartBeat = heartBeat;
        this.temperature = temperature;
        this.bloodSugar = bloodSugar;
        this.cholesterol = cholesterol;
        this.bloodPressure = bloodPressure;
        this.bloodIron = bloodIron;
    }

    public double getHeartBeat() {
        return heartBeat;
    }

    public void setHeartBeat(double heartBeat) {
        this.heartBeat = heartBeat;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getBloodSugar() {
        return bloodSugar;
    }

    public void setBloodSugar(double bloodSugar) {
        this.bloodSugar = bloodSugar;
    }

    public double getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(double cholesterol) {
        this.cholesterol = cholesterol;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public double getBloodIron() {
        return bloodIron;
    }

    public void setBloodIron(double bloodIron) {
        this.bloodIron = bloodIron;
    }
}
