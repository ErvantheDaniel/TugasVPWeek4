package com.example.tugasvpweek4

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val BgColor = Color(0xFFF5F0EE)
val Orange = Color(0xFFFF5A36)
val OrangeSoft = Color(0xFFFFEFEA)
val Ink = Color(0xFF111827)
val Muted = Color(0xFF9CA3AF)

data class Car(
    val name: String,
    val image: Int,
    val fuel: String,
    val transmission: String,
    val year: String,
    val mileage: String,
    val location: String,
    val price: String,
    val description: String
)

val carList = listOf(
    Car(
        "Daihatsu Ayla", R.drawable.ayla, "Petrol", "Manual", "2020", "45,000 km",
        "Jakarta", "Rp 105.000.000",
        "A compact and fuel-efficient city car that is cheap to own and easy to park anywhere."
    ),
    Car(
        "Honda CRV", R.drawable.crv, "Petrol", "Auto", "2013", "15,200 km",
        "Bali", "Rp 195.000.000",
        "A reliable and comfortable family SUV with a smooth engine and generous cargo space."
    ),
    Car(
        "Honda HR-V", R.drawable.hrv, "Petrol", "Auto", "2020", "38,000 km",
        "Yogyakarta", "Rp 290.000.000",
        "A sporty crossover with a flexible cabin, responsive handling, and great fuel economy."
    ),
    Car(
        "Jaecoo J5", R.drawable.j5, "EV", "Auto", "2024", "8,000 km",
        "Surabaya", "Rp 400.000.000",
        "A modern electric SUV with a bold design, quiet ride, and a feature-packed digital cabin."
    ),
    Car(
        "MG 4", R.drawable.mg4, "EV", "Auto", "2023", "14,500 km",
        "Bandung", "Rp 420.000.000",
        "A fun-to-drive electric hatchback with sharp handling, fast charging, and a long driving range."
    ),
    Car(
        "Toyota Kijang Innova Reborn", R.drawable.reborn, "Diesel", "Manual", "2019", "82,000 km",
        "Semarang", "Rp 340.000.000",
        "The legendary family MPV with a strong diesel engine, a roomy 7-seat cabin, and a comfortable ride."
    ),
    Car(
        "Chery Tiggo 9 CSH", R.drawable.tiggo, "PHEV", "Auto", "2024", "5,000 km",
        "Jakarta", "Rp 640.000.000",
        "A plug-in hybrid SUV with a spacious three-row cabin, long electric range, and driver assistance features."
    ),
    Car(
        "Daihatsu Xenia", R.drawable.xenia, "Petrol", "Manual", "2022", "28,000 km",
        "Bandung", "Rp 210.000.000",
        "A practical 7-seater MPV that is easy to drive and perfect for family trips."
    ),
    Car(
        "Toyota Yaris", R.drawable.yaris, "Petrol", "Auto", "2021", "52,400 km",
        "Semarang", "Rp 245.000.000",
        "The Toyota Yaris G AT is a sporty compact hatchback that punches above its weight class. " +
                "Equipped with a 1.5L dual VVT-i engine, 7 airbags, pre-collision system, " +
                "and a floating head unit, it offers premium features at a very accessible price point."
    ),
    Car(
        "Toyota Yaris Cross", R.drawable.yariscross, "Hybrid", "Auto", "2024", "30,500 km",
        "Surabaya", "Rp 430.000.000",
        "A compact crossover with an efficient hybrid engine and high ground clearance."
    )
)

@Composable
fun Soal1View() {
    val favorites = remember { mutableStateListOf(true, false, true, false, true, false, false, true, false, true) }

    var selectedIndex by remember { mutableStateOf(-1) }

    if (selectedIndex == -1) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BgColor)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            //Header
            Box(
                modifier = Modifier
                    .width(28.dp)
                    .height(3.dp)
                    .background(Orange)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "On Sale",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Ink
                    )
                    Text(
                        text = "Find your perfect ride",
                        fontSize = 12.sp,
                        color = Muted
                    )
                }

                Text(
                    text = "♥ ${favorites.count { it }} saved",
                    fontSize = 10.sp,
                    color = Orange,
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .background(OrangeSoft)
                        .border(1.dp, Orange, RoundedCornerShape(50))
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            //List Card
            carList.forEachIndexed { index, car ->
                CarCard(
                    car = car,
                    isFavorite = favorites[index],
                    onClick = { selectedIndex = index },
                    onFavoriteClick = { favorites[index] = !favorites[index] }
                )
                Spacer(modifier = Modifier.height(14.dp))
            }
        }
    } else {
        //Halaman Detail
        CarDetail(
            car = carList[selectedIndex],
            isFavorite = favorites[selectedIndex],
            onBack = { selectedIndex = -1 },
            onFavoriteClick = { favorites[selectedIndex] = !favorites[selectedIndex] }
        )
    }
}

@Composable
fun CarCard(
    car: Car,
    isFavorite: Boolean,
    onClick: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.size(width = 120.dp, height = 100.dp)) {
                Image(
                    painter = painterResource(id = car.image),
                    contentDescription = car.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(12.dp))
                )
                FuelBadge(
                    fuel = car.fuel,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(6.dp)
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            //Info mobil
            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(100.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = car.name,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Ink
                    )
                    HeartIcon(
                        isFavorite = isFavorite,
                        onClick = onFavoriteClick,
                        size = 22.dp
                    )
                }

                Text(
                    text = car.transmission,
                    fontSize = 10.sp,
                    color = Color.Gray,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFF1EDEB))
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(6.dp)
                                .clip(CircleShape)
                                .background(Orange)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = car.year,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Ink
                        )
                    }
                    Text(
                        text = car.mileage,
                        fontSize = 11.sp,
                        color = Muted
                    )
                }
            }
        }
    }
}

@Composable
fun HeartIcon(
    isFavorite: Boolean,
    onClick: () -> Unit,
    size: Dp = 22.dp
) {
    if (isFavorite) {
        Image(
            painter = painterResource(id = R.drawable.heartfilled),
            contentDescription = "Favorite",
            modifier = Modifier
                .size(size)
                .clickable { onClick() }
        )
    } else {
        Image(
            painter = painterResource(id = R.drawable.heartoutline),
            contentDescription = "Not Favorite",
            modifier = Modifier
                .size(size)
                .clickable { onClick() }
        )
    }
}

@Composable
fun FuelBadge(
    fuel: String,
    modifier: Modifier = Modifier
) {
    var bgColor = Color(0xFFFFF0D9)
    var textColor = Color(0xFFF08A00)

    if (fuel == "PHEV") {
        bgColor = Color(0xFFEDE7FB)
        textColor = Color(0xFF6D3FC4)
    } else if (fuel == "Hybrid") {
        bgColor = Color(0xFFDDF3EF)
        textColor = Color(0xFF0F766E)
    }

    Text(
        text = fuel.uppercase(),
        fontSize = 8.sp,
        fontWeight = FontWeight.ExtraBold,
        color = textColor,
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(bgColor)
            .padding(horizontal = 8.dp, vertical = 5.dp)
    )
}

//Halaman Detail
@Composable
fun CarDetail(
    car: Car,
    isFavorite: Boolean,
    onBack: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BgColor)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = car.image),
                    contentDescription = car.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )
                //Tombol back
                Box(
                    modifier = Modifier
                        .statusBarsPadding()
                        .padding(start = 16.dp, top = 30.dp)
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .clickable { onBack() },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.backbutton),
                        contentDescription = "Back",
                        modifier = Modifier.size(20.dp)
                    )
                }

                FuelBadge(
                    fuel = car.fuel,
                    modifier = Modifier.padding(start = 12.dp, top = 244.dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 272.dp)
                        .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                        .background(BgColor)
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = car.name,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Ink
                        )
                        HeartIcon(
                            isFavorite = isFavorite,
                            onClick = onFavoriteClick
                        )
                    }

                    Text(
                        text = "• ${car.location}",
                        fontSize = 11.sp,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Text(
                        text = car.price,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = Orange,
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(OrangeSoft)
                            .border(1.dp, Orange, RoundedCornerShape(10.dp))
                            .padding(horizontal = 12.dp, vertical = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(text = "SPECIFICATIONS", fontSize = 9.sp, color = Muted)

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        SpecCard("YEAR", car.year, Modifier.weight(1f))
                        SpecCard("MILEAGE", car.mileage, Modifier.weight(1f))
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        SpecCard("TRANSMISSION", car.transmission, Modifier.weight(1f))
                        SpecCard("FUEL TYPE", car.fuel, Modifier.weight(1f))
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(text = "ABOUT THIS CAR", fontSize = 9.sp, color = Muted)

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = car.description,
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        color = Color.Gray
                    )
                }
            }
        }

        //Bottom bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(46.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(OrangeSoft)
                    .border(1.dp, Orange, RoundedCornerShape(14.dp))
                    .clickable { onFavoriteClick() },
                contentAlignment = Alignment.Center
            ) {
                HeartIcon(
                    isFavorite = isFavorite,
                    onClick = onFavoriteClick
                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(46.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(Orange),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Contact Seller",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}

//Card spesifikasi
@Composable
fun SpecCard(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(text = label, fontSize = 8.sp, color = Muted)
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = value,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Ink
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Soal1Preview() {
    Soal1View()
}