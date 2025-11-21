package com.harapps.masterly.ui.navigation

object NavDestinations {
    const val HOME = "home"
    const val DETAIL = "detail"
    // route with argument
    const val DETAIL_WITH_ARG = "detail/{skillName}"
    fun detailRouteFor(skillName: String) = "detail/${skillName}"
}