package com.example.SessionStore;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequiredArgsConstructor
public class LoginController {

    Map<String, String> sesstionMap = new ConcurrentHashMap<>();

    @GetMapping("/login")
    public String login(HttpSession session, @RequestParam String name) {
        sesstionMap.put(session.getId(), name);

        return "saved session";
    }

    @GetMapping("/myName")
    public String myName(HttpSession session) {
        String myName = sesstionMap.get(session.getId());

        return myName;
    }
}
