package lab3.beans;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "hits")
@ApplicationScoped
@Data
public class HitsBean implements Serializable {
    @Getter(AccessLevel.NONE)
    private static final int[] X_VALUES = {-4, -3, -2, -1, 0, 1, 2, 3, 4};

    private final List<HitBean> hitBeansList = new ArrayList<>(); // Deque?

    // Manual input
    private boolean[] xArray = new boolean[9];
    private Float y;

    // Canvas input
    private int canvasX;
    private Float canvasY;
    private Float canvasR = 1f;

    public void clear() {
        hitBeansList.clear();
    }

    public void submitManualInputHit(float radius) {
        for (int xChecked = 0; xChecked < xArray.length; xChecked++) {
            if (xArray[xChecked]) {
                hitBeansList.add(new HitBean(X_VALUES[xChecked], y, radius));
            }
        }
    }

    public void submitCanvasClickHit() {
        hitBeansList.add(new HitBean(canvasX, canvasY, canvasR));
    }

    public boolean[] getxArray() {
        return xArray;
    }

    public void setxArray(boolean[] xArray) {
        this.xArray = xArray;
    }
}
