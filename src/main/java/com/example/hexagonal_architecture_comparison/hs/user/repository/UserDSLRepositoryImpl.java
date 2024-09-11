package com.example.hexagonal_architecture_comparison.hs.user.repository;

import com.example.hexagonal_architecture_comparison.hs.user.dto.UserSaveDto;
import com.example.hexagonal_architecture_comparison.hs.user.dto.UserSearchDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.example.hexagonal_architecture_comparison.hs.user.entity.QUser.user;

@RequiredArgsConstructor
public class UserDSLRepositoryImpl implements UserDSLRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<UserSaveDto> selectUserList(UserSearchDto userSearchDto, Pageable pageable) {
        List<UserSaveDto> list = queryFactory
                .select(Projections.fields(UserSaveDto.class,
                        user.id,
                        user.name,
                        user.age))
                .from(user)
                .where(likeUserName(userSearchDto.getName()),
                        eqUserAge(userSearchDto.getAge()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long count = queryFactory
                .select(user.count())
                .from(user)
                .where(likeUserName(userSearchDto.getName()),
                        eqUserAge(userSearchDto.getAge()))
                .fetchOne();

        return new PageImpl<>(list, pageable, count);
    }

    private BooleanExpression likeUserName(String name) {
        return StringUtils.hasText(name) ? user.name.containsIgnoreCase(name) : null;
    }

    private BooleanExpression eqUserAge(Integer age) {
        return age != null ? user.age.eq(age) : null;
    }
}
