
package com.demo.realfake.demo_real_fake;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private String currentUsername = null;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@RequestParam String username, @RequestParam String password, Model model) {
        currentUsername = username;
        model.addAttribute("username", username);
        return "redirect:/";
    }

    @GetMapping("/")
    public String index(Model model) {
        if (currentUsername != null) {
            model.addAttribute("username", currentUsername);
        }
        return "index";
    }
}
