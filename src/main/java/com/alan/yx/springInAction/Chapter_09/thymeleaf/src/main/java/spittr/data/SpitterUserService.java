package com.alan.yx.springInAction.Chapter_09.thymeleaf.src.main.java.spittr.data;

import com.alan.yx.springInAction.Chapter_09.thymeleaf.src.main.java.spittr.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yinxing
 * @date 2019/5/5
 */

@Service
public class SpitterUserService implements UserDetailsService {

    /**
     * 注入 SpitterRepository
     */
    @Autowired
    private SpitterRepository spitterRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查找 Spitter
        Spitter spitter = spitterRepository.findByUsername(username);
        if (spitter != null) {
            // 创建权限列表
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_SPITTER"));
            // 返回 User
            return new User(spitter.getUsername(), spitter.getPassword(), authorities);
        }

        throw new UsernameNotFoundException("User '" + username + " ' not found.");
    }
}
