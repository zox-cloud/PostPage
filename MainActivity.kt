package kz.singularity.jetpackcomposemost

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import kz.singularity.jetpackcomposemost.ui.theme.JetpackComposeMostTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {

            JetpackComposeMostTheme {
                LazyColumn {
                    item(50) {
                        PostList()
                    }
                }



            }
        }
    }
}

    @Composable
    fun Greeting(name: String, greeetingWord: String = "My name", modifier: Modifier = Modifier) {

        Row(verticalAlignment = Alignment.CenterVertically) {


            Image(
                modifier = Modifier.size(48.dp),
                painter = painterResource(id = R.drawable.img_waving_robot),
                contentDescription = "Greeting"
            )

            Text(
                text = greeetingWord,
                modifier = Modifier.padding(end = 4.dp)
            )
            Text(
                text = "$name!",
                modifier = modifier
            )
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {

//        JetpackComposeMostTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//
//                    LazyColumn {
//                        items(100) {index ->
//                            Greeting(
//                                name = "User #${index+1}", greeetingWord = "Hello",
//                                modifier = Modifier.padding(innerPadding)
//                            )
//                        }
//
//
//                    }
//
//
//            }
//        }


        JetpackComposeMostTheme {

//        LazyColumn {
//            items(100){
//
//                SimplePostPage()
//            }
//
//
//        }

            PostList()

        }

    }


    @Composable
    fun SimplePostPage() {
        var title by remember { mutableStateOf("") }
        var content by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
//        Text(
//            text = "Create Post",
//            style = TextStyle(fontSize = 24.sp),
//            modifier = Modifier.padding(bottom = 16.dp)
//
//        )

            BasicTextField(
                value = title,
                onValueChange = { title = it },
                textStyle = TextStyle(fontSize = 20.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 0.dp)
                    .height(56.dp),
                decorationBox = { innerTextField ->
                    if (title.isEmpty()) {
                        Text(text = "Post title", style = TextStyle(fontSize = 18.sp))
                    }
                    innerTextField()
                }

            )

            BasicTextField(
                value = content,
                onValueChange = { content = it },
                textStyle = TextStyle(fontSize = 18.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .height(150.dp),
                decorationBox = { innerTextField ->
                    if (content.isEmpty()) {
                        Text(text = "there was many", style = TextStyle(fontSize = 18.sp))
                    }
                    innerTextField()
                }
            )


        }
    }

    @Composable
    fun PostDetails() {
        var title by remember { mutableStateOf("") }
        var content by remember { mutableStateOf("") }
        var comment = "Comments"

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Top
        ) {


            BasicTextField(
                value = title,
                onValueChange = { title = it },
                textStyle = TextStyle(fontSize = 20.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 0.dp)
                    .height(56.dp),

                decorationBox = { innerTextField ->
                    if (title.isEmpty()) {
                        Text(text = "Post title", style = TextStyle(fontSize = 18.sp))
                    }
                    innerTextField()
                }
            )

            BasicTextField(
                value = content,
                onValueChange = { content = it },
                textStyle = TextStyle(fontSize = 20.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 48.dp)
                    .height(56.dp),
                decorationBox = { innerTextField ->
                    if (content.isEmpty()) {
                        Text(text = "Content should be here ", style = TextStyle(fontSize = 18.sp))
                    }
                    innerTextField()
                }

            )

            BasicTextField(
                value = comment,
                onValueChange = { comment = it },
                textStyle = TextStyle(fontSize = 20.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 0.dp)
                    .height(56.dp),
                decorationBox = { innerTextField ->
                    Text(text = "${comment}")

                }
            )
        }
    }


    @Composable
    fun PostList() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            repeat(4) {
                PostCard()
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }

    @Composable
    fun PostCard() {
        Card(
            shape = RoundedCornerShape(8.dp),

            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Post Title",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Hello ipsum dolor sit amet, consectetur adipiscing elit. Aliquam molestie nisl ac faucibus blandit. Donec quis nulla quis quam vestibulum egestas at eget velit. Praesent nec ex quis nisl ullamcorper euismod. Vestibulum accumsan a...",
                    fontSize = 14.sp
                )
            }
        }
    }

