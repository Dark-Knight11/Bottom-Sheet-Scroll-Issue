package com.hypernova.bottomsheet.navigation

import com.hypernova.bottomsheet.R

sealed class Screens(
    val route: String,
    val title: String,
    val icon: Int
) {
    object LandingPage: Screens(
        route = "landing_page",
        title = "Welcome",
        icon = R.drawable.ic_baseline_home_24
    )
    object SecondPage: Screens(
        route = "second_page",
        title = "Second Page",
        icon = R.drawable.ic_baseline_approval_24
    )
    object SheetScreen1: Screens(
        route = "screen_1",
        title = "First Page",
        icon = R.drawable.ic_baseline_first_page_24
    )
    object SheetScreen2: Screens(
        route = "screen_2",
        title = "Second Page",
        icon = R.drawable.ic_baseline_security_24
    )
    object SheetScreen3: Screens(
        route = "screen_3",
        title = "Third Page",
        R.drawable.ic_baseline_check_circle_outline_24
    )
    object SheetScreen4: Screens(
        route = "screen_4",
        title = "Fourth Page",
        R.drawable.ic_baseline_change_history_24
    )
}