package com.solutionchallenge.entertainment.controller.dto.request;

import com.solutionchallenge.entertainment.service.dto.SeniorDTO;
import lombok.*;

import java.util.Date;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class GurdianInputSeniorRequest {
    private String nickName;
    private String name;
    private String address;
    private String phone;
    private String gender;
    private Date birth;

    private String email;

    public static GurdianInputSeniorRequest of(String nickName,String name, String address, String phone, String gender, Date birth, String email) {
        return new GurdianInputSeniorRequest(nickName,name, address, phone, gender, birth,email);
    }

    public SeniorDTO toServiceDto(){
        return SeniorDTO.of(nickName,name, address, phone, gender, birth,email);
    }

}
