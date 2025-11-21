package com.harapps.masterly.repository

import com.harapps.masterly.model.Skill
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SkillRepository @Inject constructor() {

    suspend fun fetchSkill(): Result<List<Skill>> {
        return try {
            // fetch from API / DB
            delay(300)
            Result.success(
                listOf(
                    Skill(
                        skillName = "Guitar",
                        percentageFraction = 0.32f,
                        percentageCompleted = 32,
                        hoursCompleted = "3,200"
                    ),
                    Skill(
                        skillName = "Digital Printing",
                        percentageFraction = 0.12f,
                        percentageCompleted = 12,
                        hoursCompleted = "1,200"
                    ),
                    Skill(
                        skillName = "Piano",
                        percentageFraction = 1f,
                        percentageCompleted = 100,
                        hoursCompleted = "10,000"
                    ),
                    Skill(
                        skillName = "Chess",
                        percentageFraction = 0f,
                        percentageCompleted = 0,
                        hoursCompleted = "0"
                    ),
                    Skill(
                        skillName = "Swimming",
                        percentageFraction = 0.5f,
                        percentageCompleted = 50,
                        hoursCompleted = "5,000"
                    ),
                    Skill(
                        skillName = "Cycling",
                        percentageFraction = 0.5f,
                        percentageCompleted = 50,
                        hoursCompleted = "5,000"
                    ),
                    Skill(
                        skillName = "Arabic",
                        percentageFraction = 0.1f,
                        percentageCompleted = 10,
                        hoursCompleted = "1,000"
                    ),
                    Skill(
                        skillName = "Math",
                        percentageFraction = 0.1f,
                        percentageCompleted = 10,
                        hoursCompleted = "1,000"
                    )
                )
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}