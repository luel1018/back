package org.example.back.user;

import lombok.RequiredArgsConstructor;
import org.example.back.user.model.UserDto;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor    // TODO: Lombok 기능, final이 붙은 변수만 매개변수로 받는 생성자
public class UserController {
    private final UserService userService;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }


    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody UserDto.SignupReq dto) {
        userService.signup(dto);

        return ResponseEntity.ok("성공");
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDto.LoginReq dto) {
        try {
            UserDto.LoginRes result = userService.login(dto);
            return ResponseEntity.ok(result);
        } catch (EmptyResultDataAccessException emptyException) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("실패");
        }
    }

}
