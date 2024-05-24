package m459.TodoApplication.TodoApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import m459.TodoApplication.TodoApp.Model.UserSq;
import m459.TodoApplication.TodoApp.Services.SQService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/SQS")
public class SQController {

    private final SQService sqService;

    @Autowired
    public SQController(SQService sqService) {
        this.sqService = sqService;
    }

    @GetMapping("/filtered")
    public List<UserSq> getUserSqsByUsernameAndDay(@RequestParam String username, @RequestParam String day) {
        return sqService.getUserSqsByUsernameAndDay(username, day);
    }

}
