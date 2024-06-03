package m459.TodoApplication.TodoApp.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import m459.TodoApplication.TodoApp.Model.UserSq;

@Repository
public interface UserSqRepository extends JpaRepository<UserSq, Integer> {
    @Query("SELECT u.username, sq.sqName, sq.sqDescription, m.moduleDay, us.userSqStatus " +
            "FROM UserSq us " +
            "JOIN us.user u " +
            "JOIN us.sideQuest sq " +
            "JOIN sq.module m " +
            "WHERE u.username = :username AND m.moduleDay = :day " +
            "ORDER BY m.moduleDay, u.username")
    List<Object[]> findUserSqsByUsernameAndDay(@Param("username") String username, @Param("day") String day);
}
