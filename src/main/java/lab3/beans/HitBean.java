package lab3.beans;

import lab3.utils.HitChecker;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "hit") // todo это должно быть в отдельном файле
@ApplicationScoped
public class HitBean {
    private int x;
    private Float y;
    private float r;
    private boolean successful;

    public HitBean() {
    }

    public HitBean(int x, Float y, float r) {
        this.x = x;
        this.y = y;
        this.r = r;
        successful = HitChecker.checkArea(x, y, r);
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

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
}
