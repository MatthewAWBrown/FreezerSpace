import androidx.room.*
<<<<<<< HEAD
import kotlinx.coroutines.flow.Flow
=======
>>>>>>> d0ea989ac7405d53fd8765576aad1aa62e1135fb

@Dao
interface InventoryDAO {

    @Query("SELECT * FROM inventory")
<<<<<<< HEAD
    fun getAll(): Flow<List<InventoryModel>>
=======
    suspend fun getAll(): List<InventoryModel>
>>>>>>> d0ea989ac7405d53fd8765576aad1aa62e1135fb

    @Insert
    suspend fun insert(inventory: InventoryModel)

    @Delete
    suspend fun delete(inventory: InventoryModel)

    @Update
    suspend fun update(inventory: InventoryModel)
}