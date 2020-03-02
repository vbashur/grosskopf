package com.vbashur.guardian.controller;

import com.vbashur.guardian.config.CookieUtil;
import com.vbashur.guardian.config.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Deprecated
@RestController
public class LoginController {

    private static final String jwtTokenCookieName = "JWT-TOKEN";
    private static final Map<String, String> credentials = new HashMap<>();


    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public LoginController() {
        credentials.put("user1", "user1");
        credentials.put("user2", "user2");
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @PostMapping(value = "login")
    public String login(HttpServletResponse httpServletResponse, String username, String password, String redirect, Model model) {
        if (username == null || !credentials.containsKey(username) || !credentials.get(username).equals(password)) {
            model.addAttribute("error", "Invalid username or password!");
            return "login";
        }
        UserDetails details = new User(username, password, null);

        String token = jwtTokenUtil.generateToken(details);
        CookieUtil.create(httpServletResponse, jwtTokenCookieName, token, false, -1, "localhost");
        return "redirect:" + redirect;
    }
}
