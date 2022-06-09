package com.example.ecommcerce.user.domain.query;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class GetUserQuery {
    @Min(1)
    @NotNull
    private Long id;
}
