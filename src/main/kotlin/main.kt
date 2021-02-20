import androidx.compose.desktop.Window
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp

fun main() = Window {
    var text by remember { mutableStateOf("Hello, World!") }
    var bookmark = listOf(1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    MaterialTheme {

        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                Modifier.padding(16.dp).background(Color.White).fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Менеджер закладок", style = MaterialTheme.typography.h5)
            }
            Row {
                Column(modifier = Modifier.padding(4.dp)) {
                    getMenuItem("Projects")
                    getMenuItem("Человечье")
                    getMenuItem("SomeItem")
                    getMenuItem("SomeItem")

                }
                ScrollableColumn(Modifier.fillMaxWidth().padding(end = 20.dp)) {
                    for (i in bookmark) {
                        Unit(i)
                    }
                }
            }

        }

    }
}


@Composable
private fun getMenuItem(name: String) {
    Row(modifier = Modifier.padding(top = 4.dp)) {
        Image(
            imageResource("placeholder.jpg"),
            Modifier.preferredHeight(50.dp).preferredWidth(50.dp).align(Alignment.CenterVertically)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.preferredWidth(12.dp))
        Text(name)
    }
}


@Composable
fun Unit(i: Int) {
    Card(
        elevation = 4.dp,
        modifier = Modifier.fillMaxWidth().padding(bottom = 5.dp),
        border = BorderStroke(1.dp, Color.DarkGray)
    ) {
        Row(modifier = Modifier.preferredHeight(80.dp)) {

            Image(
                imageResource("placeholder.jpg"),
                Modifier.preferredHeight(50.dp).preferredWidth(50.dp).align(Alignment.CenterVertically)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.FillBounds
            )
            Column(Modifier.padding(start = 15.dp)) {
                Text("Заголовок страницы", style = MaterialTheme.typography.h5)
                Text("$i", style = MaterialTheme.typography.body1)
            }
        }

    }

}
