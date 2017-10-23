package lych.helloworld.security.service;

import lombok.RequiredArgsConstructor;
import lych.helloworld.model.User;
import lych.helloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final User user=userService.getUserByUsername(username);

        if(user!=null)
        {
            return user;
        }
        else throw new UsernameNotFoundException("User not found");
    }
}
