import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ShowInventory(navController: NavHostController, items: List<Item>) {
    var items by remember { mutableStateOf(listOf<Pair<String, String>>()) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("addItem") }) {
                Text("+")
            }
        }
    ) { paddingValues ->
        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp)
        ){
            items(items) { item ->
                Text("${item.first}: ${item.second}")
            }
        }
    }
}