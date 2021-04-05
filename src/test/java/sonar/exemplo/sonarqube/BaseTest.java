package sonar.exemplo.sonarqube;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BaseTest {

    private String init = "init";

    @Test
    public void initTest(){
        Assert.assertNotNull(init);
    }

}
