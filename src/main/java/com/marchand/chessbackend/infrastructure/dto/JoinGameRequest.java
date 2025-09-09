package com.marchand.chessbackend.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoinGameRequest {
    private UUID gameId;
    private UUID playerId;
}
