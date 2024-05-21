package com.ikimaka.composition.domain.usecases

import com.ikimaka.composition.domain.entity.GameSettings
import com.ikimaka.composition.domain.entity.Level
import com.ikimaka.composition.domain.repository.GameRepository

class GetGameSettingsUseCase(private val repository: GameRepository) {

    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}