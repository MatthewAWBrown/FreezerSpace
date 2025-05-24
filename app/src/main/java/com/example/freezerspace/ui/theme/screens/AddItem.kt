import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController

@Composable
fun AddItem(navController: NavHostController, items: MutableList<Item>) {
    var title by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }

    Column {
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") }
        )
        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Amount") }
        )
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("Add")
        }
    }
}