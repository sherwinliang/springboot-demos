package sherwin;

import com.sherwin.RedisApplication;
import com.sherwin.tool.HashUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = {RedisApplication.class}, properties = {"spring.config.location=classpath:/applicationRedis.properties"})
@RunWith(SpringRunner.class)
public class TestRedisHashUtil {
    @Autowired
    HashUtil hashUtil;

    @Test
    public void putAll(){
        Map<String, Object> user1 = new HashMap<>();
        user1.put("id",1);
        user1.put("name","Sherwin");
        Map<String, Object> user2 = new HashMap<>();
        user2.put("id",2);
        user2.put("name","Sky");
        hashUtil.putAll("user1", user1);
        hashUtil.putAll("user2", user2);
        int id = (int)hashUtil.get("user2", "id");
        String name = (String)hashUtil.get("user1", "name");
        Assert.assertEquals(2, id);
        Assert.assertEquals("Sherwin", name);
    }
}
