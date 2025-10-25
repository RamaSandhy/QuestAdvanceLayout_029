package com.example.praktikum2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen( modifier: Modifier = Modifier,
                   onPrivacy: () -> Unit = {},
                   onHistory: () -> Unit = {},
                   onSettings: () -> Unit = {}
) {
    val bgTop = Color(0xFF0E1116)
    val bgBottom = Color(0xFF1A1F26)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(listOf(bgTop, bgBottom))
            )
            .padding(horizontal = 20.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(top = 24.dp, bottom = 16.dp)
        ) {
            // Avatar
            Avatar(
                modifier = Modifier
                    .size(96.dp)
                    .shadow(16.dp, CircleShape, clip = true)
            )
            Spacer(Modifier.height(12.dp))

            // Row medsos (ikon bulat kecil)
            SocialRow()

            Spacer(Modifier.height(12.dp))

            // Nama, handle, tagline
            Text(
                text = "Rama Sandhy Muhammad",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "rshandy07@gmail.com",
                color = Color(0xFFB8C0CC),
                fontSize = 13.sp
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Saya Adalah App Developer",
                color = Color(0xFFE4E7EC),
                fontSize = 14.sp
            )

            Spacer(Modifier.height(24.dp))

            SettingCard(
                title = "Privacy",
                subtitle = null,
                leading = {
                    Icon(
                        Icons.Filled.Security,
                        contentDescription = null,
                        tint = Color(0xFF7CD6F9),
                        modifier = Modifier.size(22.dp)
                    )
                },
                onClick = onPrivacy
            )
            Spacer(Modifier.height(12.dp))
            SettingCard(
                title = "Riwayat Transaksi",
                subtitle = null,
                leading = {
                    Icon(
                        Icons.Filled.History,
                        contentDescription = null,
                        tint = Color(0xFF9BA8FF),
                        modifier = Modifier.size(22.dp)
                    )
                },
                onClick = onHistory
            )
            Spacer(Modifier.weight(1f))

            Text(
                text = "© 2025 Rama Sandhy Muhammad",
                color = Color(0xFF8C96A6),
                fontSize = 12.sp
            )
        }
    }
}
@Composable
private fun Avatar(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.rama),
            contentDescription = "Foto Profil",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(3.dp, Color.White, CircleShape),
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopCenter
        )
    }
}
@Composable
private fun SocialRow() {
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        SocialDot("f", bg = Color(0xFF1877F2)) {}
        SocialDot("G+", bg = Color(0xFFDB4437)) {}
        SocialDot("t", bg = Color(0x03A9F4)) {}
        SocialDot("in", bg = Color(0xFF0A66C2)) {}
    }
}

@Composable
private fun SocialDot(text: String, bg: Color, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(36.dp)
            .clip(CircleShape)
            .background(bg.copy(alpha = 0.95f))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(text, color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
    }
}
@Composable
private fun SettingCard(
    title: String,
    subtitle: String? = null,
    leading: @Composable () -> Unit,
    onClick: () -> Unit
) {
    val cardColor = Color(0x33FFFFFF)
    val surface = Color(0x22FFFFFF)

    Surface(
        color = cardColor,
        shape = RoundedCornerShape(16.dp),
        tonalElevation = 0.dp,
        shadowElevation = 0.dp,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 64.dp)
            .clickable { onClick() }
    ) {
