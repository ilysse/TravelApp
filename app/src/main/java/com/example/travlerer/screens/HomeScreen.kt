package com.example.travlerer.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travlerer.R

@Composable
fun HomeScreen(navController: androidx.navigation.NavController) {
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        ProfileAndGreeting()

        SearchBar(searchQuery) { searchQuery = it }


//        CategorySelector()
//
//        FlightBookingForm()
    }
}

@Composable
fun ProfileAndGreeting() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Image(
            painter = painterResource(id = R.drawable.li_menu), // Replace with your profile image
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        // Profile Image
        Image(
            painter = painterResource(id = R.drawable.notification), // Replace with your profile image
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(2.dp)),
            contentScale = ContentScale.Crop
        )
    }
    Row {
        Column {
            Text(
                text = "Good Morning, Shreya...",
                style = TextStyle(fontSize = 16.sp, color = Color.Gray)

            )
            Text(
                text = "Make plan for weekend",
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)

            )
        }
    }
}

@Composable
fun SearchBar(searchQuery: String, onSearchQueryChange: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            placeholder = { Text("Search Places") },
            modifier = Modifier
                .weight(1f)
                .height(50.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.li_search),
                    contentDescription = "Search",
                    tint = Color.Gray,
                    modifier = Modifier.size(24.dp)
                )
            },
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFFE8E8E8),
                focusedBorderColor = Color(0xFF5669FF)
            )
        )

        FilledIconButton(
            onClick = { },
            modifier = Modifier

                .height(48.dp),
            colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = Color(0xFF5669FF)
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.grpp),
                contentDescription = "Filter",
                tint = Color.White,
                modifier = Modifier.size(25.dp)
            )
        }
    }
}






























//@Composable
//fun CategorySelector() {
//    val categories = listOf(
//        Category("Places", Icons.Default.LocationOn),
//        Category("Flights", Icons.Default.PlayArrow),
//        Category("Trains", Icons.Default.Notifications),
//        Category("Buses", Icons.Default.Refresh)
//    )
//
//    LazyRow(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 16.dp)
//    ) {
//        items(categories) { category ->
//            CategoryItem(category = category)
//        }
//    }
//}
//
//@Composable
//fun CategoryItem(category: Category) {
//    Column(
//        modifier = Modifier
//            .padding(horizontal = 8.dp)
//            .clickable { /* Handle category click */ },
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Icon(
//            imageVector = category.icon,
//            contentDescription = category.name,
//            modifier = Modifier
//                .size(40.dp)
//                .background(Color.LightGray, CircleShape)
//                .padding(8.dp),
//            tint = if (category.name == "Flights") Color.Magenta else Color.Gray
//        )
//        Text(
//            text = category.name,
//            style = TextStyle(fontSize = 14.sp, color = Color.Gray),
//            modifier = Modifier.padding(top = 4.dp)
//        )
//    }
//}
//
//@Composable
//fun FlightBookingForm() {
//    var selectedTab by remember { mutableStateOf("One Way") }
//    val tabs = listOf("One Way", "Round Trip", "Multicity")
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 16.dp)
//    ) {
//        // Tabs
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            tabs.forEach { tab ->
//                Text(
//                    text = tab,
//                    style = TextStyle(
//                        fontSize = 16.sp,
//                        fontWeight = if (tab == selectedTab) FontWeight.Bold else FontWeight.Normal,
//                        color = if (tab == selectedTab) Color.Magenta else Color.Gray
//                    ),
//                    modifier = Modifier.clickable { selectedTab = tab }
//                )
//            }
//        }
//
//        // Form Fields
//        Spacer(modifier = Modifier.height(16.dp))
//        OutlinedTextField(
//            value = "",
//            onValueChange = {},
//            label = { Text("Choose Departure from") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            OutlinedTextField(
//                value = "",
//                onValueChange = {},
//                label = { Text("Choose Arrival at") },
//                modifier = Modifier.weight(1f)
//            )
//            IconButton(onClick = { /* Handle switch */ }) {
//                Icon(Icons.Default.Settings, contentDescription = "Switch")
//            }
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        OutlinedTextField(
//            value = "",
//            onValueChange = {},
//            label = { Text("Choose your Date") },
//            trailingIcon = {
//                Icon(Icons.Default.DateRange, contentDescription = "Calendar")
//            },
//            modifier = Modifier.fillMaxWidth()
//        )
//    }
//}
//
//data class Category(val name: String, val icon: ImageVector)
//

