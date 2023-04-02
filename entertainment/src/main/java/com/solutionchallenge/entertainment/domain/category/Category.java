package com.solutionchallenge.entertainment.domain.category;

import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;

    @Column
    private String content;

    @OneToMany(mappedBy = "category")
    private List<Lecture> lectures = new ArrayList<>();

    public static Category getNewInstance(String content){
        return Category.builder()
                .content(content)
                .build();
    }
}
