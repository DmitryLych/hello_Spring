package lych.helloworld.security;

import lombok.Getter;

@Getter
public final class SecurityConstants {

    public static final String authHeaderName="Token";

    public static final String secretKey="dc6589483a672de25ff765172494d42e138cd8a5";

    public static final int tokenExpirationTime = 40;
}
