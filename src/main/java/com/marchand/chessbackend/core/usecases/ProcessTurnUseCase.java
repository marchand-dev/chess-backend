package com.marchand.chessbackend.core.usecases;

import com.marchand.chessbackend.core.dto.ProcessTurnResult;
import com.marchand.chessbackend.core.models.Move;

import java.util.UUID;

public interface ProcessTurnUseCase {
    ProcessTurnResult execute(Move move);
}
