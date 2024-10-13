package br.com.memberkit.wakandaacademy.gerenciafuncionario.usuario.domain;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.autenticacao.application.api.UsersRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "Users")
public class Users implements UserDetails {
    @Id
    private UUID IDuser;
    @Email
    @Indexed(unique = true)
    private String login;
    @Size(min = 6)
    private String senha;
    private UserRoles role;

    public Users(UsersRequest usersRequest) {
        this.IDuser = UUID.randomUUID();
        this.login = usersRequest.getLogin();
        this.senha = usersRequest.getSenha();
        this.role = usersRequest.getRole();
    }

    public Users(String login, String encriptsenha, UserRoles role) {
        this.IDuser = UUID.randomUUID();
        this.login = login;
        this.senha = encriptsenha;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRoles.ADMIN)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return getSenha();
    }

    @Override
    public String getUsername() {
        return getLogin();
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
