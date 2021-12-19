package com.api.orange.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Entity(name = "User")
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 75)
    private String name;

    @Column(name = "cpf", nullable = false, unique = true)
    @CPF(message = "It´s not a valid cpf")
    private String cpf;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "It´s not a valid e-mail")
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false, name = "birthDay")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDay;
}
