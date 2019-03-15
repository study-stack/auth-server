package com.baimurzin.service.auth.authserver.config;

import com.baimurzin.service.auth.authserver.model.User;
import com.baimurzin.service.auth.authserver.security.CustomUserPrincipal;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        User user = ((CustomUserPrincipal) authentication.getPrincipal()).getUser();
        final Map<String, Object> additionalInfo = new HashMap<>();

        additionalInfo.put("user_id", user.getId());

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);

        return accessToken;
    }
}
