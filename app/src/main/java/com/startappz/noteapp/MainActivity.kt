package com.startappz.noteapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.startappz.noteapp.model.Note
import com.startappz.noteapp.screen.NoteScreen
import com.startappz.noteapp.screen.NoteViewModel
import com.startappz.noteapp.ui.theme.NoteAppTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.UUID

@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppTheme {
                val noteViewModel by viewModels<NoteViewModel>()

                Surface(color = Color.White) {
                    NotesApp(noteViewModel)

                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalComposeUiApi
@Composable
fun NotesApp(noteViewModel: NoteViewModel) {
    val notesList = noteViewModel.noteList.collectAsState().value

//    NoteScreen(notes = notesList,
//        onRemoveNote = { noteViewModel.removeNote(it) },
//        onAddNote = { noteViewModel.addNote(it) })

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NoteAppTheme {

    }
}