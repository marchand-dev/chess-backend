package com.marchand.chessbackend.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateGameResponse {
    private UUID gameId;
    private boolean hasError;
    private String errorMessage;
}
