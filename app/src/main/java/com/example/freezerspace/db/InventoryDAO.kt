import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface InventoryDAO {

    @Query("SELECT * FROM inventory")
    fun getAll(): Flow<List<InventoryModel>>

    @Insert
    suspend fun insert(inventory: InventoryModel)

    @Delete
    suspend fun delete(inventory: InventoryModel)

    @Update
    suspend fun update(inventory: InventoryModel)
}