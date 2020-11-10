package lab3.beans;

import lombok.Data;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
@Data
public class HitBean {
    private boolean[] xArray = new boolean[9]; // for regular input
    private int x; // for canvas input
    private float y; // both
    private float r; // god help
    private boolean successful;
}
