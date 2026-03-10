package com.example.contactdetails.composable


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.contactdetails.R
import com.example.contactdetails.data.Contact


@Composable
fun ContactDetails(contact: Contact) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactPhoto(contact)

        Spacer(modifier = Modifier.height(16.dp))

        val fullName = if (contact.surname != null) {
            "${contact.name} ${contact.surname}"
        } else {
            contact.name
        }

        Text(
            text = fullName,
            style = MaterialTheme.typography.titleLarge
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = contact.familyName,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            if (contact.isFavorite) {
                Image(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(24.dp),
                    painter = painterResource(id = android.R.drawable.star_big_on),
                    contentDescription = stringResource(R.string.favorite_star)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        InfoRow(
            label = stringResource(R.string.phone),
            value = contact.phone
        )

        Spacer(modifier = Modifier.height(8.dp))

        InfoRow(
            label = stringResource(R.string.address),
            value = contact.address
        )

        if (contact.email != null) {
            Spacer(modifier = Modifier.height(8.dp))
            InfoRow(
                label = stringResource(R.string.email),
                value = contact.email
            )
        }
    }
}