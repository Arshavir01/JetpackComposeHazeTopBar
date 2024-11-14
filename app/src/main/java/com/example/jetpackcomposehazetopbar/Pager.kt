package com.example.jetpackcomposehazetopbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposehazetopbar.ui.theme.Secondary

@Composable
fun Pager(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.background(color = colorResource(id = R.color.white))) {
        Spacer(modifier = modifier.height(10.dp))
        Text(
            text = "Luxurious\nRental Cars",
            fontSize = 25.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            lineHeight = 40.sp,
            modifier = Modifier.padding(horizontal = 22.dp)
        )

        Spacer(modifier = modifier.height(10.dp))

        Row {
            Text(
                text = "Luxurious",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )

            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "VIP Cars",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "New",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    modifier = Modifier
                        .alpha(0.7f)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Secondary)
                        .padding(horizontal = 5.dp)
                )
            }
        }

        Spacer(modifier = modifier.height(10.dp))

        Row (
            verticalAlignment = Alignment.Bottom
        ) {
            HorizontalDivider(
                modifier = Modifier.weight(1f),
                thickness = 2.dp,
                color = colorResource(id = R.color.black)
            )

            HorizontalDivider(
                modifier = Modifier.weight(1f),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

    }

}