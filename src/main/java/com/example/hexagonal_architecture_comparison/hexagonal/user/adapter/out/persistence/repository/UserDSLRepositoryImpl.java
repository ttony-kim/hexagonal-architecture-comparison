package com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.out.persistence.repository;

import com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.out.persistence.entity.UserEntity;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.out.criteria.UserSearchCriteria;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.out.persistence.entity.QUserEntity.userEntity;

@RequiredArgsConstructor
public class UserDSLRepositoryImpl implements UserDSLRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<UserEntity> findBySearchCriteria(UserSearchCriteria userSearchCriteria) {
        List<UserEntity> list = queryFactory.selectFrom(userEntity)
                .where(likeUserName(userSearchCriteria.getName()),
                        eqUserAge(userSearchCriteria.getAge()))
                .offset(userSearchCriteria.getPageable().getOffset())
                .limit(userSearchCriteria.getPageable().getPageSize())
                .fetch();

        Long count = queryFactory
                .select(userEntity.count())
                .from(userEntity)
                .where(likeUserName(userSearchCriteria.getName()),
                        eqUserAge(userSearchCriteria.getAge()))
                .fetchOne();

        return new PageImpl<>(list, userSearchCriteria.getPageable(), count);
    }

    private BooleanExpression likeUserName(String name) {
        return StringUtils.hasText(name) ? userEntity.name.containsIgnoreCase(name) : null;
    }

    private BooleanExpression eqUserAge(Integer age) {
        return age != null ? userEntity.age.eq(age) : null;
    }
}
