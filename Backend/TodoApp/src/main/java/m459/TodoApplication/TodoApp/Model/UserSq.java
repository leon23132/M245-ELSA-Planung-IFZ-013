package m459.TodoApplication.TodoApp.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import m459.TodoApplication.TodoApp.Model.Users.User;

@Entity
@Table(name = "user_sqs")
public class UserSq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY) // Änderung hier: FetchType.LAZY
    @JoinColumn(name = "sq_id", nullable = false)
    private Sidequests sideQuest;

    @ManyToOne(fetch = FetchType.LAZY) // Änderung hier: FetchType.LAZY
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "user_sq_status", nullable = false)
    private int userSqStatus;

    @Column(name = "user_sq_status_finish", nullable = false)
    private int userSqStatusFinish;

    // Constructors

    public UserSq() {
    }

    // Getters and Setters

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

    // Methode zur Aktualisierung der Benutzerstatusinformationen
    public void updateStatusInfo(int userSqStatus, int userSqStatusFinish) {
        this.userSqStatus = userSqStatus;
        this.userSqStatusFinish = userSqStatusFinish;
    }
}
