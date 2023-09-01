package org.matveev.bookservice.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteRequestDto {

    private long id;

}
