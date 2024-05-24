package m459.TodoApplication.TodoApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import m459.TodoApplication.TodoApp.Model.Modules;

@Repository
public interface ModuleRepository extends JpaRepository<Modules, Integer> {
}
