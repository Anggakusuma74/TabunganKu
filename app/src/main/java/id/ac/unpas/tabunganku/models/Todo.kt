package id.ac.unpas.tabunganku.models

data class Todo()

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @PrimaryKey
    val id: String,
    val day: String,
    val Nominal: String,
    val dueDate: String,
    val description: String
)