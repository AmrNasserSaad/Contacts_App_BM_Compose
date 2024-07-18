package com.example.contactsapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contactsapp.data.DataSource
import com.example.contactsapp.model.Contacts
import com.example.contactsapp.ui.theme.ContactsAppTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactsAppTheme {
                // pinned = not collapsed
                val scrollBehavior =
                    TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = stringResource(R.string.contact_app)
                                )
                            },
                            actions = {
                                val context = LocalContext.current
                                IconButton(onClick = {
                                    openDialer(
                                        context,
                                        getString(R.string.home_contact)
                                    )
                                }) {
                                    Icon(
                                        imageVector = Icons.Filled.Home,
                                        contentDescription = stringResource(R.string.home)
                                    )
                                }
                            },
                            scrollBehavior = scrollBehavior,
                        )
                    }
                ) { _ ->
                    ContactsList(contacts = DataSource().getContactsData())
                }
            }
        }
    }
}

@Composable
fun ContactsList(contacts: List<Contacts>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.padding(top = 100.dp)
    ) {
        items(contacts) { contact ->
            ContactsAppListItem(contact = contact)
        }
    }
}

@Composable
fun ContactsAppListItem(contact: Contacts, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = contact.picture),
            contentDescription = "contact photo",
            modifier = modifier
                .size(128.dp)
                .clickable {
                    val phoneNumber = context.getString(contact.phone)
                    openDialer(context, phoneNumber)
                },
            contentScale = ContentScale.Crop
        )
        Text(
            text = stringResource(id = contact.name),
            modifier = modifier
                .fillMaxWidth()
                .clickable {
                    val phoneNumber = context.getString(contact.phone)
                    openDialer(context, phoneNumber)
                },
            textAlign = TextAlign.Center
        )
        SelectionContainer {
            Text(text = stringResource(id = contact.phone))
        }
    }
}

fun openDialer(context: Context, phoneNumber: String) {
    val intent = Intent(Intent.ACTION_DIAL).apply {
        data = Uri.parse("tel:$phoneNumber")
    }
    context.startActivity(intent)
}

@Preview(showBackground = true)
@Composable
private fun ContactsAppPreview() {
    ContactsList(contacts = DataSource().getContactsData())
}
