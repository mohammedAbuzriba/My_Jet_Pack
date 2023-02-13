package ly.youcan.myapplication.Pages

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ly.youcan.myapplication.R
import ly.youcan.myapplication.data.entity.UserEntity
import ly.youcan.myapplication.ui.theme.Purple500

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun UserInfo(
    id:Int,
    name:String,
    email:String,
    phon:String,
    password:String,
    navController: NavController) {

    val vm: UserViewModel = viewModel<UserViewModel>()

    val state = vm.state.collectAsState().value
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val nameVal = remember { mutableStateOf(name) }
    val emailVal = remember { mutableStateOf(email) }
    val phoneVal = remember { mutableStateOf(phon) }
    val passwordVal = remember { mutableStateOf(password) }
    val confirmPasswordVal = remember { mutableStateOf(password) }

    val passwordVisibility = remember { mutableStateOf(false) }
    val confirmPasswordVisibility = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    painter = painterResource(R.drawable.userinfoo),
                    contentDescription = "Register Image",
                    modifier = Modifier
                        .width(300.dp)
                        .height(300.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = scaffoldState
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color.White)
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Update Info",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedTextField(
                            value = nameVal.value,
                            onValueChange = { nameVal.value = it },
                            label = { Text(text = "Name", color = Color.Black) },
                            placeholder = { Text(text = "Name" , color = Color.Black) },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.Black, textColor = Color.Black
                            )
                        )

                        OutlinedTextField(
                            value = emailVal.value,
                            onValueChange = { emailVal.value = it },
                            label = { Text(text = "Email Address", color = Color.Black) },
                            placeholder = { Text(text = "Email Address" , color = Color.Black) },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.Black, textColor = Color.Black
                            )
                        )

                        OutlinedTextField(
                            value = phoneVal.value,
                            onValueChange = { phoneVal.value = it },
                            label = { Text(text = "Phone Number", color = Color.Black) },
                            placeholder = { Text(text = "Phone Number" , color = Color.Black) },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.Black, textColor = Color.Black
                            )
                        )

                        OutlinedTextField(
                            value = passwordVal.value,
                            onValueChange = { passwordVal.value = it },
                            label = { Text(text = "Password", color = Color.Black) },
                            placeholder = { Text(text = "Password" , color = Color.Black) },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.Black, textColor = Color.Black
                            ),
                            trailingIcon = {
                                IconButton(
                                    onClick = {
                                        passwordVisibility.value = !passwordVisibility.value
                                    }
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_baseline_remove_red_eye_24),
                                        contentDescription = "Password Eye",
                                        tint = if (passwordVisibility.value) Purple500 else Color.Gray
                                    )
                                }
                            },
                            visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                            else PasswordVisualTransformation()
                        )

                        OutlinedTextField(
                            value = confirmPasswordVal.value,
                            onValueChange = { confirmPasswordVal.value = it },
                            label = { Text(text = "Password", color = Color.Black) },
                            placeholder = { Text(text = "Password" , color = Color.Black) },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.Black, textColor = Color.Black
                            ),
                            trailingIcon = {
                                IconButton(
                                    onClick = {
                                        confirmPasswordVisibility.value =
                                            !confirmPasswordVisibility.value
                                    }
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_baseline_remove_red_eye_24),
                                        contentDescription = "Password Eye",
                                        tint = if (confirmPasswordVisibility.value) Purple500 else Color.Gray
                                    )
                                }
                            },
                            visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None
                            else PasswordVisualTransformation()
                        )

                        Spacer(modifier = Modifier.padding(10.dp))

                        Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                            onClick = {

                                if (nameVal.value.isEmpty()) {
                                    Toast.makeText(
                                        context,
                                        "Please enter the name!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else if (emailVal.value.isEmpty()) {
                                    Toast.makeText(
                                        context,
                                        "Please enter the email address!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else if (phoneVal.value.isEmpty()) {
                                    Toast.makeText(
                                        context,
                                        "Please enter the phone number!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else if (passwordVal.value.isEmpty()) {
                                    Toast.makeText(
                                        context,
                                        "Please enter password!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else if (confirmPasswordVal.value.isEmpty()) {
                                    Toast.makeText(
                                        context,
                                        "Please enter confirm password!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else {

                                    vm.updateUser(
                                        UserEntity(
                                            id=id,
                                            name = nameVal.value,
                                            email =  emailVal.value,
                                            phonNumber= phoneVal.value,
                                            password =  passwordVal.value
                                        )
                                    )

                                    Toast.makeText(
                                        context,
                                        "Successfully Updated!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    navController.navigate("home_page")
                                }
                            }
                        ) {
                            Text(text = "Update", fontSize = 20.sp,color = Color.Black)
                        }

                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(text = "Back to Home" , color = Color.Black,
                            modifier = Modifier.clickable {
                                navController.navigate("home_page")
                            }
                        )
                    }
                }
            }
        }
    }
}
