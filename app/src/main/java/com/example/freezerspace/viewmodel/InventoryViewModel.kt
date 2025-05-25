import com.example.freezerspace.repository.InventoryRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class InventoryViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = InventoryDatabase.getDatabase(application).inventoryDAO()
    private val repository = InventoryRepository(dao)

    // Expose the Flow as StateFlow for Compose to observe
    val allItems: StateFlow<List<InventoryModel>> = repository.allItems
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList<InventoryModel>()
        )

    fun addItem(item: InventoryModel) {
        viewModelScope.launch {
            dao.insert(item)
        }
    }
}