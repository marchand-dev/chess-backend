package com.marchand.chessbackend.infrastructure.dto;

import com.marchand.chessbackend.core.models.Move;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessTurnRequest {
    private Move move;
}
