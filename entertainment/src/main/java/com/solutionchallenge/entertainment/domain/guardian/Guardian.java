package com.solutionchallenge.entertainment.domain.guardian;

import com.solutionchallenge.entertainment.domain.BaseTimeEntity;
import com.solutionchallenge.entertainment.domain.senior.Senior;
import com.solutionchallenge.entertainment.domain.significant.Significant;
import com.solutionchallenge.entertainment.service.dto.GuardianDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Guardian extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long guardianId;

    @Column
    private String name;
    private String nickName;
    private String password;
    private String phoneNum;
    private Date birth;
    private String gender;
    private String address;
    private String profileUrl;
    private String email;
    @OneToOne
    @JoinColumn(name="senior_Id")
    private Senior senior;

    @OneToMany(mappedBy = "guardian",orphanRemoval = true)
    private List<Significant> significants = new ArrayList<>();

    public static Guardian newInstance(GuardianDTO guardianDTO, Senior senior) {
        return Guardian.builder()
                .name(guardianDTO.getName())
                .nickName(guardianDTO.getNickName())
                .password(guardianDTO.getPassword())
                .phoneNum(guardianDTO.getPhone())
                .birth(guardianDTO.getBirth())
                .gender(guardianDTO.getGender())
                .address(guardianDTO.getAddress())
                .email(guardianDTO.getEmail())
                .senior(senior)
                .build();
    }

    public void updateProfile(String profileUrl) {
        this.profileUrl = profileUrl;
    }
}
