package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "target_url")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class TargetUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_url", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "targetUrl", orphanRemoval = true)
    private List<Words> listWords;
}
