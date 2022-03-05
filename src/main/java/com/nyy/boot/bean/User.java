package com.nyy.boot.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author WxrStart
 * @create 2022-03-04 21:36
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

        private Integer userId;

        private String username;

        private String password;
}
