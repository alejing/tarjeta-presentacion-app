package com.example.tarjetapresentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarjetapresentacion.ui.theme.TarjetaPresentacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Permite que el contenido ocupe todo el espacio de la pantalla
        setContent {
            // Se aplica el tema de la aplicación
            TarjetaPresentacionTheme {
                // Se llama al composable principal de la aplicación
                PresentationCard()
            }
        }
    }
}

// Composable que representa la cabecera del perfil del desarrollador
@Composable
fun ProfileHeader() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp) // Espacio entre elementos
    ) {
        // Caja circular que contiene la imagen de perfil
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(
                    color = Color(0xFF073042), // Color de fondo del círculo
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            // Imagen del desarrollador, recortada en forma circular
            Image(
                painter = painterResource(id = R.drawable.my_pic),
                contentDescription = stringResource(R.string.dev_pic),
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape), // Recorta la imagen en forma circular
                contentScale = ContentScale.Crop // Ajusta el contenido para llenar el área
            )
        }

        Spacer(modifier = Modifier.height(8.dp)) // Espaciador

        // Nombre del desarrollador
        Text(
            text = stringResource(R.string.dev_name),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        // Título o cargo del desarrollador
        Text(
            text = stringResource(R.string.dev_title),
            fontSize = 16.sp,
            color = Color(0xFF3ddc84),
            fontWeight = FontWeight.Medium
        )
    }
}

// Vista previa del encabezado de perfil
@Preview(showBackground = true)
@Composable
fun ProfileHeaderPreview() {
    ProfileHeader()
}

// Composable que representa un solo elemento de contacto (icono + texto)
@Composable
fun ContactElement(
    icon: ImageVector, // Ícono a mostrar
    text: String       // Texto del contacto
) {
    Row(
        modifier = Modifier
            .fillMaxWidth() // Ocupar todo el ancho disponible
            .background(
                color = Color(0xFF27363d),
                shape = RoundedCornerShape(8.dp) // Bordes redondeados
            )
            .padding(horizontal = 16.dp, vertical = 12.dp), // Espaciado interno
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        // Ícono del medio de contacto
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF3ddc84),
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(16.dp)) // Espaciador entre ícono y texto

        // Texto del medio de contacto
        Text(
            text = text,
            color = Color.White,
            fontSize = 14.sp
        )
    }
}

// Vista previa de un elemento de contacto individual
@Preview(showBackground = true)
@Composable
fun ContactElementPreview() {
    ContactElement(
        icon = Icons.Default.Email,
        text = "ejemplo@email.com"
    )
}

// Composable que agrupa todos los medios de contacto
@Composable
fun ContactInfo() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp) // Espaciado entre elementos
    ) {
        // Teléfono
        ContactElement(
            icon = Icons.Default.Phone,
            text = stringResource(R.string.dev_phone)
        )

        // Redes sociales o enlace compartido
        ContactElement(
            icon = Icons.Default.Share,
            text = stringResource(R.string.dev_social)
        )

        // Correo electrónico
        ContactElement(
            icon = Icons.Default.Email,
            text = stringResource(R.string.dev_mail)
        )
    }
}

// Vista previa de toda la sección de información de contacto
@Preview(showBackground = true)
@Composable
fun ContactInfoPreview() {
    ContactInfo()
}

// Composable principal que une encabezado y contactos
@Composable
fun PresentationCard() {
    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupar todo el alto y ancho de la pantalla
            .background(Color(0xFF073042)) // Color de fondo general
            .padding(16.dp), // Espaciado del borde
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Muestra la cabecera del perfil
        ProfileHeader()

        Spacer(modifier = Modifier.height(32.dp)) // Espacio entre secciones

        // Muestra la información de contacto
        ContactInfo()
    }
}

// Vista previa de toda la tarjeta de presentación
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PresentationCardPreview() {
    PresentationCard()
}