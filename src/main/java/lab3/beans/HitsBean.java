package lab3.beans;

import lombok.Data;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ApplicationScoped
@Data
public class HitsBean {
    private HitBean newHitBean = new HitBean();
    private final List<HitBean> hitBeansList = new ArrayList<>(); // Deque?

    public void registerHit() {
        hitBeansList.add(newHitBean);
        newHitBean = new HitBean();
    }
}
