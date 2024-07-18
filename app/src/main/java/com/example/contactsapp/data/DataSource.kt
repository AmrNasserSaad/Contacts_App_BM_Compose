package com.example.contactsapp.data

import com.example.contactsapp.R
import com.example.contactsapp.model.Contacts

class DataSource {

    fun getContactsData(): List<Contacts> {
        val contact = mutableListOf<Contacts>()

        contact.add(
            Contacts(
                R.string.auntie,
                R.string.auntie_phone,
                R.drawable.aed,
                )
        )
        contact.add(
            Contacts(
                R.string.brother,
                R.string.brother_phone,
                R.drawable.aq,
                )
        )
        contact.add(
            Contacts(
                R.string.daughter,
                R.string.daughter_phone,
                R.drawable.awd,
                )
        )
        contact.add(
            Contacts(
                R.string.father,
                R.string.father_phone,
                R.drawable.d,
                )
        )
        contact.add(
            Contacts(
                R.string.grandfather,
                R.string.grandfather_phone,
                R.drawable.e,
                )
        )
        contact.add(
            Contacts(
                R.string.grandmother,
                R.string.grandmother_phone,
                R.drawable.er,
                )
        )
        contact.add(
            Contacts(
                R.string.sister,
                R.string.sister_phone,
                R.drawable.er,
                )
        )
        contact.add(
            Contacts(
                R.string.son,
                R.string.son_phone,
                R.drawable.aed,
                )
        )
        contact.add(
            Contacts(
                R.string.uncle,
                R.string.uncle_phone,
                R.drawable.awd,
                )
        )
        contact.add(
            Contacts(
                R.string.auntie,
                R.string.auntie_phone,
                R.drawable.aed,
                )
        )
        contact.add(
            Contacts(
                R.string.auntie,
                R.string.auntie_phone,
                R.drawable.aed,
                )
        )
        contact.add(
            Contacts(
                R.string.auntie,
                R.string.auntie_phone,
                R.drawable.aed,
                )
        )
        contact.add(
            Contacts(
                R.string.auntie,
                R.string.auntie_phone,
                R.drawable.aed,
                )
        )
        contact.add(
            Contacts(
                R.string.auntie,
                R.string.auntie_phone,
                R.drawable.aed,
                )
        )

        return contact
    }
}