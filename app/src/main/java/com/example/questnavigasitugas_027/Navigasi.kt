package com.example.questnavigasitugas_027

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questnavigasitugas_027.Views.FormScreen
import com.example.questnavigasitugas_027.Views.ListScreen
import com.example.questnavigasitugas_027.Views.WelcomeScreen


enum class AppScreen {
    Welcome,
    List,
    Form
}


@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
) {

    val viewModel: DataView = viewModel()

    NavHost(
        navController = navController,
        startDestination = AppScreen.Welcome.name
    ) {

        composable(route = AppScreen.Welcome.name) {
            WelcomeScreen(
                onMskBtnClick = {
                    navController.navigate(AppScreen.List.name)
                }
            )
        }


        composable(route = AppScreen.List.name) {
            val uiState by viewModel.uiState.collectAsState()

            ListScreen(
                listData = uiState.listData,
                onBrndBtnClick = {

                    navController.popBackStack(AppScreen.Welcome.name, inclusive = false)
                },
                onFormsBtnClick = {
                    navController.navigate(AppScreen.Form.name)
                }
            )
        }


        composable(route = AppScreen.Form.name) {
            FormScreen(
                onSmbtBtnClick = { dataBaru ->
                    viewModel.addData(dataBaru)
                    navController.popBackStack()
                },
                onKmblBtnClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}

