package ly.youcan.myapplication.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ly.youcan.myapplication.R

//  -------------     start with  Fonts styles
val CairoFont = FontFamily(
    Font(R.font.cairo_regular),
    Font(R.font.cairo_semi_bold, FontWeight.SemiBold)
)
val IbarraFont = FontFamily(
    Font(R.font.ibarra_realnova_regular),
    Font(R.font.ibarra_realnova_bold, FontWeight.Bold)
)
val MrsFont = FontFamily(
    Font(R.font.mrs_saint_delafield_regular)
)
val cairoSemiBold = TextStyle(
    fontFamily = CairoFont,
    fontWeight = FontWeight.SemiBold,
    fontSize = 25.sp
)
val cairoBold = TextStyle(
    fontFamily = CairoFont,
    fontWeight = FontWeight.Bold,
    fontSize = 25.sp
)
val ibarraBold = TextStyle(
    fontFamily = IbarraFont,
    fontWeight = FontWeight.Bold,
    fontSize = 25.sp
)
val mrsBold = TextStyle(
    fontFamily = MrsFont,
    fontWeight = FontWeight.Normal,
    fontSize = 25.sp
)
//  -------------     end  Fonts styles

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)