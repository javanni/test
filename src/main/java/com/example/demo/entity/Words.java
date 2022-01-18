package com.example.demo.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity(name = "Words")
@Table(
        name = "words",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_word_for_current_url", columnNames = "word")
        }
)
public class Words {

    @Id
    @SequenceGenerator(
            name = "words_sequence",
            sequenceName = "words_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "words_sequence"
    )
    @Column(
            name = "id",
            nullable = false
    )
    private Long id;

    @Column(
            name = "word",
            nullable = false,
            columnDefinition = "varchar(255)"
    )
    private String word;

    @Column(
            name = "count",
            nullable = false,
            columnDefinition = "integer"
    )
    private Integer count;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            insertable = false,
            updatable = false,
            name = "id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "target_url_id_fk"
            )
    )
    private TargetUrl targetUrl;

    public Words() {
    }

    public Words(String word, Integer count) {
        this.word = word;
        this.count = count;
    }

    public Words(String word, Integer count, TargetUrl targetUrl) {
        this.word = word;
        this.count = count;
        this.targetUrl = targetUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


    @Override
    public String toString() {
        return "Words{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Words words = (Words) o;

        if (!getId().equals(words.getId())) return false;
        if (!getWord().equals(words.getWord())) return false;
        if (!getCount().equals(words.getCount())) return false;
        return targetUrl.equals(words.targetUrl);
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getWord().hashCode();
        result = 31 * result + getCount().hashCode();
        return result;
    }
}
