package com.seresco.milena.business.service.application.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class AbstractController {

//    protected final User getUserDetails() {
//
//        Authentication authentication = SecurityContextHolder.getContext()
//                .getAuthentication();
//
//		/*if (authentication.getPrincipal() instanceof UserDetails) {
//			return (User) authentication.getPrincipal();
//		}*/
//        User user = UsersMapper.INSTANCE.toDomain(usersRepository.findByUserName(authentication.getPrincipal().toString()).get());
//        //user.addExtraInfo("authorities", authentication.getAuthorities());
//
//        return user;
//    }

}
