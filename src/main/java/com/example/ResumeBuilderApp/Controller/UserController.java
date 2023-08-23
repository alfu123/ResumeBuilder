package com.example.ResumeBuilderApp.Controller;

import com.example.ResumeBuilderApp.Config.jwtUtils;
import com.example.ResumeBuilderApp.Entity.User;
import com.example.ResumeBuilderApp.Entity.jwtRequest;
import com.example.ResumeBuilderApp.Entity.jwtResponse;
import com.example.ResumeBuilderApp.Service.UserService;
import com.example.ResumeBuilderApp.Util.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailsService customUserDetailService;
    @Autowired
    private jwtUtils jwtUtil;
    @Autowired
    UserService userService;

    public UserController() {
    }

    @PostMapping(value="/register")
    public ResponseEntity createUser(@RequestBody User user){
        User buildUser = userService.saveUser(user);

        if (buildUser == null) {

            return ResponseEntity.status(401).build();
        } else {
            return ResponseEntity.status(200).build();
        }

    }

    @PostMapping(value="/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody jwtRequest jwtRequest) throws Exception
    {
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(), jwtRequest.getPassword()));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new Exception("Bad Credetials");

        }
        UserDetails userDetails = this.customUserDetailService.loadUserByUsername(jwtRequest.getUserName());
        String token=this.jwtUtil.generateToken(userDetails);
        return  ResponseEntity.ok(new jwtResponse(token));
    }
    public void authenticate(String username, String password) throws Exception
    {
        try
        {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
        catch(Exception e)
        {
            throw new Exception("User Not Found");

        }

    }
}
