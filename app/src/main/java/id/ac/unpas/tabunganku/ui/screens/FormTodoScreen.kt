package id.ac.unpas.tabunganku.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.benasher44.uuid.uuid4
import kotlinx.coroutines.launch

@Composable
fun FormTodoScreen() {

    val scope = rememberCoroutineScope()

    val day = remember { mutableStateOf(TextFieldValue("")) }
    val nominal = remember { mutableStateOf(TextFieldValue("")) }
    val dueDate = remember { mutableStateOf(TextFieldValue("")) }
    val description = remember { mutableStateOf(TextFieldValue("")) }

    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()) {

        OutlinedTextField(
            label = { Text(text = "Day") },
            modifier = Modifier.fillMaxWidth(),
            value = day.value, onValueChange = {
                day.value = it
            })

        OutlinedTextField(
            label = { Text(text = "Nominal") },
            modifier = Modifier.fillMaxWidth(),
            value = nominal.value, onValueChange = {
                nominal.value = it
            })

        OutlinedTextField(
            label = { Text(text = "Due Date") },
            modifier = Modifier.fillMaxWidth(),
            value = dueDate.value, onValueChange = {
                dueDate.value = it
            })

        OutlinedTextField(
            label = { Text(text = "Description") },
            modifier = Modifier.fillMaxWidth(),
            value = description.value, onValueChange = {
                description.value = it
            })

        Row {
            Button(modifier = Modifier.weight(5f), onClick = {
                scope.launch {
                    viewModel.upsert(uuid4().toString(), day.value.text, nominal.value.text, dueDate.value.text, description.value.text)
                }
            }) {
                Text(text = "Simpan")
            }

            Button(modifier = Modifier.weight(5f), onClick = {
                day.value = TextFieldValue("")
                nominal.value = TextFieldValue("")
                dueDate.value = TextFieldValue("")
                description.value = TextFieldValue("")
            }) {
                Text(text = "Batal")
            }
        }

        viewModel.isDone.observe(LocalLifecycleOwner.current) {
            if (it) {
                day.value = TextFieldValue("")
                nominal.value = TextFieldValue("")
                dueDate.value = TextFieldValue("")
                description.value = TextFieldValue("")
            }
        }

    }

}