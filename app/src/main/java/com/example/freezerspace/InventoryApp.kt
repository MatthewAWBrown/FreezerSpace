import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun InventoryApp() {
    val navController = rememberNavController()
    //val itemList = remember { mutableStateListOf<InventoryModel>() }
    val inventoryViewModel: InventoryViewModel = viewModel()
    InventoryScreen(navController, inventoryViewModel)
}