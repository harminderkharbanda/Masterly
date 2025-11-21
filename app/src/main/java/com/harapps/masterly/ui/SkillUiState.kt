package com.harapps.masterly.ui

import com.harapps.masterly.model.Skill

sealed class SkillUiState {
    object Loading : SkillUiState()
    data class Error(val message: String?) : SkillUiState()
    object Empty : SkillUiState()
    data class Content(val skills: List<Skill>) : SkillUiState()
}