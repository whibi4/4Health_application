package com.yobitrust.forhealth_app.datas;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DataRepository extends MongoRepository<Data,String> {

    Data findByTimestampAndUserId(long timestamp , String userId);
    List<Data> findByUserId(String userId);
    List<Data> findByTimestampBetweenAndUserId(long from , long to , String userId);

}
