package com.harapps.masterly.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harapps.masterly.model.Skill
import com.harapps.masterly.repository.SkillRepository
import com.harapps.masterly.ui.SkillUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: SkillRepository): ViewModel() {

    private val _uiState = MutableStateFlow<SkillUiState>(SkillUiState.Loading)
    val uiState: StateFlow<SkillUiState> = _uiState

    private var cachedSkills: List<Skill> = emptyList()

    fun loadSkills() {
        viewModelScope.launch {
            _uiState.value = SkillUiState.Loading
            val result = repo.fetchSkill()
            if (result.isSuccess) {
                val skills = result.getOrNull()
                if (skills?.isEmpty() == true) {
                    _uiState.value = SkillUiState.Empty
                } else {
                    cachedSkills = skills!!
                    _uiState.value = SkillUiState.Content(skills)
                }
            } else {
                _uiState.value = SkillUiState.Error(result.exceptionOrNull()?.message)
            }
        }
    }

    fun getSkillByName(skillName: String): Skill? {
        return cachedSkills.firstOrNull { it.skillName == skillName }
    }

}