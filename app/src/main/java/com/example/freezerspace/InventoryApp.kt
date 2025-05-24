import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun InventoryApp() {
    val navController = rememberNavController()
    val itemList = remember { mutableStateListOf<Item>() }

    NavHost(navController = navController, startDestination = "showInventory") {
        composable("showInventory") {
            ShowInventory(navController, itemList)
        }
        composable("addItem") {
            AddItem(navController, itemList)
        }
    }
}