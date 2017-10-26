package lych.helloworld.controller;

import lombok.RequiredArgsConstructor;
import lych.helloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ResponseEntity listStudents() {

        return ResponseEntity.ok().body(userService.listUsers());
    }
}
