package com.example.elearningdemoservice.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Permission extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "permissions")
    private List<Role> roles;

    @ManyToMany(mappedBy = "permissions")
    private List<Url> urls;

}
