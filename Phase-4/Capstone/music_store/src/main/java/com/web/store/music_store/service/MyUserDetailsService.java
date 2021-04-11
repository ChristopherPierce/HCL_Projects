package com.web.store.music_store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.web.store.music_store.model.Role;
import com.web.store.music_store.model.User;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.web.store.music_store.repository.RoleRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(userName);
        if (user == null) {
        	throw new UsernameNotFoundException("User not found...");
        }
        System.out.println(user);
        //List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
        Role userRole = roleRepository.findByRole("USER");//changed this from admin to user
        List<GrantedAuthority> authorities = getUserAuthority(new HashSet<Role>(Arrays.asList(userRole)));
        return buildUserForAuthentication(user, authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        //for (Role role : userRoles) {
        //    roles.add(new SimpleGrantedAuthority(role.getRole()));
        //}
        roles.add(new SimpleGrantedAuthority("USER"));
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
               /* user.getActive()*/ true, true, true, true, authorities);
    }
}
