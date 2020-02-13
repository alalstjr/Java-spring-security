package com.example.project.service;

import com.example.project.context.AccountContext;
import com.example.project.domain.Account;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SampleService {

    // 현재 로그인한 사용자 정보를 참조할 때
    public void dashboard() {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        // 인증이 완료된 사용자의 정보
        Object principal = authentication.getPrincipal();

        // 사용자가 가지고 있는 권한을 나타냅니다. 권한은 ADMIN, USER ... 등등 여러개일수도 있으니 Collection
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // 인증이 완료된 사용자인지 판별합니다.
        boolean authenticated = authentication.isAuthenticated();

        // ThreadLocal을 사용하여 메소드 파라미터를 받지 않아도 유저의 정보를 가져와서 사용하였습니다.
        Account account = AccountContext.getAccount();
        System.out.println(account.getUsername());
    }
}