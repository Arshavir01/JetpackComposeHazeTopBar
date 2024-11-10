package com.example.jetpackcomposehazetopbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmed_apps.rental_cars_ui.Car
import com.example.jetpackcomposehazetopbar.ui.theme.JetpackComposeHazeTopBarTheme
import com.example.jetpackcomposehazetopbar.ui.theme.Primary

@Composable
fun CarItem(
    modifier: Modifier = Modifier,
    car: Car
){
    Box (
        modifier = modifier
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(40.dp))
            .background(car.bgColor)
    ) {
        Image(
            painter = painterResource(id = car.image),
            contentDescription = car.name,
            modifier = Modifier.offset(x = 150.dp, y = 0.dp)
        )

        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column {
                CarInfo(car = car)
                Spacer(modifier = Modifier.height(20.dp))
                Rating(car = car)

            }

        }
    }

}

@Composable
fun Rating(
    car: Car,
    modifier: Modifier = Modifier
) {

}

@Composable
fun CarInfo(
    modifier: Modifier = Modifier,
    car: Car
){
    Row(
        modifier = modifier
            .padding(top = 20.dp, start = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = car.logo),
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(100.dp))
                .background(MaterialTheme.colorScheme.background)
                .padding(6.dp)
                .size(35.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Row(verticalAlignment =  Alignment.CenterVertically) {
                Text(
                    text = "Color:",
                    fontSize = 12.sp,
                    color = Color.Black.copy(0.8f)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Box(modifier = Modifier
                    .size(12.dp)
                    .clip(CircleShape)
                    .background(car.color)
                    .border(
                        color = Color.Black,
                        width = 1.dp,
                        shape = CircleShape
                    )
                )

            }

            Text(
                text = car.name,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
        }

    }

}

@Preview
@Composable
private fun HomeCarItemPreview() {
    JetpackComposeHazeTopBarTheme {
        CarItem(
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp),
            car = Car(
                name = "Ferrari SF90 Stradale",
                image = R.drawable.ferrari_car,
                color = Color.Red,
                logo = R.drawable.ferrari_logo,
                recommendation = 97,
                recommendationRate = 4.8f,
                rentalDays = 7,
                price = 759,
                recommenders = listOf(
                    R.drawable.m_2, R.drawable.w_1, R.drawable.w_2
                ),
                bgColor = Primary
            )
        )
    }
}
