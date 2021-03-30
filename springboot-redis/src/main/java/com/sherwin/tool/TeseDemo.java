package com.sherwin.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TeseDemo implements ApplicationRunner {
    @Autowired
    HashUtil hashUtil;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        /*Map<String, Object> user1 = new HashMap<>();
        user1.put("id",1);
        user1.put("name","Sherwin");
        Map<String, Object> user2 = new HashMap<>();
        user2.put("id",2);
        user2.put("name","Sky");
        hashUtil.putAll("user1", user1);
        hashUtil.putAll("user2", user2);*/
        int id = (int)hashUtil.get("user2", "id");
        String name = (String)hashUtil.get("user1", "name");
    }
}
