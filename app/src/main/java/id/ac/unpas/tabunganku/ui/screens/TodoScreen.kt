package id.ac.unpas.tabunganku.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TodoScreen() {

    Column(modifier = Modifier.padding(10.dp).fillMaxWidth()) {
        FormTodoScreen()
        ListTodoScreen()
    }
}