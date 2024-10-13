package br.com.memberkit.wakandaacademy.gerenciafuncionario.usuario.domain;

public enum UserRoles {
    USER("user"),ADMIN("admin");

private String role;
    UserRoles(String role) {
        this.role=role;
    }
    private String getRole(){
        return this.role;
    }
}
