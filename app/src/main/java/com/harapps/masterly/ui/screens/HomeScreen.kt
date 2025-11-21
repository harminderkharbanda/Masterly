package com.harapps.masterly.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.harapps.masterly.ui.SkillUiState
import com.harapps.masterly.ui.theme.MasterlyTheme
import com.harapps.masterly.viewmodel.HomeViewModel

@Composable
fun HomeScreen(paddingValues: PaddingValues,
               viewModel: HomeViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.loadSkills()
    }
    Column(modifier = Modifier.padding(paddingValues)) {
        val state = viewModel.uiState.collectAsState()
        when (val ui = state.value) {
            is SkillUiState.Content -> {
                SkillDetails(ui.skill)
            }

            is SkillUiState.Loading -> {

            }

            is SkillUiState.Empty -> {

            }

            is SkillUiState.Error -> {

            }
        }
    }

//    Column(modifier = Modifier.padding(paddingValues)) {

//        SkillCartItem(stringResource(R.string.skill_guitar), "1,250", 0.13f, 13)
//        SkillCartItem(stringResource(R.string.skill_javaScript), "10,000", 1f, 100)
//        SkillCartItem(stringResource(R.string.skill_digital_painting), "2,250", 0.23f, 23)
//        SkillCartItem(stringResource(R.string.skill_spanish), "6,450", 0.65f, 65)
//    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MasterlyTheme {
        HomeScreen(PaddingValues(16.dp))
    }
}