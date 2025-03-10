package m459.TodoApplication.TodoApp.Repository;

import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import m459.TodoApplication.TodoApp.Model.UserSq;

@Repository
public interface UserSqRepository extends JpaRepository<UserSq, Integer> {
        UserSq save(UserSq userSq);

        @Query("SELECT u.username AS username, sq.sqName AS sqName, sq.sqDescription AS sqDescription, m.moduleDay AS modulDay, us.userSqStatus AS userSqStatus "
                        +
                        "FROM UserSq us " +
                        "JOIN us.user u " +
                        "JOIN us.sideQuest sq " +
                        "JOIN sq.module m " +
                        "WHERE u.username = :username AND m.moduleDay = :day " +
                        "ORDER BY m.moduleDay, u.username")
        List<Map<String, Object>> findUserSqsByUsernameAndDay(@Param("username") String username,
                        @Param("day") String day);

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

        @Transactional
        @Modifying
        @Query(value = "INSERT INTO user_sqs (sq_id, user_id, user_sqStatus, user_sq_status_finish, user_sq_status) " +
                        "VALUES (:sqId, :userId, :userSqStatus, :userSqStatusFinish, :userSqStatusStr)", nativeQuery = true)
        void insertUserSqCustomQuery(@Param("sqId") int sqId,
                        @Param("userId") long userId,
                        @Param("userSqStatus") int userSqStatus,
                        @Param("userSqStatusFinish") int userSqStatusFinish,
                        @Param("userSqStatusStr") int userSqStatusStr);

}
