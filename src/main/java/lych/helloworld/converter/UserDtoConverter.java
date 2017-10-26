package lych.helloworld.converter;

import lych.helloworld.dto.UserDto;
import lych.helloworld.model.Authority;
import lych.helloworld.model.AuthorityType;
import lych.helloworld.model.User;
import org.springframework.core.convert.converter.Converter;

import java.util.Collections;

public class UserDtoConverter implements Converter<UserDto, User> {

    @Override
    public User convert(final UserDto source) {

        final User user = new User();

        user.setUsername(source.getUsername());
        user.setPassword(source.getPassword());
        user.setAccountNonExpired(false);
        user.setAccountNonLocked(false);
        user.setCredentialsNonExpired(false);
        user.setEnabled(true);

        final Authority authority = new Authority();
        authority.setRole(String.valueOf(AuthorityType.USER));

        user.setAuthorities(Collections.singletonList(authority));

        return user;
    }
}
