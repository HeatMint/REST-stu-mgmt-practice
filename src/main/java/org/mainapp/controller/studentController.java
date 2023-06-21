package org.mainapp.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.mainapp.cls.Student;
import org.mainapp.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.desktop.SystemEventListener;
import java.lang.reflect.Array;
import java.util.*;

@RestController
public class studentController {
    @Autowired
    private StudentMapper studentMapper;
    @GetMapping("/humanview")
    public String humanView(@RequestParam Map<String, Object> map){
        StringBuilder ret = new StringBuilder();
        List<Student> stuList = studentMapper.selectByMap(map);

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
    public String delStudent(@RequestBody Map<String, Object> map){
        System.out.println("ReqRecieved!\n");
//        Map m = new HashMap();
//
//        Set<String> key_set = map.keySet();
//
//        for (String key: key_set) {
//            String value = map.get(key);
//            m.put(key,value);
//        }
        //昨天脑子昏头咋了写这玩意出来

        studentMapper.deleteByMap(map);
        return "Sucess!";
    }

    @PostMapping(value = "/edit/{studentName}")
    public String editStudent(@PathVariable String studentName, @RequestBody Map<String, String> map){
        UpdateWrapper<Student> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name", studentName);
        for (String key:
             map.keySet()) {
            updateWrapper.set(key,map.get(key));
        }
        studentMapper.update(null,updateWrapper);
        return "Sucess!";
    }

}

