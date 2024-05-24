package m459.TodoApplication.TodoApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import m459.TodoApplication.TodoApp.Model.UserSq;

@Repository
public interface UserSqRepository extends JpaRepository<UserSq, Integer> {

    @Query("SELECT us FROM UserSq us " +
           "JOIN us.user u " +
           "JOIN us.sideQuest sq " +
           "JOIN sq.module m " +
           "WHERE u.username = :username AND m.modulDay = :day")
    List<UserSq> findUserSqsByUsernameAndDay(String username, String day);
}
