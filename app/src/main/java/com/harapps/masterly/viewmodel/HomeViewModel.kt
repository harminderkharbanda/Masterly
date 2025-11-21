package com.harapps.masterly.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    fun loadSkills() {
        viewModelScope.launch {
            _uiState.value = SkillUiState.Loading
            val result = repo.fetchSkill()
            if (result.isSuccess) {
                val skill = result.getOrNull()
                if (skill == null) {
                    _uiState.value = SkillUiState.Empty
                } else {
                    _uiState.value = SkillUiState.Content(skill)
                }
            } else {
                _uiState.value = SkillUiState.Error(result.exceptionOrNull()?.message)
            }
        }
    }

}