package m459.TodoApplication.TodoApp.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "module")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "modul_id")
    private int modulId;

    @Column(name = "modul_name")
    private String moduleName;

    @Column(name = "modul_description")
    private String moduleDescription;

    @Column(name = "modul_day")
    private String moduleDay;

    // Standardkonstruktor
    public Module() {
    }

    // Getters und Setters
    public int getModulId() {
        return modulId;
    }

    public void setModulId(int modulId) {
        this.modulId = modulId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleDescription() {
        return moduleDescription;
    }

    public void setModuleDescription(String moduleDescription) {
        this.moduleDescription = moduleDescription;
    }

    public String getModuleDay() {
        return moduleDay;
    }

    public void setModuleDay(String moduleDay) {
        this.moduleDay = moduleDay;
    }
}
