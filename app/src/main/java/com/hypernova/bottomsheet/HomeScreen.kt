package com.hypernova.bottomsheet

import android.transition.Visibility
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.hypernova.bottomsheet.navigation.NavGraph
import com.hypernova.bottomsheet.navigation.Screens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun HomeScreen(bottomNavItems: List<Screens>, bottomSheetItems: List<Screens>) {
    val navController = rememberAnimatedNavController()
    val scope = rememberCoroutineScope()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val drawerState = rememberBottomDrawerState(BottomDrawerValue.Closed)
    var fabIconVisibility by remember { mutableStateOf(true) }
    var bottomBarVisibility by remember { mutableStateOf(true) }
    val routesWithBottomNav = listOf(Screens.LandingPage.route, Screens.SecondPage.route)
    bottomBarVisibility = currentDestination?.hierarchy?.any {
        routesWithBottomNav.contains(it.route)
    } == true

    val gesturesEnabled by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            AnimatedVisibility(
                visible = bottomBarVisibility,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Box(
                    modifier = Modifier
                        .graphicsLayer {
                            shape = CircleShape
                            clip = true
                        }
                        .size(58.dp)
                        .background(Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    FloatingActionButton(
                        onClick = {
//                            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
                            if (drawerState.isClosed) {
                                scope.launch { drawerState.expand() }
                            } else {
                                scope.launch { drawerState.close() }
                            }
                            fabIconVisibility = !fabIconVisibility
                        },
                        content = {
                            Icon(
                                Icons.Default.Menu, contentDescription = "Open Drawer",
                                tint = Color.White
                            )
                        },
                        backgroundColor = Color.Black
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        drawerGesturesEnabled = false,
        bottomBar = {
            AnimatedVisibility(
                visible = bottomBarVisibility,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                BottomBar(
                    navController = navController,
                    currentDestination = currentDestination,
                    bottomNavItems = bottomNavItems
                )
            }
        },
        content = {
            BottomSheet(
                bottomSheetItems = bottomSheetItems,
                scope = scope,
                drawerState = drawerState,
                navController = navController,
                gesturesEnabled = gesturesEnabled
            )
        }
    )
}

@Composable
fun BottomBar(
    navController: NavHostController,
    currentDestination: NavDestination?,
    bottomNavItems: List<Screens>,
) {
    BottomAppBar(
        cutoutShape = MaterialTheme.shapes.small.copy(
            CornerSize(percent = 50)
        ),
        backgroundColor = MaterialTheme.colors.background,
        elevation = AppBarDefaults.BottomAppBarElevation
    ) {
        bottomNavItems.forEach { Screen ->
            BottomNavigationItem(
                label = {
                    Text(
                        text = Screen.title,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif
                    )
                },
                icon = {
                    Icon(
                        painter = painterResource(id = Screen.icon),
                        contentDescription = Screen.title
                    )
                },
                selected = currentDestination?.hierarchy?.any { it.route == Screen.route } == true,
                onClick = {
                    navController.navigate(Screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = Color.White
            )
        }
    }
}

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun BottomSheet(
    bottomSheetItems: List<Screens>,
    scope: CoroutineScope,
    drawerState: BottomDrawerState,
    navController: NavHostController,
    gesturesEnabled: Boolean
) {
    BottomDrawer(
        drawerContent = {
            LazyColumn(modifier = Modifier.padding(top = 10.dp, bottom = 90.dp)) {
                items(bottomSheetItems) { screen ->
                    ListItem(
                        modifier = Modifier
                            .clickable {
                                scope.launch {
                                    drawerState.close()
                                    //delay(10)
                                    navController.navigate(screen.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            },
                        icon = {
                            Icon(
                                modifier = Modifier.requiredSize(20.dp),
                                imageVector = ImageVector.vectorResource(id = screen.icon),
                                contentDescription = "Localized description",
                                tint = Color.White
                            )
                        },
                        text = {
                            Text(
                                text = screen.title,
                                color = Color.White,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Medium
                            )
                        },
                        trailing = {
                            Icon(
                                Icons.Default.KeyboardArrowRight,
                                contentDescription = "Navigate to",
                                tint = Color.White
                            )
                        },
                    )
                }
            }
        },
        drawerState = drawerState,
        drawerBackgroundColor = MaterialTheme.colors.background,
        drawerShape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp),
        content = { NavGraph(navController) },
        gesturesEnabled = gesturesEnabled
    )
}

