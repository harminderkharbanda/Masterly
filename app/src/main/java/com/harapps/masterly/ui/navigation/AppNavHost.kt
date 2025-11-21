package com.harapps.masterly.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.harapps.masterly.ui.screens.HomeScreen
import com.harapps.masterly.ui.screens.SkillDetails
import com.harapps.masterly.viewmodel.HomeViewModel

@Composable
fun AppNavHost(padding: PaddingValues, modifier: Modifier = Modifier, startDestination: String = NavDestinations.HOME) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination, modifier = modifier) {
        composable(NavDestinations.HOME) { backStackEntry ->
            val viewModel: HomeViewModel = hiltViewModel(backStackEntry)
            HomeScreen(padding, navController = navController, viewModel)
        }

        composable(
            route = NavDestinations.DETAIL_WITH_ARG,
            arguments = listOf(navArgument("skillName") { type = NavType.StringType })
        ) { backStackEntry ->
            val homeEntry = navController.getBackStackEntry(NavDestinations.HOME)
            val viewModel: HomeViewModel = hiltViewModel(homeEntry)
            val encodedName = backStackEntry.arguments?.getString("skillName")
            SkillDetails(padding, encodedName ?: "", viewModel, navController = navController)
        }
    }
}