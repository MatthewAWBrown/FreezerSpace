import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.freezerspace.R


@Composable
fun InventoryScreen(
    navController: NavHostController,
    viewModel: InventoryViewModel = viewModel()
) {
    val items by viewModel.allItems.collectAsState()

    @Composable
    fun ShowInventory(navController: NavHostController, items: List<Item>) {
        var items by remember { mutableStateOf(listOf<Pair<String, String>>()) }


        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = { navController.navigate("addItem") }) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = stringResource(R.string.add_item) // use string resource
                    )
                }
            }
        ) { paddingValues ->
            if (items.isEmpty()) {
                EmptyInventoryView(modifier = Modifier.padding(paddingValues)) // Show an empty state
            } else {
                InventoryList(
                    items = items,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                )
            }
        }
    }

    @Composable
    fun InventoryList(
        items: List<InventoryModel>,
        modifier: Modifier = Modifier
    ) {
        LazyColumn(
            modifier = modifier,
            contentPadding = PaddingValues(16.dp)
        ) {
            items(items = items, key = { item -> item.id }) { item ->
                InventoryItemRow(item = item)
                HorizontalDivider()
            }
        }
    }

    @Composable
    fun InventoryItemRow(item: InventoryModel, modifier: Modifier = Modifier) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Amount: ${item.amount}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }

    @Composable
    fun EmptyInventoryView(modifier: Modifier = Modifier) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = androidx.compose.ui.Alignment.Center
        ) {
            Text(stringResource(R.string.no_items_in_inventory))
        }
        Text("+")
    }
}