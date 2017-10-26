package lych.helloworld.security.service;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lych.helloworld.model.User;
import lych.helloworld.security.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultTokenService implements TokenService {

    private final UserDetailsService userDetailsService;

    @Override
    public String getToken(String username, String password) throws Exception {

        if (username == null || password == null) {

            return null;
        }

        final User user = (User) userDetailsService.loadUserByUsername(username);

        Map<String, Object> token = new HashMap<>();

        if (password.equals(user.getPassword())) {

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MINUTE, SecurityConstants.tokenExpirationTime);
            token.put("authorityType", String.valueOf(user.getAuthorities()));
            token.put("userId", user.getId());
            token.put("username", user.getUsername());
            token.put("validateTime",calendar.getTime());


            JwtBuilder jwtBuilder = Jwts.builder();
            jwtBuilder.setExpiration(calendar.getTime());
            jwtBuilder.setClaims(token);

            return jwtBuilder.signWith(SignatureAlgorithm.HS512, SecurityConstants.secretKey).compact();
        } else throw new RuntimeException("Auth error");
    }
}
