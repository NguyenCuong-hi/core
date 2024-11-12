package com.example.core.service.Impl;

import com.example.core.constans.ErrorCodes;
import com.example.core.constans.ErrorMessage;
import com.example.core.dto.request.PersonDto;
import com.example.core.dto.request.RoleDto;
import com.example.core.dto.request.UserDto;
import com.example.core.dto.request.UserGroupDto;
import com.example.core.dto.request.search.SearchDto;
import com.example.core.entity.Person;
import com.example.core.entity.Role;
import com.example.core.entity.User;
import com.example.core.entity.UserGroup;
import com.example.core.exception.ExceptionResponse;
import com.example.core.repository.PersonRepository;
import com.example.core.repository.RoleRepository;
import com.example.core.repository.UserRepository;
import com.example.core.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepo;

    private final PersonRepository personRepos;

    @Override
    public Page<UserDto> searchUser(SearchDto searchDto) {

        List<User> users = userRepo.getAllBy();
        Pageable pageable = PageRequest.of(searchDto.getPageIndex(), searchDto.getPageSize());
        return new PageImpl(users, pageable, users.size());
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> {
                    throw new ExceptionResponse(ErrorCodes.ENTITY_NOT_FOUND, ErrorMessage.ENTITY_NOT_FOUND, id.toString());
                });
        return new UserDto(user);
    }

    @Override
    public UserDto getUserByUsername(String username) {
        User user = userRepo.getUserByUsername(username);
        if (Objects.isNull(user)) {
            throw new ExceptionResponse(ErrorCodes.ENTITY_NOT_FOUND, ErrorMessage.ENTITY_NOT_FOUND, username);
        }
        return new UserDto(user);
    }

    @Override
    public UserDto createBy(UserDto userDto) {
        User user = new User();
        this.validUserDto(userDto);
        this.setUser(userDto, user);
        userRepo.save(user);
        return new UserDto(user);
    }

    @Override
    public UserDto createBy(PersonDto personDto) {
        Person person = new Person();
        this.setPerson(personDto, person);
        personRepos.save(person);

        UserDto userDto = new UserDto();
        return this.createBy(userDto);
    }

    private void setPerson(PersonDto personDto, Person person){
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setDisplayName(personDto.getDisplayName());
        person.setEmail(personDto.getEmail());
        person.setPhone(personDto.getPhoneNumber());
        person.setBirthDate(personDto.getBirthDate());
        person.setBirthPlace(person.getBirthPlace());
    }

    private void setUserPerson(PersonDto personDto, UserDto userDto) {
        userDto.setUsername(personDto.getDisplayName());
        userDto.setPassword(personDto.getPhoneNumber());
        userDto.setEmail(personDto.getEmail());
    }

    public UserDto updateBy(Long id, UserDto userDto) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new ExceptionResponse(
                        ErrorCodes.ENTITY_NOT_FOUND,
                        ErrorMessage.ENTITY_NOT_FOUND,
                        id.toString()));
        this.validUserDto(userDto);
        this.validBeforeUpdate(user);
        this.setUser(userDto, user);
        return new UserDto(user);
    }

    private void validUserDto(UserDto userDto) {

    }

    private void validBeforeUpdate(User user) {

    }

    private void setUser(UserDto userDto, User user) {
        Set<Role> roleSet = new HashSet<>();
        Set<UserGroup> userGroups = new HashSet<>();
        this.validRoles(userDto.getRoles());
        this.setListRoles(userDto.getRoles(), roleSet);

        this.setUserGroup(userDto.getUserGroups(), userGroups);

        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setRoles(roleSet);
        user.setUserGroups(userGroups);
        user.setLastLogin(userDto.getLastLogin());
        user.setDescription(user.getDescription());
        user.setNote(user.getNote());
    }

    private void validRoles(Set<RoleDto> roles) {
        for (RoleDto role: roles){
            if (!Objects.isNull(role.getId()) && !roleRepo.existsById(role.getId())){
                throw new ExceptionResponse(ErrorCodes.ENTITY_NOT_FOUND, ErrorMessage.ENTITY_NOT_FOUND, "Role ID");
            }
        }
    }

    private void setListRoles(Set<RoleDto> dtoSet, Set<Role> entities) {
        for (RoleDto dto : dtoSet) {
            entities.add(dto.toEntity());
        }
    }

    private void setUserGroup(Set<UserGroupDto> userGroups, Set<UserGroup> entities) {
        for (UserGroupDto dto : userGroups) {
            entities.add(dto.toEntity());
        }
    }

    private void validateBeforeDelete(User user) {

    }

    public Boolean deleteBy(Long id) {
        User user = userRepo.findById(id).orElseThrow(()->
                new ExceptionResponse(ErrorCodes.ENTITY_NOT_FOUND, ErrorMessage.ENTITY_NOT_FOUND, id.toString()));
        this.validateBeforeDelete(user);
        userRepo.delete(user);
        return true;
    }

}
