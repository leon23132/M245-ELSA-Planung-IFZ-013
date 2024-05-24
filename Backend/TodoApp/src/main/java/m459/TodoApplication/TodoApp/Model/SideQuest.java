package m459.TodoApplication.TodoApp.Model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sidequests")
public class SideQuest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sqId;

    @Column(name = "sq_Name", nullable = false)
    private String sqName;

    @Column(name = "sq_Description", nullable = false)
    private String sqDescription;

    @Column(name = "sq_Day", nullable = false)
    private String sqDay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Module_modul_id", nullable = false)
    private Module module;

    @Column(name = "sq_time", nullable = false)
    private String sqTime;

    @Column(name = "sq_Week", nullable = false)
    private String sqWeek;

    @Column(name = "sq_deadline", nullable = false)
    private Date sqDeadline;

    // Constructors, getters, and setters
    public int getSqId() {
        return sqId;
    }

    public void setSqId(int sqId) {
        this.sqId = sqId;
    }

    public String getSqName() {
        return sqName;
    }

    public void setSqName(String sqName) {
        this.sqName = sqName;
    }

    public String getSqDescription() {
        return sqDescription;
    }

    public void setSqDescription(String sqDescription) {
        this.sqDescription = sqDescription;
    }

    public String getSqDay() {
        return sqDay;
    }

    public void setSqDay(String sqDay) {
        this.sqDay = sqDay;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public String getSqTime() {
        return sqTime;
    }

    public void setSqTime(String sqTime) {
        this.sqTime = sqTime;
    }

    public String getSqWeek() {
        return sqWeek;
    }

    public void setSqWeek(String sqWeek) {
        this.sqWeek = sqWeek;
    }

    public Date getSqDeadline() {
        return sqDeadline;
    }

    public void setSqDeadline(Date sqDeadline) {
        this.sqDeadline = sqDeadline;
    }
}

