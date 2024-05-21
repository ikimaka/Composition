package com.ikimaka.composition.domain.repository

import com.ikimaka.composition.domain.entity.GameSettings
import com.ikimaka.composition.domain.entity.Level
import com.ikimaka.composition.domain.entity.Question

interface GameRepository {

    fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question

    fun getGameSettings(level: Level): GameSettings
}