package com.marchand.chessbackend.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StartGameResponse {
    private UUID gameId;
    private boolean hasError;
    private String errorMessage;
}
