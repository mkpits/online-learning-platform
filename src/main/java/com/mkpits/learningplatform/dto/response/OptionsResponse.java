package com.mkpits.learningplatform.dto.response;

import lombok.*;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
public class OptionsResponse {

    private long option_id;

    private String tag;

    private String que_option;
}
