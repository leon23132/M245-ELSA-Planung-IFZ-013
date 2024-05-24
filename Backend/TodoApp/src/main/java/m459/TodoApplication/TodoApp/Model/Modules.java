package m459.TodoApplication.TodoApp.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "module")
public class Modules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int modulId;

    @Column(name = "modul_description", nullable = false)
    private String modulDescription;

    @Column(name = "modul_name", nullable = false)
    private String modulName;

    @Column(name = "modul_day", nullable = false)
    private String modulDay;

    // Constructors, getters, and setters
    public int getModulId() {
        return modulId;
    }

    public void setModulId(int modulId) {
        this.modulId = modulId;
    }

    public String getModulDescription() {
        return modulDescription;
    }

    public void setModulDescription(String modulDescription) {
        this.modulDescription = modulDescription;
    }

    public String getModulName() {
        return modulName;
    }

    public void setModulName(String modulName) {
        this.modulName = modulName;
    }

    public String getModulDay() {
        return modulDay;
    }

    public void setModulDay(String modulDay) {
        this.modulDay = modulDay;
    }
}
