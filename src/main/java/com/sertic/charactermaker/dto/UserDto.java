package com.sertic.charactermaker.dto;

import javax.validation.constraints.NotNull;

public class UserDto {

    @NotNull
    private String usernameDto;

    @NotNull
    private String passwordDto;

    public String getUsernameDto() {
        return usernameDto;
    }

    public void setUsernameDto(String usernameDto) {
        this.usernameDto = usernameDto;
    }

    public String getPasswordDto() {
        return passwordDto;
    }

    public void setPasswordDto(String passwordDto) {
        this.passwordDto = passwordDto;
    }
}
