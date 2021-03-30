package sherwin;

import com.sherwin.RedisApplication;
import com.sherwin.tool.ListUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = RedisApplication.class)
@RunWith(SpringRunner.class)
public class TestRedisListUtil {

    @Autowired
    private ListUtil listUtil;

    @Test
    public void leftPushAll() {
        List<Object> strings = new ArrayList<>();
        strings.add("c++");
        strings.add("java");
        strings.add("python");
        strings.add("Go");
        listUtil.leftPushAll("list_1",strings);
    }

    @Test
    public void range(){
        List<Object> list_1 = listUtil.range("list_1",0,-1);
        System.out.println(list_1);//[Go, python, java, c++]
    }
    @Test
    public void index(){
        Object list_1 = listUtil.index("list_1", 1);
        System.out.println(list_1);
    }
    @Test
    public void leftPop(){
        listUtil.leftPop("list_1");
    }
}
