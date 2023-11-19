package com.mail.icaro.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ApiKeyAuthenticationFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, IOException {
        String apiKey = request.getHeader("X-API-Key");
        if (apiKey != null && isValidApiKey(apiKey)) {

            ApiKeyAuthentication apiKeyAuthentication = new ApiKeyAuthentication();
            apiKeyAuthentication.setApiKey(apiKey);

            Authentication authentication = apiKeyAuthentication;
            authentication.setAuthenticated(true);

            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        filterChain.doFilter(request, response);
    }

    private boolean isValidApiKey(String apiKey) {

        return apiKey.equals("teste");
    }
}
