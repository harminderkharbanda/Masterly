package com.harapps.masterly.repository

import com.harapps.masterly.model.Skill
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SkillRepository @Inject constructor() {

    suspend fun fetchSkill(): Result<Skill> {
        return try {
            // fetch from API / DB
            Result.success(
                Skill(
                    skillName = "Guitar",
                    percentageFraction = 0.32f,
                    percentageCompleted = 32,
                    hoursCompleted = "3,200"
                )
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}