package org.matveev.bookservice.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetRequestDto {

    private long id;

}
