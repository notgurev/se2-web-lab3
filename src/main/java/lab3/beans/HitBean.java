package lab3.beans;

import lab3.utils.HitChecker;
import lombok.Data;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@Data
public class HitBean implements Serializable {
    private int x;
    private Float y;
    private float r;
    private boolean successful;

    public HitBean(int x, Float y, float r) {
        this.x = x;
        this.y = y;
        this.r = r;
        successful = HitChecker.checkArea(x, y, r);
    }
}
