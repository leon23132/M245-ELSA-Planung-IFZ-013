package m459.TodoApplication.TodoApp.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import m459.TodoApplication.TodoApp.Model.Module;

import m459.TodoApplication.TodoApp.Model.Sidequests;
import m459.TodoApplication.TodoApp.Model.UserSq;
import m459.TodoApplication.TodoApp.Model.Users.User;
import m459.TodoApplication.TodoApp.Services.SQService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/sqs")
public class SQController {

    private final SQService sqService;

    @Autowired
    public SQController(SQService sqService) {
        this.sqService = sqService;
    }

    @GetMapping("/all")
    public List<UserSq> getAllUserSqs() {
        return sqService.getAllUserSqs();
    }
    @GetMapping("/users/all")
    public List<User> getAllUsers() {
        return sqService.getAllUsers();
    }

    /*
     * @GetMapping("/filtered")
     * public List<UserSq> getUserSqsByUsernameAndDay(@RequestParam String
     * username, @RequestParam String day) {
     * return sqService.getUserSqsByUsernameAndDay(username, day);
     * }
     */
    /*
     * @GetMapping("/filtered")
     * public List<UserSq> getUserSqsByUsernameAndDay(@RequestParam String
     * username, @RequestParam String day) {
     * return sqService.getUserSqsByUsernameAndDay(username, day);
     * }
     */

    @GetMapping("/filtered")
    public List<Map<String, Object>> getUserSqsByUsernameAndDay(@RequestParam String username,
            @RequestParam String day) {
        return sqService.getUserSqsByUsernameAndDay(username, day);
    }

    @GetMapping("/modules/all")
    public List<Module> getAllModules() {
        return sqService.getAllModule();
    }

    @GetMapping("/usersq/all")
    public List<UserSq> getAllUsersqs() {
        return sqService.getAllUserSqs();
    }

    @GetMapping("/sidequests/all")
    public List<Sidequests> getAllSideQuests() {
        return sqService.getAllSideQuests();
    }

    @GetMapping("/usersq/findbyid")
    public Optional<UserSq> getUserSqById(@RequestParam int id) {
        return sqService.getUserSqById(id);
    }

    @PutMapping("/usersq/update")
    public ResponseEntity<UserSq> updateUserSq(@RequestBody UserSq userSq) {
        try {
            UserSq updatedUserSq = sqService.updateUserSq(userSq);
            return new ResponseEntity<>(updatedUserSq, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            // Wenn der UserSq nicht gefunden wurde, wird ein Fehler 404 (Not Found)
            // zurückgegeben
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // Für alle anderen Fehler wird ein Fehler 500 (Internal Server Error)
            // zurückgegeben
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/filteredByWeekAndDay")
    public List<UserSq> getSideQuestsByUsernameWeekAndDay(@RequestParam String username,
            @RequestParam String week,
            @RequestParam String day) {
        return sqService.findSideQuestsByUsernameWeekAndDay(username, week, day);
    }

    @PutMapping("/usersq/updateStatus/{id}/{userSqStatus}")
    public ResponseEntity<UserSq> updateUserSqStatus(@PathVariable int id, @PathVariable int userSqStatus) {
        try {
            UserSq updatedUserSq = sqService.updateUserSqStatus(id, userSqStatus);
            return new ResponseEntity<>(updatedUserSq, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/modules/add")
    public ResponseEntity<Module> addModule(@RequestBody Module module) {
        try {
            Module addedModule = sqService.addModule(module);
            return new ResponseEntity<>(addedModule, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/sidequests/add")
    public ResponseEntity<Sidequests> addSidequest(@RequestBody Sidequests sidequest) {
        Sidequests newSidequest = sqService.addSidequest(sidequest);
        return new ResponseEntity<>(newSidequest, HttpStatus.CREATED);
    }

    @PostMapping("/usersq/add")
    public ResponseEntity<UserSq> addUserSq(@RequestBody UserSq userSq) {
        try {
            UserSq addedUserSq = sqService.addUserSq(userSq);
            return new ResponseEntity<>(addedUserSq, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    

}
