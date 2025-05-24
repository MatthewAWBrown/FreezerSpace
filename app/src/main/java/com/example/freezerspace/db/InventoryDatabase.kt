import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [InventoryModel::class], version = 1)
abstract class InventoryDatabase : RoomDatabase() {
    abstract fun inventoryDAO(): InventoryDAO

    companion object {
        @Volatile
        private var INSTANCE: InventoryDatabase? = null

        fun getDatabase(context: Context): InventoryDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    InventoryDatabase::class.java,
                    "inventory_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}