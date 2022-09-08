package peaksoft.springboot_lms_project.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.springboot_lms_project.entities.UserAccount;
import peaksoft.springboot_lms_project.repository.UserAccountRepository;

@Controller
@RequestMapping("/register")
public class SecurityController {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserAccountRepository accountRepository;

    public SecurityController(BCryptPasswordEncoder bCryptPasswordEncoder, UserAccountRepository accountRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.accountRepository = accountRepository;
    }

    @GetMapping
    public String register(Model model){
        UserAccount userAccount = new UserAccount();
        model.addAttribute("userAccountAtr", userAccount);
        return "register";
    }

    @PostMapping("/save")
    public String saveUserAccount(Model model,  UserAccount userAccount){
        userAccount.setPassword(bCryptPasswordEncoder.encode(userAccount.getPassword()));
        accountRepository.save(userAccount);
        return "redirect:/";
    }
}
