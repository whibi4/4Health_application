package com.yobitrust.forhealth_app.datas;

public class Process {
    private int heartBeatPrediction ;
    private int temperaturePrediction ;
    private int bloodSugarPrediction;
    private int cholesterolPrediction ;
    private int bloodPressurePrediction ;
    private int bloodIronPrediction ;
    private int generalHealth ;

    public Process(int heartBeatPrediction, int temperaturePrediction, int bloodSugarPrediction, int cholesterolPrediction, int bloodPressurePrediction, int bloodIronPrediction) {
        this.heartBeatPrediction = heartBeatPrediction;
        this.temperaturePrediction = temperaturePrediction;
        this.bloodSugarPrediction = bloodSugarPrediction;
        this.cholesterolPrediction = cholesterolPrediction;
        this.bloodPressurePrediction = bloodPressurePrediction;
        this.bloodIronPrediction = bloodIronPrediction;
        this.generalHealth = heartBeatPrediction*heartBeatPrediction+temperaturePrediction*temperaturePrediction+bloodSugarPrediction*bloodSugarPrediction+cholesterolPrediction*cholesterolPrediction+bloodPressurePrediction*bloodPressurePrediction+bloodIronPrediction*bloodIronPrediction ;
    }

    @Override
    public String toString() {
        return "{" +
                "\"heartBeatPrediction\" :" + heartBeatPrediction +
                ", \"temperaturePrediction\":" + temperaturePrediction +
                ", \"bloodSugarPrediction\":" + bloodSugarPrediction +
                ", \"cholesterolPrediction\":" + cholesterolPrediction +
                ", \"bloodPressurePrediction\":" + bloodPressurePrediction +
                ", \"bloodIronPrediction\":" + bloodIronPrediction +
                ", \"generalHealth\":" + generalHealth +
                "}";
    }
}
