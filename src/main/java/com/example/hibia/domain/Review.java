package com.example.hibia.domain;

import com.example.hibia.domain.common.CommonDateEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Review extends CommonDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id")
    private Long id;

    @Column(name = "review_author",nullable = false)
    private String author;

    @Column(name = "review_content", nullable = false)
    private String content;

    @Column(name = "review_stars", nullable = false)
    private int stars;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    protected Item getItem(){
        return item;
    }

    public Review(User user, Item item, String author, String content, int stars) {
        this.user = user;
        this.item = item;
        this.author = author;
        this.content = content;
        this.stars = stars;
    }

    public Review setReview(String author, String content, int stars){
        this.author = author;
        this.content = content;
        this.stars = stars;
        return this;
    }
}
