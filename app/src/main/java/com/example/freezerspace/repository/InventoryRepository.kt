package com.example.freezerspace.repository

import InventoryDAO
import InventoryModel
import kotlinx.coroutines.flow.Flow

class InventoryRepository(private val dao: InventoryDAO) {
    val allItems: Flow<List<InventoryModel>> = dao.getAll()

    suspend fun insertItem(item: InventoryModel) {
        dao.insert(item)
    }

    suspend fun deleteItem(item: InventoryModel) {
        dao.delete(item)
    }

    suspend fun updateItem(item: InventoryModel) {
        dao.update(item)
    }
}