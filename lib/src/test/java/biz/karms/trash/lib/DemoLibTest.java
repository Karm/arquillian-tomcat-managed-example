package biz.karms.trash.lib;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Michal Karm Babacek
 */
public class DemoLibTest {

    @Test
    public void stupidNumberUnitTest() {
        final DemoLib demoLib = new DemoLib();
        Assert.assertEquals(demoLib.getNumAndIncrement(), 0, "MUST be zero initially");
        Assert.assertEquals(demoLib.getNumAndIncrement(), 1, "MUST be one by now");
    }
}
