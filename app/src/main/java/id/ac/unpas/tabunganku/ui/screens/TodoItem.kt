package id.ac.unpas.tabunganku.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import id.ac.unpas.tabunganku.models.Todo

@Composable
fun TodoItem(item: Todo, onDeleteClick: (String) -> Unit) {
    Row {
        Text(modifier = Modifier.weight(3f), text = item.day)
        Text(modifier = Modifier.weight(3f), text = item.nominal)
        Text(modifier = Modifier.weight(3f), text = item.dueDate)
        Text(modifier = Modifier.weight(3f), text = item.description)
        Button(modifier = Modifier.weight(3f), onClick = { onDeleteClick(item.id) }) {
            Text(text = "Delete")
        }
    }
}