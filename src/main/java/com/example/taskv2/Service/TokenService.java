package com.example.taskv2.Service;

public class TokenService {

    public static Boolean isTokenCorrect(String token, String  attempt){
        if(token.equals(attempt)){
            return true;
        }
        return false;
    }
}
