package com.tdev.crudmaven.controller;
import com.tdev.crudmaven.entity.User;
import com.tdev.crudmaven.repository.UserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


    @RestController
    @RequestMapping("/users")

    public class UserController {


        @Autowired
        private UserRepository userrepo;

        @GetMapping("/")
        public List<User> getAllUsers(){
            return userrepo.findAll();
        }


        @PostMapping("/create")
        public ResponseEntity<String> createUser(@RequestBody User usr){
            userrepo.save(usr);
            return ResponseEntity.ok("User create Success !");
        }

        @GetMapping("/{id}")
        public ResponseEntity<User> getUserById(@PathVariable Long id){
            User user = userrepo.findById(id).orElse(null);

            if(user == null){
                ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(user);
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User usr){
            User user = userrepo.findById(id).orElse(null);

            if(user == null){
                return ResponseEntity.notFound().build();
            }

            user.setFname(usr.getFname());
            user.setLname(usr.getLname());
            user.setEmail(usr.getEmail());
            user.setPassword(usr.getPassword());
            userrepo.save(user);

            return ResponseEntity.ok("User updated Successfully !");

        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<String> deleteUser(@PathVariable Long id){


            userrepo.deleteById(id);

            return ResponseEntity.ok("User Delete Success fully !");
        }





}
