package br.com.memberkit.wakandaacademy.gerenciafuncionario.credencial.domain;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.security.core.GrantedAuthority;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "Perfil")
public class Perfil implements GrantedAuthority{
@MongoId(targetType = FieldType.STRING)
@Getter
private String nome;

    @Override
    public String getAuthority() {
        return this.getNome();
    }
    private static final long SERIALVERSIONUID = 1L;
}
