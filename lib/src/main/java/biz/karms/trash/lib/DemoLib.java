package biz.karms.trash.lib;

import java.io.Serializable;

/**
 * @author Michal Karm Babacek
 */
public class DemoLib implements Serializable {
    private int num;

    public DemoLib() {
        this.num = 0;
    }

    public int getNum() {
        return num;
    }

    public int getNumAndIncrement() {
        int retVal = this.getNum();
        num++;
        return retVal;
    }

    public void setNum(int num) {
        this.num = num;
    }

}
