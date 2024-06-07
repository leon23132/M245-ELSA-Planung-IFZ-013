package m459.TodoApplication.TodoApp.Repository;

import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import m459.TodoApplication.TodoApp.Model.UserSq;

@Repository
public interface UserSqRepository extends JpaRepository<UserSq, Integer> {
    @Query("SELECT u.username AS username, sq.sqName AS sqName, sq.sqDescription AS sqDescription, m.moduleDay AS modulDay, us.userSqStatus AS userSqStatus "
            +
            "FROM UserSq us " +
            "JOIN us.user u " +
            "JOIN us.sideQuest sq " +
            "JOIN sq.module m " +
            "WHERE u.username = :username AND m.moduleDay = :day " +
            "ORDER BY m.moduleDay, u.username")
    List<Map<String, Object>> findUserSqsByUsernameAndDay(@Param("username") String username, @Param("day") String day);

    @Query("SELECT usq FROM UserSq usq " +
            "JOIN usq.sideQuest sq " +
            "JOIN sq.module m " +
            "JOIN usq.user u " +
            "WHERE u.username = :username " +
            "AND sq.sqWeek = :week " +
            "AND m.moduleDay = :day")
    List<UserSq> findSideQuestsByUsernameWeekAndDay(@Param("username") String username,
            @Param("week") String week,
            @Param("day") String day);
}
