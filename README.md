## Hexagonal Architecture 적용
### 📍구조
#### Layer
```
└───user
    │   UserController.java
    │
    ├───dto
    │       UserSaveDto.java
    │       UserSearchDto.java
    │
    ├───entity
    │       User.java
    │
    ├───repository
    │       UserDSLRepository.java
    │       UserDSLRepositoryImpl.java
    │       UserRepository.java
    │
    └───service
            UserService.java
```
#### Hexagonal
```
└───user
    ├───adapter
    │   ├───in
    │   │   └───web
    │   │       │   UserController.java
    │   │       │   UserResponseMapper.java
    │   │       │
    │   │       ├───request
    │   │       │       UserCreateRequest.java
    │   │       │       UserSearchRequest.java
    │   │       │       UserUpdateRequest.java
    │   │       │
    │   │       └───response
    │   │               UserResponse.java
    │   │
    │   └───out
    │       └───persistence
    │           │   UserPersistenceAdapter.java
    │           │   UserPersistenceMapper.java
    │           │
    │           ├───entity
    │           │       UserEntity.java
    │           │
    │           └───repository
    │                   UserDSLRepository.java
    │                   UserDSLRepositoryImpl.java
    │                   UserRepository.java
    │
    ├───application
    │   ├───port
    │   │   ├───in
    │   │   │   │   UserCreateUseCase.java
    │   │   │   │   UserDeleteUseCase.java
    │   │   │   │   UserReadUseCase.java
    │   │   │   │   UserUpdateUseCase.java
    │   │   │   │
    │   │   │   ├───command
    │   │   │   │       CreateUserCommand.java
    │   │   │   │       UpdateUserCommand.java
    │   │   │   │
    │   │   │   └───query
    │   │   │           GetAllUsersQuery.java
    │   │   │
    │   │   └───out
    │   │       │   UserCreatePort.java
    │   │       │   UserDeletePort.java
    │   │       │   UserReadPort.java
    │   │       │   UserUpdatePort.java
    │   │       │
    │   │       └───parameters
    │   │               UserLoadParameters.java
    │   │
    │   └───service
    │           UserService.java
    │
    └───domain
            User.java
            UserStatus.java
```
### 📍특징
#### 프로젝트 구조
- adapter, application, domain 으로 나눔
#### 각 계층의 DTO
- `adapter.in`  request, response
- `application.port.in` command, query
- `application.port.out` parameters
#### 변환
- Mapper 사용: UserResponseMapper.java, UserPersistenceMapper.java
- 정적 팩토리 메서드 사용
