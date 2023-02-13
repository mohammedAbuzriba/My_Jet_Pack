package ly.youcan.myapplication.ui.theme.widget.button

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ly.youcan.myapplication.ui.theme.Purple100
import ly.youcan.myapplication.ui.theme.cairoBold
import ly.youcan.myapplication.ui.theme.cairoSemiBold

@Composable
fun FirstButton(
    modifier: Modifier,
    @StringRes textId: Int,
    onClick: () -> Unit,
) {
    CustomButton(
        modifier = modifier,
        color = Purple100,
        onClick = onClick,
        textId =textId,
        textStyle = cairoBold
    )
}