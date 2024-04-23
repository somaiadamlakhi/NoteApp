package com.startappz.noteapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.startappz.noteapp.format
import com.startappz.noteapp.model.Note

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NoteInputText(
    modifier: Modifier = Modifier,
    label: String,
    text: String,
    maxLines: Int = 1,
    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit = {}
) {

    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        value = text,
        onValueChange = onTextChange,
        colors = TextFieldDefaults.colors(
            //setting the text field background when it is focused
            focusedContainerColor = Color.Transparent,

            //setting the text field background when it is unfocused or initial state
            unfocusedContainerColor = Color.White,

            //setting the text field background when it is disabled
            disabledContainerColor = Color.LightGray,
        ),
        maxLines = maxLines,
        label = {
            Text(text = label)
        },
        keyboardActions = KeyboardActions(
            onDone = {
                onImeAction()
                keyboardController?.hide()
            }
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        modifier = modifier
    )
}

@Composable
fun NoteButton(
    modifier: Modifier = Modifier,
    text: String,
    onclick: () -> Unit,
    enabled: Boolean = true
) {

    Button(onClick = onclick, shape = CircleShape, enabled = enabled, modifier = modifier) {
        Text(text = text)
    }
}

@Preview
@Composable
fun NoteInputTextPreview() {
    NoteInputText(label = "", text = "", onTextChange = {})
}

@Composable
fun NoteRow(modifier: Modifier = Modifier, note: Note, onNoteClicked: (Note) -> Unit) {
    Surface(
        modifier = modifier
            .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
            .padding(bottom = 15.dp)
            .fillMaxWidth(),
        color = Color(0xFFDFE6EB),
        shadowElevation = 6.dp
    ) {

        Column(
            modifier = modifier
                .clickable {
                    onNoteClicked(note)
                }
                .padding(horizontal = 14.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = note.title, style = MaterialTheme.typography.titleLarge)
            Text(text = note.description, style = MaterialTheme.typography.titleMedium)
//            Text(text = note.entryDate.format(), style = MaterialTheme.typography.labelSmall)
        }
    }
}