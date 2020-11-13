package lab3.beans;

import lab3.utils.ArrayUtils;
import lab3.utils.FacesUtils;
import lombok.Data;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.faces.application.FacesMessage.SEVERITY_ERROR;

@ManagedBean(name = "hits")
@ApplicationScoped
@Data
public class HitsBean implements Serializable {
    private static final int[] X_VALUES = {-4, -3, -2, -1, 0, 1, 2, 3, 4};
    private static final float MAX_Y = 3;
    private static final float MIN_Y = -3;

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

    private boolean validateManualInputs() {
        if (!ArrayUtils.containsTrue(xArray)) { // no Xs chosen
            FacesUtils.addFacesMessage(SEVERITY_ERROR, "Please select at least one X coordinate");
            return false;
        }
        return true;
    }

    private boolean validateCanvasYLimits() {
        if (canvasY <= MIN_Y || canvasY >= MAX_Y) {
            FacesUtils.addFacesMessage(SEVERITY_ERROR, "Y must be in range (-4 ... 4)");
            return false;
        }
        return true;
    }

    public void submitManualInputHit(float radius) {
        if (!validateManualInputs()) return;
        for (int xChecked = 0; xChecked < xArray.length; xChecked++) {
            if (xArray[xChecked]) {
                hitBeansList.add(new HitBean(X_VALUES[xChecked], y, radius));
            }
        }
    }

    public void submitCanvasClickHit() {
        if (!validateCanvasYLimits()) return;
        hitBeansList.add(new HitBean(canvasX, canvasY, canvasR));
    }

    public boolean[] getxArray() {
        return xArray;
    }

    public void setxArray(boolean[] xArray) {
        this.xArray = xArray;
    }
}
