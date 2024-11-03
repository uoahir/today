package com.uoahir.wear.today.config.oauth.dto;

import com.uoahir.wear.today.dto.user.Role;
import com.uoahir.wear.today.dto.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String,Object> attributes) {
        return ofGoogle(userNameAttributeName, attributes);
    }

    public static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String)attributes.get("name"))
                .email((String)attributes.get("email"))
                .picture((String)attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public User toUser() {
        // 사용자가 가입할 때, 새로운 사용자 객체를 생성하는 용도임 ! ! !
        // JPA를 사용하지 않을 거기 때문에 이렇게 객체를 만들어도 db에서는 저장이 안되고 local 에서만 저장되니까,
        // controller랑 service 로직을 만들어서 db에 저장시킬까 ?!
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)
                .build();
    }

}
