package com.sarmad.task.bussiness.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@RedisHash("CarModel")
public class CarModelDto {

    @Id
    private String carModelId;

    private String modelName;

    private String manufacturerYear;

    private String type;
}
