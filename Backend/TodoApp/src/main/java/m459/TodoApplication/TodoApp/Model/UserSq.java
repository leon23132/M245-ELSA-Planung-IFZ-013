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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sq_id", nullable = false)
    private SideQuest sideQuest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "user_sqStatus", nullable = false)
    private int userSqStatus;

    // Constructors, getters, and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SideQuest getSideQuest() {
        return sideQuest;
    }

    public void setSideQuest(SideQuest sideQuest) {
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
}

