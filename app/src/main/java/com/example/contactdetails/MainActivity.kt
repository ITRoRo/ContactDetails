package com.example.contactdetails

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.contactdetails.composable.ContactDetails
import com.example.contactdetails.data.Contact
import com.example.contactdetails.ui.theme.ContactDetailsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactDetails(
                contact = Contact(
                    name = "Евгений",
                    surname = "Андреевич",
                    familyName = "Лукашин",
                    imageRes = null,
                    isFavorite = true,
                    phone = "+7 495 495 95 95",
                    address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12",
                    email = "ELukashin@practicum.ru"
                )
            )
        }
    }

    @Preview(name = "Favorite without photo", showSystemUi = true)
    @Composable
    fun ContactDetailsFavoritePreview() {
        ContactDetails(
            contact = Contact(
                name = "Евгений",
                surname = "Андреевич",
                familyName = "Лукашин",
                imageRes = null,
                isFavorite = true,
                phone = "+7 495 495 95 95",
                address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12",
                email = "ELukashin@practicum.ru"
            )
        )
    }

    @Preview(name = "With photo no email", showSystemUi = true)
    @Composable
    fun ContactDetailsWithPhotoPreview() {
        ContactDetails(
            contact = Contact(
                name = "Яндекс",
                surname = null,
                familyName = "Практикович",
                imageRes = R.drawable.phone,
                isFavorite = false,
                phone = " --- ",
                address = "Ивановская область, дер. Крутово, д. 4",
                email = null
            )
        )
    }
}