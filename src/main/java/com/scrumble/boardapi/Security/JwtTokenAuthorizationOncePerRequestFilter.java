package com.scrumble.boardapi.Security;

import com.scrumble.boardapi.Connections.ApiClient;
import com.scrumble.boardapi.Models.User;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class JwtTokenAuthorizationOncePerRequestFilter extends OncePerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Value("${jwt.http.request.header}")
    private String tokenHeader;

    @Value("${jwt.inProduction}")
    private boolean inProduction;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        if (!inProduction) {

            SecurityContextHolder.getContext().setAuthentication(new Authentication() {
                boolean logedin = false;

                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    return null;
                }

                @Override
                public Object getCredentials() {
                    return null;
                }

                @Override
                public Object getDetails() {
                    User user = new User(0, "Developer");
                    return user;
                }

                @Override
                public Object getPrincipal() {
                    return null;
                }

                @Override
                public boolean isAuthenticated() {
                    return logedin;
                }

                @Override
                public void setAuthenticated(boolean b) throws IllegalArgumentException {
                    logedin = true;
                }

                @Override
                public String getName() {
                    return null;
                }
            });
            SecurityContextHolder.getContext().getAuthentication().setAuthenticated(true);
            chain.doFilter(request, response);
            return;
        }

        final String requestTokenHeader = request.getHeader(this.tokenHeader);
        JwtTokenUtil tokenUtil = new JwtTokenUtil();
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            String jwtToken = requestTokenHeader.substring(7);
            if (ApiClient.validateToken(jwtToken)) {
                SecurityContextHolder.getContext().setAuthentication(new Authentication() {
                    boolean logedin = false;
                    String username = "";

                    @Override
                    public Collection<? extends GrantedAuthority> getAuthorities() {
                        return null;
                    }

                    @Override
                    public Object getCredentials() {
                        return null;
                    }

                    @Override
                    public Object getDetails() {

                        User user = new User(Integer.parseInt(tokenUtil.getClaimFromToken(jwtToken, Claims::getId)),username); //todo id Rob Bram
                        return user;
                    }

                    @Override
                    public Object getPrincipal() {
                        return null;
                    }

                    @Override
                    public boolean isAuthenticated() {
                        return logedin;
                    }

                    @Override
                    public void setAuthenticated(boolean b) throws IllegalArgumentException {
                        logedin = true;
                        username = ApiClient.getUsernameFromToken(jwtToken);
                    }

                    @Override
                    public String getName() {
                        return username;
                    }

                });
                SecurityContextHolder.getContext().getAuthentication().setAuthenticated(true);
                int id = ((User)SecurityContextHolder.getContext().getAuthentication().getDetails()).getId();
                tokenUtil.getUsernameFromToken(": ");
            } else {
                logger.error("Token is invalid");
            }
        } else {
            logger.warn("JWT_TOKEN_DOES_NOT_START_WITH_BEARER_STRING");
        }
        chain.doFilter(request, response);
    }
}
