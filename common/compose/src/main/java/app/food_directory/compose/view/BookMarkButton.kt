

package app.food_directory.compose.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BookMarkButton(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    selected: Boolean = false,
    onBookMark: () -> Unit
) {
    val icon = if (selected) Icons.Outlined.Bookmark else Icons.Filled.BookmarkBorder
    Surface(
        color = backgroundColor,
        shape = CircleShape,
        modifier = modifier
            .requiredSize(36.dp, 36.dp)
            .clickable {
                onBookMark()
            }
    ) {
        Icon(
            imageVector = icon,
            tint = colorResource(id = android.R.color.white),
            contentDescription = null,
            modifier = Modifier
                .padding(6.dp)
        )
    }
}

@Composable
@Preview
fun previewBookMarkButtonClicked() {
    BookMarkButton(selected = false, backgroundColor = Color.Black) {}
}

@Composable
@Preview
fun previewBookMarkButtonUnClicked() {
    BookMarkButton(selected = true, backgroundColor = Color.Black) {}
}
