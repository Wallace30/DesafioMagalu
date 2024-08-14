package com.desafiomagalu.domain.user;

import com.desafiomagalu.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String lastname;
    private Type type;

    public User(UserDTO data) {
        this.username = data.username();
        this.lastname = data.lastname();
        this.type = data.type();
    }
}
