package practice.basics;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jTest {

    final Logger logger = LoggerFactory.getLogger(Slf4jTest.class);
    Integer nowt = 30;
    Integer oldT;
    
    public void setTemperature(Integer temperature) {
        
        oldT = nowt;
        nowt = temperature;

        //对trace/debug/info级别的日志输出,必须使用条件输出形式或使用占位符的方式--规约P21/34--尽量用占位符
        logger.debug("Temperature set to {}. Old temperature was {}.", nowt, oldT);

        if(temperature.intValue() > 50) {
            logger.info("Temperature has risen above 50 degrees.");
        }
    }

    @Test
    public void setTemperatureTest() {
        Slf4jTest slf4jTest = new Slf4jTest();
        Integer setT = 61;
        slf4jTest.setTemperature(setT);
    }
    
}