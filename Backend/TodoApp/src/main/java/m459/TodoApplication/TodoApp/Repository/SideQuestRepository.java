package m459.TodoApplication.TodoApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import m459.TodoApplication.TodoApp.Model.SideQuest;

@Repository
public interface SideQuestRepository extends JpaRepository<SideQuest, Integer> {

}
