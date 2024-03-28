package id.ac.unpas.tabunganku.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import id.ac.unpas.tabunganku.models.Todo
import kotlinx.coroutines.launch

@Composable
fun ListTodoScreen() {

    val scope = rememberCoroutineScope()

    val list: List<Todo>

    Column(modifier = Modifier.fillMaxWidth()) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(list.size) { index ->
                val item = list[index]
                TodoItem(item = item) {
                    scope.launch {
                    }
                }
            }
        }
    }
}