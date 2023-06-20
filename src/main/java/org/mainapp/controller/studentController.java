package org.mainapp.controller;

import org.mainapp.cls.Student;
import org.mainapp.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.desktop.SystemEventListener;
import java.lang.reflect.Array;
import java.util.*;

@RestController
public class studentController {
    @Autowired
    private StudentMapper studentMapper;
    @GetMapping("/humanview")
    public String hello(){
        StringBuilder ret = new StringBuilder();
        List<Student> stuList = studentMapper.selectList(null);
        for (int i = 0; i < stuList.size(); i++) {
            Student s = stuList.get(i);
            ret.append(s.toString()).append("<p>");
        }
        return ret.toString();
    }

//    @GetMapping("/jsonview"){
//        List<Student> stuList = studentMapper.selectList(null);
//
//    }

    @PostMapping(value = "/addStudent")
    public String addStudent(@RequestBody Student s){
        System.out.println("ReqRecieved!\n");
        studentMapper.insert(s);
        return "Sucess!";
    }

    @PostMapping(value = "/delStudent")
    public String delStudent(@RequestBody Map<String, String> map){
        System.out.println("ReqRecieved!\n");
        Map m = new HashMap();

        Set<String> key_set = map.keySet();

        for (String key: key_set) {
            String value = map.get(key);
            m.put(key,value);
        }

        studentMapper.deleteByMap(m);
        return "Sucess!";
    }

}
