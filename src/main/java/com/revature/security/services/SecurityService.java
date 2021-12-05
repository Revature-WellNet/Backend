package com.revature.security.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.revature.security.models.AuthUserDTO;
import com.revature.security.models.Credentials;
import com.revature.security.models.SecurityProperties;
import com.revature.utils.CookieUtils;

@Service
public class SecurityService {

	@Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    CookieUtils cookieUtils;

    @Autowired
    SecurityProperties securityProps;

    /**
     * Not currently being used in app
     */
    public AuthUserDTO getUser() {
    	AuthUserDTO userPrincipal = null;
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication auth = securityContext.getAuthentication();

        if(auth==null){
            return userPrincipal;
        }
        Object principal = auth.getPrincipal();
        if (principal instanceof AuthUserDTO) {
            userPrincipal = ((AuthUserDTO) principal);
        }
        return userPrincipal;
    }

    /**
     * Not currently being used in app
     */
    public Credentials getCredentials() {
        SecurityContext securityContext = SecurityContextHolder.getContext();

        Authentication auth = securityContext.getAuthentication();

        if(auth==null){
            return null;
        }
        return (Credentials) securityContext.getAuthentication().getCredentials();
    }

    /**
     * Not currently being used in app
     */
    // public boolean isPublic() {
    //     return securityProps.getAllowedPublicApis().contains(httpServletRequest.getRequestURI());
    // }

    public String getBearerToken(HttpServletRequest request) {
        String bearerToken = null;
        String authorizationValue = request.getHeader("Authorization");
        if (StringUtils.hasText(authorizationValue) && authorizationValue.startsWith("Bearer ")) {
            bearerToken = authorizationValue.substring(7); // JWT
        }
        return bearerToken;
    }
}
