package com.example.tugasvpweek4

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Warna
val RosterBg = Color(0xFF0B0B14)
val RosterCard = Color(0xFF14141F)
val RosterLine = Color(0xFF26263A)
val RosterText = Color(0xFFFFFFFF)
val RosterGray = Color(0xFF8A8AA3)
val Amber = Color(0xFFFFB800)
val HpColor = Color(0xFFFF3B5C)
val MpColor = Color(0xFF2F80ED)
val GreenColor = Color(0xFF22C55E)

data class Hero(
    val name: String,
    val image: Int,
    val rarity: String,
    val heroClass: String,
    val classColor: Color,
    val borderColor: Color,
    val cp: Int,
    val level: Int,
    val hp: Int,
    val maxHp: Int,
    val mp: Int,
    val maxMp: Int,
    val atk: Int,
    val def: Int,
    val crit: String,
    val spd: Int,
    val skillName: String,
    val skillDesc: String,
    val inSquad: Boolean
)

val heroList = listOf(
    Hero(
        "Alistair", R.drawable.paladin, "MYTHIC", "High Templar",
        Amber, Amber, 5600, 50, 1650, 1800, 650, 800, 380, 540, "22%", 105,
        "Wrath of the Heavens",
        "Calls down a celestial hammer, stunning all enemies for 3 seconds and taunting survivors.",
        false
    ),
    Hero(
        "Theresa", R.drawable.cleric, "MYTHIC", "Divine Oracle",
        GreenColor, GreenColor, 5480, 49, 1100, 1200, 2100, 2400, 210, 320, "12%", 98,
        "Divine Blessing",
        "Heals all allies for 30% of max HP and removes every negative effect.",
        false
    ),
    Hero(
        "Vespera", R.drawable.rogue, "MYTHIC", "Shadowblade",
        Color(0xFFD946EF), Color(0xFFD946EF), 5350, 48, 890, 950, 410, 600, 460, 240, "35%", 140,
        "Shadow Strike",
        "Teleports behind the target and strikes for triple damage from the shadows.",
        false
    ),
    Hero(
        "Elaria", R.drawable.archmage, "MYTHIC", "Archmage",
        Color(0xFF22D3EE), Color(0xFF22D3EE), 5120, 47, 450, 600, 1850, 2000, 520, 150, "18%", 110,
        "Arcane Storm",
        "Summons a storm of arcane energy that hits every enemy for massive magic damage.",
        true
    ),
    Hero(
        "Garrick", R.drawable.berserker, "LEGENDARY", "Berserker",
        Color(0xFFFF6B3D), Color(0xFFFF4D8D), 4980, 46, 1500, 1700, 120, 300, 540, 280, "28%", 95,
        "Blood Rage",
        "Sacrifices 10% of max HP to double attack power for 5 seconds.",
        false
    )
)

val filterList = listOf(
    "All (14)",
    "Berserker (2)",
    "Archmage (3)",
    "High Templar (2)",
    "Divine Oracle (3)",
    "Shadowblade (4)"
)

@Composable
fun Soal2View() {
    var selectedFilter by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(RosterBg)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        //Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Party Roster",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = RosterText
                )
                Text(
                    text = "Guild Vanguard • 14 Heroes Available",
                    fontSize = 11.sp,
                    color = RosterGray
                )
            }

            Text(
                text = "★ Expedition",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Amber,
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(Amber.copy(alpha = 0.12f))
                    .border(1.dp, Amber, RoundedCornerShape(50))
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        //Expedition Squad
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A2E)),
            border = BorderStroke(1.dp, Color(0xFF4A3A5A))
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "● EXPEDITION SQUAD (3/4)",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = RosterGray
                    )
                    Text(
                        text = "⚔ 14750 CP",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = Amber
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SquadSlot(R.drawable.berserker, Color(0xFFFF4D8D))
                    Spacer(modifier = Modifier.width(8.dp))
                    SquadSlot(R.drawable.archmage, Color(0xFF22D3EE))
                    Spacer(modifier = Modifier.width(8.dp))
                    SquadSlot(R.drawable.paladin, Amber)
                    Spacer(modifier = Modifier.width(8.dp))

                    //Slot kosong
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(RosterCard)
                            .border(1.dp, RosterLine, RoundedCornerShape(10.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "+", fontSize = 18.sp, color = RosterGray)
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Box(
                        modifier = Modifier
                            .width(96.dp)
                            .height(44.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Amber)
                            .clickable { },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Deploy ⚡",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Black
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(RosterCard)
                .border(1.dp, RosterLine, RoundedCornerShape(12.dp))
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "🔍", fontSize = 13.sp)
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Search by hero name, class, or rarity...",
                fontSize = 12.sp,
                color = RosterGray
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .horizontalScroll(rememberScrollState())
            ) {
                filterList.forEachIndexed { index, filter ->
                    FilterChip(
                        text = filter,
                        isSelected = selectedFilter == index,
                        onClick = { selectedFilter = index }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }

            Text(
                text = "Sort: Power",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Amber,
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(Color(0xFF2A2210))
                    .border(1.dp, Amber, RoundedCornerShape(50))
                    .padding(horizontal = 10.dp, vertical = 6.dp)
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        //List Hero
        heroList.forEach { hero ->
            HeroCard(hero = hero)
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun SquadSlot(image: Int, borderColor: Color) {
    Image(
        painter = painterResource(id = image),
        contentDescription = "Squad",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(48.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(2.dp, borderColor, RoundedCornerShape(10.dp))
    )
}

@Composable
fun FilterChip(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    var bgColor = RosterCard
    var borderColor = RosterLine
    var textColor = RosterGray

    if (isSelected) {
        bgColor = Color(0xFF2A2210)
        borderColor = Amber
        textColor = Amber
    }

    Text(
        text = text,
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        color = textColor,
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(bgColor)
            .border(1.dp, borderColor, RoundedCornerShape(50))
            .clickable { onClick() }
            .padding(horizontal = 12.dp, vertical = 7.dp)
    )
}

//Card Component
@Composable
fun HeroCard(hero: Hero) {
    var expanded by remember { mutableStateOf(false) }

    var cardBorder = RosterLine
    if (hero.inSquad) {
        cardBorder = Amber
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = RosterCard),
        border = BorderStroke(1.dp, cardBorder)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    HeroTag(
                        text = hero.rarity,
                        color = if (hero.rarity == "MYTHIC") HpColor else Color(0xFFFF8A00)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    HeroTag(text = hero.heroClass, color = hero.classColor)
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "⚔ ${hero.cp} CP",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Amber
                    )
                    if (hero.inSquad) {
                        Spacer(modifier = Modifier.width(6.dp))
                        HeroTag(text = "IN SQUAD", color = Amber)
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.size(64.dp)) {
                    Image(
                        painter = painterResource(id = hero.image),
                        contentDescription = hero.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(10.dp))
                            .border(1.dp, hero.borderColor, RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = "Lvl ${hero.level}",
                        fontSize = 8.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(3.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color(0xCC000000))
                            .padding(horizontal = 4.dp, vertical = 2.dp)
                    )
                }

                Spacer(modifier = Modifier.width(14.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = hero.name,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = RosterText
                        )
                        Text(
                            text = if (expanded) "▲" else "▼",
                            fontSize = 10.sp,
                            color = RosterGray
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    StatBar("HP", hero.hp, hero.maxHp, HpColor)

                    Spacer(modifier = Modifier.height(5.dp))

                    StatBar("MP", hero.mp, hero.maxMp, MpColor)
                }
            }

            //Dropdown
            if (expanded) {
                Spacer(modifier = Modifier.height(12.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(RosterLine)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    StatBox("ATK", "${hero.atk}", HpColor, Modifier.weight(1f))
                    StatBox("DEF", "${hero.def}", Color(0xFFFF8A00), Modifier.weight(1f))
                    StatBox("CRIT", hero.crit, Amber, Modifier.weight(1f))
                    StatBox("SPD", "${hero.spd}", Color(0xFF22D3EE), Modifier.weight(1f))
                }

                Spacer(modifier = Modifier.height(10.dp))

                //Skill
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFF1A1A2E))
                        .border(1.dp, RosterLine, RoundedCornerShape(10.dp))
                        .padding(10.dp)
                ) {
                    Text(
                        text = "★ ${hero.skillName}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Amber
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = hero.skillDesc,
                        fontSize = 10.sp,
                        lineHeight = 14.sp,
                        color = RosterGray
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(38.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFF0F2A22))
                            .border(1.dp, GreenColor, RoundedCornerShape(10.dp))
                            .clickable { },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Heal (+250 HP)",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = GreenColor
                        )
                    }

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(38.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFF2A2210))
                            .border(1.dp, Amber, RoundedCornerShape(10.dp))
                            .clickable { },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "⚔ Add to Squad",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Amber
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HeroTag(text: String, color: Color) {
    Text(
        text = text,
        fontSize = 9.sp,
        fontWeight = FontWeight.Bold,
        color = color,
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(color.copy(alpha = 0.15f))
            .border(1.dp, color.copy(alpha = 0.6f), RoundedCornerShape(4.dp))
            .padding(horizontal = 6.dp, vertical = 2.dp)
    )
}

@Composable
fun StatBar(
    label: String,
    value: Int,
    maxValue: Int,
    color: Color
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = label,
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold,
            color = RosterGray,
            modifier = Modifier.width(22.dp)
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .height(7.dp)
                .clip(RoundedCornerShape(50))
                .background(RosterBg)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(value.toFloat() / maxValue.toFloat())
                    .height(7.dp)
                    .clip(RoundedCornerShape(50))
                    .background(color)
            )
        }

        Text(
            text = "$value / $maxValue",
            fontSize = 9.sp,
            color = RosterGray,
            textAlign = TextAlign.End,
            modifier = Modifier.width(62.dp)
        )
    }
}

@Composable
fun StatBox(
    label: String,
    value: String,
    labelColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF1A1A2E))
            .border(1.dp, RosterLine, RoundedCornerShape(8.dp))
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            fontSize = 8.sp,
            fontWeight = FontWeight.ExtraBold,
            color = labelColor
        )
        Spacer(modifier = Modifier.height(3.dp))
        Text(
            text = value,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            color = RosterText
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Soal2Preview() {
    Soal2View()
}