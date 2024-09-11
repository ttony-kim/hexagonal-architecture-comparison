package com.example.hexagonal_architecture_comparison.hs.user;

import com.example.hexagonal_architecture_comparison.hs.user.dto.UserSaveDto;
import com.example.hexagonal_architecture_comparison.hs.user.dto.UserSearchDto;
import com.example.hexagonal_architecture_comparison.hs.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<Page<UserSaveDto>> selectUserList(UserSearchDto userSearchDto, Pageable pageable) {
        Page<UserSaveDto> resultData = userService.selectUserList(userSearchDto, pageable);

        return ResponseEntity.ok(resultData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserSaveDto> selectUser(@PathVariable Long id) {
        UserSaveDto resultData = userService.selectUser(id);

        return ResponseEntity.ok(resultData);
    }

    @PostMapping
    public ResponseEntity<Integer> insertUser(@RequestBody UserSaveDto userSaveDto) {
        userService.insertUser(userSaveDto);

        return ResponseEntity.ok(1);
    }

    @PutMapping
    public ResponseEntity<Integer> updateUser(@RequestBody UserSaveDto userSaveDto) {
        userService.updateUser(userSaveDto);

        return ResponseEntity.ok(1);
    }

    @DeleteMapping
    public ResponseEntity<Integer> deleteUser(@RequestBody List<Long> deleteList) {
        userService.deleteUser(deleteList);

        return ResponseEntity.ok(deleteList.size());
    }

}
