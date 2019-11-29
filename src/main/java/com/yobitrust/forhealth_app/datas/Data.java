package com.yobitrust.forhealth_app.datas;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "datas")
public class Data {

    @Id
    private String id;


    private long timestamp;
    private String userId;
    private String payload;
    private String process;

    public Data() {
        this.timestamp = System.currentTimeMillis();
    }

    public Data(String id, String userId, String payload) {
        this.id = id;
        this.timestamp = System.currentTimeMillis();
        this.userId = userId;
        this.payload = payload;
    }

    public int estimator(double a , double b , double x){
        if(x>=b){
            return 1;
        }else if (x<=a){
            return -1;
        }else{
            return 0;
        }
    }

    public void payloadToProcess(){
        String jsonPayload = getPayload();
        int heartBeatPrediction ;
        int temperaturePrediction ;
        int bloodSugarPrediction;
        int cholesterolPrediction ;
        int bloodPressurePrediction ;
        int bloodIronPrediction ;

        Payload obj = new Gson().fromJson(jsonPayload, Payload.class);

        heartBeatPrediction = estimator(60,100,obj.getHeartBeat());
        temperaturePrediction = estimator(36.1,37.2,obj.getTemperature());
        bloodSugarPrediction = estimator(70,130,obj.getBloodSugar());
        cholesterolPrediction = estimator(100,129,obj.getCholesterol());
        bloodIronPrediction = estimator(38.8,50,obj.getBloodIron());

        double bloodPressure1 = Double.parseDouble(obj.getBloodPressure().substring(0,3));
        double bloodPressure2 = Double.parseDouble(obj.getBloodPressure().substring(4,7));

        if (
                (estimator(90,120,bloodPressure1)== 1)||(estimator(60,80,bloodPressure2)==1)
        ){
            bloodPressurePrediction = 1;
        }else if (
                (estimator(90,120,bloodPressure1)== -1)||(estimator(60,80,bloodPressure2)== -1)
        ){
            bloodPressurePrediction = -1;
        }else{
            bloodPressurePrediction = 0;
        }


        Process rslt = new Process(heartBeatPrediction,temperaturePrediction,bloodSugarPrediction,cholesterolPrediction,bloodPressurePrediction,bloodIronPrediction) ;

        setProcess(rslt.toString());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }
}
