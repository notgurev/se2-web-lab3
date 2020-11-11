package lab3.beans;

import lombok.Data;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "hits")
@ApplicationScoped
@Data
public class HitsBean {
    private static final int[] X_VALUES = {-4, -3, -2, -1, 0, 1, 2, 3, 4};
    private final List<HitBean> hitBeansList = new ArrayList<>(); // Deque?
    private boolean[] xArray = new boolean[9]; // for regular input
    private int x; // for canvas input
    private Float y; // both

    public void registerHit(float radius, boolean singleX) {
        if (singleX) {
            hitBeansList.add(new HitBean(x, y, radius));
        } else {
            for (int xChecked = 0; xChecked < xArray.length; xChecked++) {
                if (xArray[xChecked]) {
                    hitBeansList.add(new HitBean(X_VALUES[xChecked], y, radius));
                }
            }
        }
    }

    public boolean[] getxArray() {
        return xArray;
    }

    public void setxArray(boolean[] xArray) {
        this.xArray = xArray;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }
}
