package br.com.italo.todolist.user;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.italo.todolist.task.ITaskRepository;
import br.com.italo.todolist.task.TaskController;
import br.com.italo.todolist.task.TaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity createUser(@RequestBody UserModel userModel) {
        var user = this.userRepository.findByUsername(userModel.getUsername());
        if(user != null){
            return ResponseEntity.badRequest().body("Usuário já existe!");
        }
        var passwordHashred = BCrypt.withDefaults()
                .hashToString(12, userModel.getPassword().toCharArray());

        userModel.setPassword(passwordHashred);

        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.ok(userModel);
    }
}
