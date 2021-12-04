# Bottom-Sheet-Scroll-Issue

This repo is created to recreate the scroll lag issue for screens navigated through Bottom Drawer.  

## Issue

Main issue was in this code [here](https://github.com/Dark-Knight11/Bottom-Sheet-Scroll-Issue/blob/a8246a98f7b38c2760c310dccd00ab2982529f79/app/src/main/java/com/hypernova/bottomsheet/HomeScreen.kt#L59-L62)   
```Kotlin 
var fabIconVisibility by remember { mutableStateOf(true) }
var gesturesEnabled by remember { mutableStateOf(false) }
LaunchedEffect(key1 = drawerState.isOpen, key2 = drawerState.isClosed) {
    gesturesEnabled = drawerState.isOpen
    fabIconVisibility = drawerState.isClosed
}

```

`gesturesEnabled` mainly gives problem `fabIconVisibility` works fine


## Fix

Use [derived state](https://developer.android.com/jetpack/compose/side-effects#derivedstateof) instead of Launched State to check the state of gesture 

```Kotlin
val gesturesEnabled by remember {
    derivedStateOf { drawerState.isOpen }
}
```

[Example](https://github.com/Dark-Knight11/Bottom-Sheet-Scroll-Issue/blob/e6ce0ec11dfeaa6939a253b1b6cc7bd4e6cfb067/app/src/main/java/com/hypernova/bottomsheet/HomeScreen.kt#L58-L60)

