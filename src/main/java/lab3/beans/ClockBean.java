package lab3.beans;

import lombok.Data;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@ManagedBean(name = "clock")
@ApplicationScoped
@Data
public class ClockBean implements Serializable {
    private String time;
    private final SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss yyyy.MM.dd");

    public ClockBean() {
        time = sdfDate.format(new Date());
    }

    public void updateTime() {
        time = sdfDate.format(new Date());
    }
}
