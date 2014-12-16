package drugExpertSystem.controller;

import drugExpertSystem.User.Services.UserService;
import drugExpertSystem.User.Token;
import drugExpertSystem.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Panupak on 12/12/2014.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Qualifier("authenticationManager")
    private AuthenticationManager authManager;

    @RequestMapping(value = "/register-as-member",method = RequestMethod.POST)
    public void register (@RequestBody User user){
        userService.createUser(user);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Token login(@RequestBody User user){
        String email = user.getEmail();
        String password = user.getPassword();
        System.out.println(userService.autherization(email,password).getUser());
        return userService.autherization(email,password);
    }

    @RequestMapping(value = "/update-password",method = RequestMethod.PUT)
    public User updateUserPass(@RequestBody User user){
            return userService.updateUserPass(user);
    }
}
