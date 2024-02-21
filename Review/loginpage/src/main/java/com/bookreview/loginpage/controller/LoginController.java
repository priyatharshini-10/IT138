package com.bookreview.loginpage.controller;

import org.springframework.web.bind.annotation.RestController;

import com.bookreview.loginpage.model.Login;
import com.bookreview.loginpage.service.LoginService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class LoginController {
   
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    private LoginService loginService;
    
    @PostMapping("/login")
    public ResponseEntity<Login>postLoginDetails(@RequestBody Login LoginDetails)
    {
         Login postLoginDetails=loginService.postLoginDetails(LoginDetails);
         return new ResponseEntity<>(postLoginDetails,HttpStatus.CREATED);
    }
   
    //   @GetMapping("/reviews")
    //   public ResponseEntity<List<LoginController>>getAllReviews(){
    //     List<LoginController>LoginDetails=LoginService.getAllReviews();
    //     return new ResponseEntity<>(LoginDetails,HttpStatus.OK);
    // } 
      @GetMapping("/Login/{loginId}")
       public ResponseEntity<Login>getById(@PathVariable("loginId") int loginId){
        Login LoginDetail1=loginService.getLoginDetailsById(loginId);
        if(LoginDetail1!=null){
            return new ResponseEntity<>(LoginDetail1,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(LoginDetail1,HttpStatus.NOT_FOUND);
        }
    } 
    @PutMapping("/form/{loginId}")
    public ResponseEntity<Login> putReview(@PathVariable("loginId") int loginId,Login login)
    {
         Login loginDetail2=loginService.putLoginDetails(loginId, login);
         if(loginDetail2!=null){
             return new ResponseEntity<>(loginDetail2,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(loginDetail2,HttpStatus.NOT_FOUND);
         }
    }
     @DeleteMapping("/from/{loginId}")
     public void deletebook_id(@PathVariable("loginId") int loginId)
     {
        loginService.deletebook_id(loginId);
     }
    }
