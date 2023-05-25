package com.mlevensohn.base.mappers;

import com.mlevensohn.base.models.RoleDto;
import com.mlevensohn.base.models.UserDto;
import com.mlevensohn.base.entities.Role;
import com.mlevensohn.base.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "userId"),
            @Mapping(source = "roles", target = "roles", qualifiedByName = "roleSetToRoleDtoSet")
    })
    UserDto entityToDto(User entity);

    @Mappings({
            @Mapping(source = "userId", target = "id"),
            @Mapping(ignore = true, target = "password"),
            @Mapping(source = "roles", target = "roles", qualifiedByName = "roleDtoSetToRoleSet")
    })
    User dtoToEntity(UserDto dto);

    @Named("roleSetToRoleDtoSet")
    static Set<RoleDto> roleSetToRoleDtoSet(Set<Role> roles) {
        return roles.stream()
                .map(role -> new RoleDto(role.getName()))
                .collect(Collectors.toSet());
    }

    @Named("roleDtoSetToRoleSet")
    static Set<Role> roleDtoSetToRoleSet(Set<RoleDto> roles) {
        return roles.stream()
                .map(role -> Role.builder().name(role.getRoleName()).build())
                .collect(Collectors.toSet());
    }


//    @Named("roleSetToRoleDtoSet")
//    static Set<RoleEnum> roleSetToRoleDtoSet(Set<Role> roles) {
//        return roles.stream()
//                .map(role -> role.getName())
//                .collect(Collectors.toSet());
//    }

//    @Named("roleDtoSetToRoleSet")
//    static Set<Role> roleDtoSetToRoleSet(Set<RoleEnum> roles) {
//        return roles.stream()
//                .map(role -> Role.builder().name(role).build())
//                .collect(Collectors.toSet());
//    }

}
