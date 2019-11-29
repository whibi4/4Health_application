package com.yobitrust.forhealth_app.datas;

import com.yobitrust.forhealth_app.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/data")
public class DataController extends BaseController {

    @Autowired
    private DataService dataService;

    @GetMapping(value = {"","/"})
    public ResponseEntity<List<Data>> getAllDataByUser(){
        List<Data> result = dataService.importAllDataOfUser(getCurrentUser().getId());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{time}")
    public ResponseEntity<Data> getDataAtTimeByUser(@PathVariable Long time){
        Data result = dataService.importDataAtTimeOfUser(time,getCurrentUser().getId());
        return new ResponseEntity<>(result,HttpStatus.OK);
    }


    @GetMapping("/{from}/{to}")
    public ResponseEntity<List<Data>> getDataBetweenByUser(@PathVariable("from") Long from , @PathVariable("to") Long to){
        List<Data> result = dataService.importDataBetweenTimeOfUser(from,to,getCurrentUser().getId());
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PostMapping(value = {"","/"})
    public ResponseEntity<Data> saveDataOfUser(@Valid @RequestBody Data data){
        data.setUserId(getCurrentUser().getId());
        Data result = dataService.saveData(data);
        return new ResponseEntity<>(result,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDataOfUser(@PathVariable String id){
        dataService.deleteData(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
