package com.harapps.masterly.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.harapps.masterly.ui.SkillUiState
import com.harapps.masterly.ui.components.SkillCartItem
import com.harapps.masterly.ui.navigation.NavDestinations
import com.harapps.masterly.ui.theme.MasterlyTheme
import com.harapps.masterly.viewmodel.HomeViewModel

@Composable
fun HomeScreen(padding: PaddingValues, navController: NavController,
               viewModel: HomeViewModel
) {
    LaunchedEffect(Unit) {
        viewModel.loadSkills()
    }
    val state = viewModel.uiState.collectAsState()

    when (val ui = state.value) {
        is SkillUiState.Content -> {
            LazyColumn(modifier = Modifier.padding(paddingValues = padding)) {
                items(ui.skills) { skill ->
                    SkillCartItem(skill, onClick = {
                        navController.navigate(NavDestinations.detailRouteFor(skill.skillName))
                    })
                }
            }
        }

        is SkillUiState.Loading -> {

        }

        is SkillUiState.Empty -> {

        }

        is SkillUiState.Error -> {

        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MasterlyTheme {
        HomeScreen(PaddingValues(16.dp), navController = NavController(LocalContext.current), hiltViewModel())
    }
}