package com.example.demoTwitter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="tweet_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManytoMany(fetch = fetch.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="tweet_tag", joinColumns = @JoinColumn(name="tweet_id"),
            inverseJoinColumn =@JoinColumn(name = "tag_id"))
    private List<Tag> tags;

    @NotEmpty(message = "Tweet cannot be empty")
    @Length(mex = 280, message="Tweet cannot have more than 280 characters")
    private String message;

    @CreationTimestamp
    private Date createdAt;

}
