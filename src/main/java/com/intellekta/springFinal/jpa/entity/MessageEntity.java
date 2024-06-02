package com.intellekta.springFinal.jpa.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "messages")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MessageEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "tag", nullable = false)
    private String tag;

    public MessageEntity(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }
}
