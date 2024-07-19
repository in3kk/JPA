package hello_jpa;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

//@Embeddable
public class Period {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    Period(){}

    public Period(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean isWork(){
        return true;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
}
