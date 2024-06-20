package m459.TodoApplication.TodoApp.Model;

import org.openqa.selenium.devtools.v119.v119CdpInfo;

import jakarta.persistence.*;
import m459.TodoApplication.TodoApp.Model.Users.User;

@Entity
@Table(name = "user_sqs")
public class UserSq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "sq_id", nullable = false)
    private Sidequests sideQuest;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "user_sq_status", nullable = false)
    private int userSqStatus;

    @Column(name = "user_sq_status_finish", nullable = false)
    private int userSqStatusFinish;

    // Standardkonstruktor
    public UserSq() {
    }

    // Getters und Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sidequests getSideQuest() {
        return sideQuest;
    }

    public void setSideQuest(Sidequests sideQuest) {
        this.sideQuest = sideQuest;
    }

    public User getUser() {
        return user;
    }



    public void setUser(User user) {
        this.user = user;
    }

    public int getUserSqStatus() {
        return userSqStatus;
    }

    public void setUserSqStatus(int userSqStatus) {
        this.userSqStatus = userSqStatus;
    }

    public int getUserSqStatusFinish() {
        return userSqStatusFinish;
    }

    public void setUserSqStatusFinish(int userSqStatusFinish) {
        this.userSqStatusFinish = userSqStatusFinish;
    }

    // Methoden zur Setzung von IDs, um die Assoziationen zu vereinfachen
    public void setSideQuestID(int sq_id) {
        if (this.sideQuest == null) {
            this.sideQuest = new Sidequests();
        }
        this.sideQuest.setSqId(sq_id);
    }

    public void setUserId(Long user_id) {
        if (this.user == null) {
            this.user = new User();
        }
        this.user.setId(user_id);
    }

    // Methode zur Aktualisierung der Benutzerstatusinformationen
    public void updateStatusInfo(int userSqStatus, int userSqStatusFinish) {
        this.userSqStatus = userSqStatus;
        this.userSqStatusFinish = userSqStatusFinish;
    }
}
