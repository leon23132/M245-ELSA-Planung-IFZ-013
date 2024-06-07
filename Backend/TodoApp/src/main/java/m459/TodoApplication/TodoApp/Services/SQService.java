package m459.TodoApplication.TodoApp.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m459.TodoApplication.TodoApp.Model.UserSq;
import m459.TodoApplication.TodoApp.Repository.UserSqRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import m459.TodoApplication.TodoApp.Model.Module;
import m459.TodoApplication.TodoApp.Model.Sidequests;
import m459.TodoApplication.TodoApp.Repository.ModuleRepository;
import m459.TodoApplication.TodoApp.Repository.SideQuestRepository;
import m459.TodoApplication.TodoApp.Repository.UserRepository;

@Service
public class SQService {

    private final ModuleRepository moduleRepository;
    private final SideQuestRepository sideQuestRepository;
    private final UserSqRepository userSqRepository;
    private final UserRepository userRepository;

    @Autowired
    public SQService(ModuleRepository moduleRepository, SideQuestRepository sideQuestRepository,
            UserSqRepository userSqRepository, UserRepository userRepository) {
        this.moduleRepository = moduleRepository;
        this.userSqRepository = userSqRepository;
        this.sideQuestRepository = sideQuestRepository;
        this.userRepository = userRepository;
    }
    /*
     * public List<UserSq> getUserSqsByUsernameAndDay(String username, String day) {
     * return userSqRepository.findUserSqsByUsernameAndDay(username, day);
     * }
     */

     public List<Map<String, Object>> getUserSqsByUsernameAndDay(String username, String day) {
        List<Map<String, Object>> result = new ArrayList<>();
    
        List<Map<String, Object>> queryResult = userSqRepository.findUserSqsByUsernameAndDay(username, day);
        for (Map<String, Object> row : queryResult) {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("username", row.get("username"));
            resultMap.put("sqName", row.get("sqName"));
            resultMap.put("sqDescription", row.get("sqDescription"));
            resultMap.put("modulDay", row.get("modulDay"));
            resultMap.put("userSqStatus", row.get("userSqStatus"));
            result.add(resultMap);
        }
    
        return result;
    }
    

    public List<UserSq> getAllUserSqs() {
        return userSqRepository.findAll();
    }

    public List<Module> getAllModule() {
        return moduleRepository.findAll();
    }

    public List<Sidequests> getAllSideQuests() {
        return sideQuestRepository.findAll();

    }

    public Optional<UserSq> getUserSqById(int id) {
        return userSqRepository.findById(id);
    }
    
    
    /*

 // SQService.java
public UserSq updateUserSq(UserSq userSq) {
    // Überprüfen, ob der Eintrag existiert
    Optional<UserSq> existingUserSqOptional = userSqRepository.findById(userSq.getId());
    if (existingUserSqOptional.isPresent()) {
        UserSq existingUserSq = existingUserSqOptional.get();
        // Aktualisiere die relevanten Felder
        existingUserSq.setUserSqStatus(userSq.getUserSqStatus());
        existingUserSq.setUserSqStatusFinish(userSq.getUserSqStatusFinish());
        // Speichere die Aktualisierung
        return userSqRepository.save(existingUserSq);
    } else {
        // Wenn der Eintrag nicht gefunden wurde, kannst du entsprechend reagieren
        // Hier werfe ich eine IllegalArgumentException, du kannst aber auch eine andere Exception werfen oder anderweitig reagieren
        throw new IllegalArgumentException("UserSq not found with id: " + userSq.getId());
    }
}

*/

private final Logger logger = LoggerFactory.getLogger(SQService.class);

// Andere Methoden...

public UserSq updateUserSq(UserSq userSq) {
    // Überprüfen, ob der Eintrag existiert
    Optional<UserSq> existingUserSqOptional = userSqRepository.findById(userSq.getId());
    if (existingUserSqOptional.isPresent()) {
        UserSq existingUserSq = existingUserSqOptional.get();
        // Aktualisiere die relevanten Felder
        existingUserSq.setUserSqStatus(userSq.getUserSqStatus());
        existingUserSq.setUserSqStatusFinish(userSq.getUserSqStatusFinish());
        // Speichere die Aktualisierung
        UserSq updatedUserSq = userSqRepository.save(existingUserSq);
        logger.info("UserSq erfolgreich aktualisiert: {}", updatedUserSq);
        return updatedUserSq;
    } else {
        // Wenn der Eintrag nicht gefunden wurde
        logger.error("UserSq nicht gefunden mit ID: {}", userSq.getId());
        throw new IllegalArgumentException("UserSq not found with id: " + userSq.getId());
    }
}

public List<UserSq> findSideQuestsByUsernameWeekAndDay(String username, String week, String day) {
    return userSqRepository.findSideQuestsByUsernameWeekAndDay(username, week, day);
}


    
}