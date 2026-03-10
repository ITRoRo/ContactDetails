package com.example.contactdetails.composable


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactdetails.R
import com.example.contactdetails.data.Contact



@Composable
fun ContactPhoto(contact: Contact) {
    if (contact.imageRes != null) {
        Image(
            modifier = Modifier.size(120.dp),
            painter = painterResource(id = contact.imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    } else {
        RoundInitials(contact = contact)
    }
}

@Composable
fun RoundInitials(contact: Contact) {
    val initials = contact.name.take(1) + contact.familyName.take(1)

    Box(
        modifier = Modifier.size(120.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.circle),
            contentDescription = null,
            tint = Color.Gray
        )
        Text(
            text = initials,
            style = TextStyle(
                color = Color.White,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}
