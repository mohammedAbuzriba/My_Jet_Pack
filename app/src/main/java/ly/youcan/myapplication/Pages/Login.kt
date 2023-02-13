package com.example.simpleui_login_register_jetpackcompose.view

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavController
import ly.youcan.myapplication.Pages.UserViewModel
import ly.youcan.myapplication.R
import ly.youcan.myapplication.core.Recourc
import ly.youcan.myapplication.data.entity.UserEntity
import ly.youcan.myapplication.ui.theme.Purple500
import ly.youcan.myapplication.ui.theme.cairoBold
import ly.youcan.myapplication.ui.theme.cairoSemiBold
import ly.youcan.myapplication.ui.theme.ibarraBold

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginPage(navController: NavController) {
    val vm: UserViewModel = viewModel<UserViewModel>()
    val state = vm.state.collectAsState().value
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val emailVal = remember { mutableStateOf("") }
    val passwordVal = remember { mutableStateOf("") }

    val passwordVisiblity = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()


        ) {
            Box(
                modifier = Modifier.background(White),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    modifier = Modifier
                        .width(450.dp)
                        .height(400.dp)
                        .clickable {
                            navController.navigate("home_page")
                        },
                    painter = painterResource(R.drawable.log),
                    contentDescription = "Login Image",
                    contentScale = ContentScale.Fit,
                )
            }
            LaunchedEffect(key1 = state) {
                when (state) {
                    is Recourc.Loading<UserEntity> -> {

                    }
                    is Recourc.Success<UserEntity> -> {
                        Toast.makeText(
                            context,
                            "Logged Successfully! ${state.data!!.name}",
                            Toast.LENGTH_SHORT
                        ).show()
                        emailVal.value = ""
                        passwordVal.value = ""
                        navController.navigate("home_page")
                    }
                    is Recourc.Error<UserEntity> -> {
                        emailVal.value = ""
                        passwordVal.value = ""
                        Toast.makeText(
                            context,
                            " Error! ${state.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    else -> {

                    }
                }
            }


//            Spacer(modifier = Modifier.padding(20.dp))


            Scaffold(modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(25.dp))
                        .background(White)
                )
                {
                    Text(
                        text = stringResource(id = R.string.sign_In),
                        style = ibarraBold,
                        color = Black
                    )

                    Spacer(modifier = Modifier.padding(20.dp))


                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        OutlinedTextField(
                            value = emailVal.value,
                            onValueChange = { emailVal.value = it },
                            label = { Text(text = "Email Address", color = Black) },
                            placeholder = { Text(text = "Email Address", color = Black) },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Black, textColor = Black
                            )
                        )

                        OutlinedTextField(
                            value = passwordVal.value,
                            onValueChange = { passwordVal.value = it },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Black, textColor = Black
                            ),
                            trailingIcon = {
                                IconButton(onClick = {
                                    passwordVisiblity.value = !passwordVisiblity.value
                                }) {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_baseline_remove_red_eye_24),
                                        contentDescription = "Password",
                                        tint = if (passwordVisiblity.value) Purple500 else Color.Gray
                                    )
                                }
                            },
                            label = { Text(text = "Password", color = Black) },
                            placeholder = { Text(text = "Password", color = Black) },
                            singleLine = true,
                            visualTransformation = if (passwordVisiblity.value) VisualTransformation.None else PasswordVisualTransformation(),
                            modifier = Modifier.fillMaxWidth(0.8f)
                        )

                        Spacer(modifier = Modifier.padding(20.dp))

                        Button(
                            colors = ButtonDefaults.buttonColors(backgroundColor = LightGray),
                            onClick = {
                                when {
                                    emailVal.value.isEmpty() -> {
                                        Toast.makeText(
                                            context,
                                            "Please enter email address!",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                    passwordVal.value.isEmpty() -> {
                                        Toast.makeText(
                                            context,
                                            "Please enter the password!",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                    else -> {
                                        vm.login(
                                            email = emailVal.value,
                                            password = passwordVal.value
                                        )
                                    }
                                }

                            }, modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(50.dp)
                        ) {
                            Text(text = "Sign In", fontSize = 20.sp, color = Black)
                        }

                        Spacer(modifier = Modifier.padding(20.dp))

                        Text(text = "Create an Account?", color = Black,
                            modifier = Modifier.clickable { navController.navigate("register_page") })

                        Spacer(modifier = Modifier.padding(20.dp))


                    }
                }
            }

        }
    }


}