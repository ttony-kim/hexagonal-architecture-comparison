package com.example.hexagonal_architecture_comparison.hs.user.repository;

import com.example.hexagonal_architecture_comparison.hs.user.dto.UserSaveDto;
import com.example.hexagonal_architecture_comparison.hs.user.dto.UserSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserDSLRepository {
    Page<UserSaveDto> selectUserList(UserSearchDto userSearchDto, Pageable pageable);
}
