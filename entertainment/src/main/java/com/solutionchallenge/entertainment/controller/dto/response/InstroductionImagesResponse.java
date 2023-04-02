package com.solutionchallenge.entertainment.controller.dto.response;

import com.solutionchallenge.entertainment.domain.instroductionImages.InstroductionImages;
import lombok.*;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstroductionImagesResponse {
    private Long imageId;
    private String imageUrl;

    public InstroductionImagesResponse(InstroductionImages instroductionImages) {
        this.imageId = instroductionImages.getInstroductionImageId();
        this.imageUrl = instroductionImages.getImageUrl();
    }
}
