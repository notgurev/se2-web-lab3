package lab3.beans;

import lab3.utils.ArrayUtils;
import lab3.utils.FacesUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javax.faces.application.FacesMessage.SEVERITY_ERROR;

@Data
public class HitsManager implements Serializable {
    private static final Integer[] X_VALUES = {-4, -3, -2, -1, 0, 1, 2, 3, 4};
    private static final float MAX_Y = 3;
    private static final float MIN_Y = -3;

    private final List<Hit> hitBeansList = new ArrayList<>(); // Deque?

    // Manual input
    private boolean[] manualInputXs = new boolean[9];
    private Float y;

    // Canvas input
    private int canvasX;
    private Float canvasY;
    private Float canvasR = 1f;

    public void clear() {
        hitBeansList.clear();
    }

    private boolean validateManualInputs() {
        if (!ArrayUtils.containsTrue(manualInputXs)) { // no Xs chosen
            FacesUtils.addFacesMessage(SEVERITY_ERROR, "Please select at least one X coordinate");
            return false;
        }
        return true;
    }

    private boolean validateCanvasX() {
        return Arrays.asList(X_VALUES).contains(canvasX);
    }

    public void submitManualInputHit(float radius) {
        if (!validateManualInputs()) return;
        for (int xChecked = 0; xChecked < manualInputXs.length; xChecked++) {
            if (manualInputXs[xChecked]) {
                hitBeansList.add(new Hit(X_VALUES[xChecked], y, radius));
            }
        }
    }

    public void submitCanvasClickHit() {
        if (!validateCanvasX()) return;
        hitBeansList.add(new Hit(canvasX, canvasY, canvasR));
    }
}
