import androidx.room.*

@Dao
interface InventoryDAO {

    @Query("SELECT * FROM inventory")
    suspend fun getAll(): List<InventoryModel>

    @Insert
    suspend fun insert(inventory: InventoryModel)

    @Delete
    suspend fun delete(inventory: InventoryModel)

    @Update
    suspend fun update(inventory: InventoryModel)
}