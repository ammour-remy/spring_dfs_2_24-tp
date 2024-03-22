package tp.rammour.demo.controllers;

import tp.rammour.demo.dao.UserDao;
import tp.rammour.demo.models.User;
import tp.rammour.demo.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    AuthenticationProvider authenticationProvider;

    @Autowired
    UserDao userDao;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/sign-in")
    public void signIn(@RequestBody User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userDao.save(user);

    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        try {

            UserDetails userDetails = (UserDetails) authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getPseudo(),
                    user.getPassword()
            )).getPrincipal();

            return jwtUtils.generateJwt(userDetails);

        } catch (Exception ex) {
            return null;
        }

    }

}
