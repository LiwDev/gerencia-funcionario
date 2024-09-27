package br.com.memberkit.wakandaacademy.gerenciafuncionario.credencial.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "Credencial")
@Getter
public class Credencial implements UserDetails {
    @MongoId(targetType = FieldType.STRING)
    private String user;
    @NotNull
    @Size(max = 60)
    private String password;

    private boolean valited;

    public Credencial(String user,@NotNull String password) {
        this.user = user;
        var encript = new BCryptPasswordEncoder();
        this.password = encript.encode(password);
        this.valited = true;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.getPassword();
    }

    @Override
    public String getUsername() {
        return this.getUser();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
