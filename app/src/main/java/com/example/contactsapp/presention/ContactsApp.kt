package com.example.contactsapp.presention

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
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
                .size(150.dp)
                .clickable {
                    val phoneNumber = context.getString(contact.phone)
                    openDialer(context, phoneNumber)
                },

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