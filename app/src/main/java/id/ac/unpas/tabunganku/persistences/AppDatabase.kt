package id.ac.unpas.tabunganku.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.unpas.tabunganku.models.Todo


@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object {
        const val DATABASE_NAME = "tabunganku-database"
    }
}