package com.example.hexagonal_architecture_comparison.hs.user.service;

import com.example.hexagonal_architecture_comparison.hs.user.dto.UserSaveDto;
import com.example.hexagonal_architecture_comparison.hs.user.dto.UserSearchDto;
import com.example.hexagonal_architecture_comparison.hs.user.entity.User;
import com.example.hexagonal_architecture_comparison.hs.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Page<UserSaveDto> selectUserList(UserSearchDto userSearchDto, Pageable pageable) {
        return userRepository.selectUserList(userSearchDto, pageable);
    }

    public UserSaveDto selectUser(Long id) {
        User user = userRepository.findById(id).orElseThrow();

        return UserSaveDto.toDto(user);
    }

    @Transactional
    public void insertUser(UserSaveDto userSaveDto) {
        User user = userSaveDto.toEntity();
        user.insert();
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(UserSaveDto userSaveDto) {
        User user = userRepository.findById(userSaveDto.getId()).orElseThrow();
        user.update(userSaveDto.getName(),
                userSaveDto.getAge());
    }

    @Transactional
    public void deleteUser(List<Long> deleteList) {
        for (Long id : deleteList) {
            User user = userRepository.findById(id).orElseThrow();
            user.delete();
        }
    }
}
