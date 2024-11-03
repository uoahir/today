package com.uoahir.wear.today.dto.user;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private long id;
    private String name;
    private String email;
    private String picture;
    private Role role;

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey(){
        return this.role.toString();
        // @Data 어노테이션을 활용한 getRole() - Role 객체를 반환
        // getRoleKey() - 문자열로 반환
    }
}
