package com.example.elearningdemoservice.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.elearningdemoservice.model.Permission;
import com.example.elearningdemoservice.model.Role;
import com.example.elearningdemoservice.model.User;
import com.example.elearningdemoservice.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository nguoiDungRepository;

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        User user = nguoiDungRepository.findByUsername(userName);

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), true, true, true,
                true, getAuthorities(user.getRoles()));
    }

    public Collection<? extends GrantedAuthority> getAuthorities(
            Collection<Role> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<String> getPrivileges(Collection<Role> roles) {
        List<String> privileges = new ArrayList<>();
        List<Permission> collection = new ArrayList<>();
        roles.forEach(role -> {
            privileges.add(role.getName());
            collection.addAll(role.getPermissions());
        });

        privileges.addAll(collection.stream().map(privilege -> privilege.getName()).collect((Collectors.toList())));
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        return privileges.stream().map(privilege -> new SimpleGrantedAuthority(privilege)).collect(Collectors.toList());
    }
}