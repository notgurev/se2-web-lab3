package lab3.beans;

import lab3.utils.ArrayUtils;
import lab3.validation.ValidatorY;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.faces.application.FacesMessage.SEVERITY_WARN;
import static lab3.utils.FacesUtils.addFacesMessage;

@ManagedBean(name = "hits")
@ApplicationScoped
@Data
public class HitsBean implements Serializable {
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

    public boolean validateManualInputs() {
        if (!ArrayUtils.containsTrue(xArray)) { // no Xs chosen
            addFacesMessage(SEVERITY_WARN, "Warning!", "Please select at least one X coordinate");
            return false;
        }
        return true;
    }

    public void submitManualInputHit(float radius) {
        if (validateManualInputs()) return;
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
