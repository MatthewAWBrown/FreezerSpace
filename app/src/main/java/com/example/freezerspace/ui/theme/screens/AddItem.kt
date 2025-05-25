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

<<<<<<< HEAD

@Composable
fun AddItem(navController: NavHostController, items: MutableList<InventoryModel>) {
=======
@Composable
fun AddItem(navController: NavHostController, items: MutableList<Item>) {
>>>>>>> d0ea989ac7405d53fd8765576aad1aa62e1135fb
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
<<<<<<< HEAD
            val newItem = InventoryModel(title = title, amount = amount.toIntOrNull() ?:0)
            items.add(newItem)
=======
>>>>>>> d0ea989ac7405d53fd8765576aad1aa62e1135fb
            navController.popBackStack()
        }) {
            Text("Add")
        }
    }
}