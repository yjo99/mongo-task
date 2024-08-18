package com.sarmad.task.bussiness.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AppResponse<T> {
    public String message;
    public T payload;
}
