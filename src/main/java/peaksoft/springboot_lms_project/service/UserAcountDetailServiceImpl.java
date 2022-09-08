package peaksoft.springboot_lms_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import peaksoft.springboot_lms_project.entities.SecurityUser;
import peaksoft.springboot_lms_project.entities.UserAccount;
import peaksoft.springboot_lms_project.repository.UserAccountRepository;


public class UserAcountDetailServiceImpl implements UserDetailsService {


    @Autowired
    private UserAccountRepository userAccountRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserAccount userAccount = userAccountRepository.getUserByUserName(username);

        if (userAccount == null){
            throw new UsernameNotFoundException("could not find user");
        }

        return new SecurityUser(userAccount);
    }
}
