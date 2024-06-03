package m459.TodoApplication.TodoApp.Repository;
import m459.TodoApplication.TodoApp.Model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Integer> {

}
