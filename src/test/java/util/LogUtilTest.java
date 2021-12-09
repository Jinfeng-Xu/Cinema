package util;

import com.group11.util.LogUtils;
import org.junit.Test;

public class LogUtilTest {

    @Test
    public void logToFile(){
        LogUtils.logToFile("Test for logUtils");
    }
}
