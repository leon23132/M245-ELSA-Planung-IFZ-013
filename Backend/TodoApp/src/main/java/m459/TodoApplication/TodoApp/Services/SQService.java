package m459.TodoApplication.TodoApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m459.TodoApplication.TodoApp.Model.UserSq;
import m459.TodoApplication.TodoApp.Repository.ModuleRepository;
import m459.TodoApplication.TodoApp.Repository.SideQuestRepository;
import m459.TodoApplication.TodoApp.Repository.UserSqRepository;

@Service
public class SQService {

    private final ModuleRepository moduleRepository;
    private final SideQuestRepository sideQuestRepository;
    private final UserSqRepository userSqRepository;
    @Autowired
    public SQService(ModuleRepository moduleRepository, SideQuestRepository sideQuestRepository, UserSqRepository userSqRepository) {
        this.moduleRepository = moduleRepository;
        this.userSqRepository = userSqRepository;
        this.sideQuestRepository = sideQuestRepository;
    }

   public List<UserSq> getUserSqsByUsernameAndDay(String username, String day) {
        return userSqRepository.findUserSqsByUsernameAndDay(username, day);
    }

}