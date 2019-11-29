package com.yobitrust.forhealth_app.datas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService{

    @Autowired
    private DataRepository dataRepository;

    public List<Data> importAllDataOfUser(String userId){
        return dataRepository.findByUserId(userId);
    }

    public Data importDataAtTimeOfUser(long timestamp , String userId){
        return dataRepository.findByTimestampAndUserId(timestamp,userId);
    }

    public List<Data> importDataBetweenTimeOfUser(long from , long to , String userId){
        return dataRepository.findByTimestampBetweenAndUserId(from,to,userId);
    }

    public Data saveData(Data data){
        data.payloadToProcess();
        return dataRepository.save(data);
    }

    public void deleteData(String id){
        dataRepository.deleteById(id);
    }
}
