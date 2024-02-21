package com.bookreview.loginpage.service;

import org.springframework.stereotype.Service;
import com.bookreview.loginpage.model.Login;
import com.bookreview.loginpage.repository.LoginRepo;

@Service
public class LoginService {
  
    private LoginRepo loginrepo;
     
    public LoginService(LoginRepo loginrepo) {
        this.loginrepo = loginrepo;
    }
    public Login postLoginDetails(Login login){
        return loginrepo.save(login);
    }
    public Login getLoginDetailsById(int loginId){
        return loginrepo.findById(loginId).orElse(new Login());
    }
public Login putLoginDetails(int loginId ,Login login)
{
    return loginrepo.save(login);
}
public void deletebook_id(int loginId)
{
    loginrepo.deleteById(loginId);
}
}

