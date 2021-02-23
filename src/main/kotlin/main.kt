import androidx.compose.desktop.Window
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import java.io.File
import javax.swing.JFileChooser
import javax.swing.JFrame
import javax.swing.SwingUtilities


var selectFile: File = File("")

var li: Elements? = null
fun main() = Window {
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
                    Button(onClick = { getFileProvider() }) {
                        Text("FILE!!!!")
                    }
                }

                LazyColumn(Modifier.fillMaxWidth().padding(end = 20.dp)) {
                    li?.let {
                        items(items = it.toList()) { item ->

                            getBookmarkUnit(item.toString())
                        }
                    }


                }

            }

        }
    }
}

fun getFileProvider() {

    SwingUtilities.invokeLater {
        val root = JFrame()
        val window = JFileChooser()
        var bookmarks = ""
        window.showOpenDialog(root)
        selectFile = window.selectedFile
        selectFile.bufferedReader().use {
            bookmarks = it.readText()
            val doc = Jsoup.parse(bookmarks)
            li = doc.body().getElementsByTag("li")
        }
    }
}


@Composable
fun getMenuItem(name: String) {
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
fun getBookmarkUnit(title: String) {
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
                Text("$title", style = MaterialTheme.typography.h5)
                Text("$title", style = MaterialTheme.typography.body1)
            }
        }

    }

}
