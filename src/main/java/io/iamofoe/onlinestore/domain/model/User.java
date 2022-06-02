package io.iamofoe.onlinestore.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "Users")
@Accessors(chain = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String firstName;
    private String lastName;
    private String pictureUrl;
    private String email;
    private String password;
    private Role role;
}
