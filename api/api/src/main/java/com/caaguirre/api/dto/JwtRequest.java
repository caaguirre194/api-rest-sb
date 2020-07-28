package com.caaguirre.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class JwtRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
}
