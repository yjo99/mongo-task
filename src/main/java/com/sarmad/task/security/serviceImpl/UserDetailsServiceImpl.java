package com.sarmad.task.security.serviceImpl;

import com.sarmad.task.persistence.entity.User;
import com.sarmad.task.persistence.repository.UserRepository;
import com.sarmad.task.security.common.UserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;
import java.util.Optional;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private MessageSource messageSource;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) {
        Locale locale = LocaleContextHolder.getLocale();
        Optional<User> user = userRepository.findUserByLoginID(email);
        if (user.isEmpty()) {
            log.error("Thread [" + Thread.currentThread().getId() + "] | User[" + email + "] is Not exist");
            String userMessage = messageSource.getMessage("error.not_exist_user.userMessage", null, locale);
            throw new InternalAuthenticationServiceException(userMessage);
        }
        return UserPrincipal.build(user.get());
    }
}
