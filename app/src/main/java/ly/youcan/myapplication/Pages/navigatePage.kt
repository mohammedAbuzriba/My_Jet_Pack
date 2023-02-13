package ly.youcan.myapplication.Pages.NavigatePage

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.simpleui_login_register_jetpackcompose.view.LoginPage
import com.example.simpleui_login_register_jetpackcompose.view.SignUp
import ly.youcan.myapplication.Pages.UserInfo
import ly.youcan.myapplication.Pages.loginPage.HomePage

@Composable
fun navigatePage() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login_page",
        builder = {
            composable("login_page", content = { LoginPage(navController = navController) })
            composable("register_page", content = { SignUp(navController = navController) })
            composable("home_page", content = { HomePage(navController = navController) })
            composable("UserInfo_page/{id}/{name}/{email}/{phon}/{password}",
                arguments = listOf(
                    navArgument(name = "id"){
                        type = NavType.IntType
                    },
                    navArgument(name = "name"){
                        type = NavType.StringType
                    },
                    navArgument(name = "email"){
                        type = NavType.StringType
                    },
                    navArgument(name = "phon"){
                        type = NavType.StringType
                    },
                    navArgument(name = "password"){
                        type = NavType.StringType
                    }
                ),
                content = {
                    UserInfo(
                        id = it.arguments?.getInt("id")!!.toInt(),
                        name = it.arguments?.getString("name").toString(),
                        email = it.arguments?.getString("email").toString(),
                        phon = it.arguments?.getString("phon").toString(),
                        password = it.arguments?.getString("password").toString(),
                        navController = navController)
                })
        }
    )
}