//package com.example.helloworld.helloworld.controller;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//
//import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
//import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import java.security.Principal;
//import java.util.Collection;
//import java.util.Map;
//
//@RestController
//public class LoginController {
//    @GetMapping("/")
//    public String home() {
//        return "Login Is here";
//    }
//
//    @GetMapping("/userInfo")
//    public Map<String, Object> getUser(@AuthenticationPrincipal OAuth2User oAuth2User) {
//        return oAuth2User.getAttributes();
//    }
//
//    @GetMapping("/usertoken")
//    public Principal getUser(Principal principal) {
//        String tokenValue;
//        OAuth2AuthenticationToken authenticationToken = (OAuth2AuthenticationToken) principal;
//        Collection<GrantedAuthority> authorities = authenticationToken.getAuthorities();
//        if (!authorities.isEmpty()) {
//            OidcUserAuthority oidcUserAuthority = (OidcUserAuthority) authorities.iterator().next();
//            tokenValue = oidcUserAuthority.getIdToken().getTokenValue();
//            String accessTokenHash = oidcUserAuthority.getIdToken().getAccessTokenHash();
//            System.out.println("\n\nToken Value: "+tokenValue);
//            System.out.println("\n\nAccess Token: "+accessTokenHash);
//        }
//        return principal;
//
//}
//
//}
