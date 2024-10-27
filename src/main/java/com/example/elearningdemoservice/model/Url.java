package com.example.elearningdemoservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Url extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String path;
    private Long menuId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "permissionUrl",
            joinColumns = @JoinColumn(
                    name = "urlId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "permissionId", referencedColumnName = "id"))
    @JsonIgnore
    private List<Permission> permissions;
}
