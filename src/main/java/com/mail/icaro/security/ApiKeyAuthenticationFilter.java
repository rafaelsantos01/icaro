package com.mail.icaro.security;

import com.mail.icaro.config.errors.implementatins.ErrorAuth;
import com.mail.icaro.modules.key.entity.KeyAccess;
import com.mail.icaro.modules.key.entity.KeyAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private KeyAccessRepository keyAccessRepository;

    @Autowired
    private ErrorAuth errorAuth;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, IOException {
        try{
            String apiKey = request.getHeader("X-API-Key");
            if (apiKey != null) {
                KeyAccess keyAccess = keyAccessRepository.findByKeyAndStatusTrue(apiKey);
                if(keyAccess == null){
                    throw new Error("errorKey");
                }

                ApiKeyAuthentication apiKeyAuthentication = new ApiKeyAuthentication();
                apiKeyAuthentication.setApiKey(apiKey);

                Authentication authentication = apiKeyAuthentication;
                authentication.setAuthenticated(true);

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }catch (Error e){
            errorAuth.ErrorKey(response);
            return;
        }catch (Exception e){
            errorAuth.ErrorAuth(response);
            return;
        }

        filterChain.doFilter(request, response);
    }


}
