package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "words")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Words {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_word", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String word;

    @Column(nullable = false)
    private Integer count;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(insertable = false, updatable = false, name = "id_word", referencedColumnName = "id_url", foreignKey = @ForeignKey(name = "target_url_id_fk"))
    private TargetUrl targetUrl;

}
