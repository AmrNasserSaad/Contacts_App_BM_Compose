package com.example.contactsapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Contacts(
    @StringRes val name: Int,
    @StringRes val phone: Int,
    @DrawableRes val picture: Int
)