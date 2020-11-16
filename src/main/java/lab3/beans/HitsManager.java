package lab3.beans;

import lab3.database.HitRepository;
import lab3.database.Repository;
import lab3.utils.ArrayUtils;
import lab3.utils.FacesUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import static javax.faces.application.FacesMessage.SEVERITY_ERROR;

@Data
public class HitsManager implements Serializable {
    private static final Integer[] X_VALUES = {-4, -3, -2, -1, 0, 1, 2, 3, 4};
    private static final float MAX_Y = 3;
    private static final float MIN_Y = -3;

    private Repository<Hit> hitRepository = new HitRepository(); // todo @inject (and @Default or something)
    private List<Hit> hitBeansList = hitRepository.getAll(); // todo make a @PostConstruct init if hitRep is injected

    // Manual input
    private boolean[] manualInputXs = new boolean[9];
    private Float y;

    // Canvas input
    private int canvasX;
    private Float canvasY;
    private Float canvasR = 1f;

    public void clear() {
        hitBeansList.clear();
        hitRepository.clear();
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

    private void addHit(int x, float y, float r) {
        Hit hit = new Hit(x, y, r);
        hitBeansList.add(hit);
        hitRepository.save(hit);
    }

    public void submitManualInputHit(float radius) {
        if (!validateManualInputs()) return;
        for (int xChecked = 0; xChecked < manualInputXs.length; xChecked++) {
            if (manualInputXs[xChecked]) {
                addHit(X_VALUES[xChecked], y, radius);
            }
        }
    }

    public void submitCanvasClickHit() {
        if (!validateCanvasX()) return;
        addHit(canvasX, canvasY, canvasR);
    }
}
