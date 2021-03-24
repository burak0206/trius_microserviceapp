package com.trius.contract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private String id;
    private String username;
    private String email;
    public String getNameSurname() {
       return this.username + " " + this.email;
    }
}