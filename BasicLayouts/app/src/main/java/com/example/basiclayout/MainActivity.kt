package com.example.basiclayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiclayout.ui.theme.BasicLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicLayoutTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        HomeScreen()
                    }
                }
            }
        }
    }
}
private val alignYourBodyData = listOf(
    R.drawable.ab1 to R.string.ab1_invertions,
    R.drawable.ab2 to R.string.ab2_quick_yoga,
    R.drawable.ab3 to R.string.ab3_stretching,
    R.drawable.ab4 to R.string.ab4_tabata,
    R.drawable.ab5 to R.string.ab5_hiit,
    R.drawable.ab6 to R.string.ab6_pre_natal_yoga,
).map { DrawableStringPair(it.first, it.second) }

//favorite collections data
private val favoriteCollectionsData = listOf(
    R.drawable.nature to R.string.nature,
    R.drawable.fc2 to R.string.fc2_nature_meditations,
    R.drawable.fc3 to R.string.fc3_stress_and_anxiety,
    R.drawable.fc4 to R.string.fc4_self_massage,
    R.drawable.fc5 to R.string.fc5_overwhelmed,
    R.drawable.fc6 to R.string.fc6_nightly_wind_down,
).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int) {

}

//Search bar
@Composable
fun SearchBar (modifier: Modifier = Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
               Icon(
                   imageVector = Icons.Default.Search,
                   contentDescription = null
               )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface,
        ),
        placeholder = {
            Text(stringResource(R.string.placeholder_search))
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}
@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    BasicLayoutTheme {
        SearchBar()
    }
}
//Body Element
@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(text),
            modifier = Modifier.paddingFromBaseline(
                top = 24.dp, bottom = 8.dp
            ),
            style = MaterialTheme.typography.bodyMedium
        )

    }

}
@Preview(showBackground = true)
@Composable
fun AlignYourBodyElementPreview() {
    BasicLayoutTheme {
        AlignYourBodyElement(
            text = R.string.ab1_invertions,
            drawable = R.drawable.ab1,
            modifier = Modifier.padding(8.dp)
        )
    }
}
//Favorite collection card
@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier){
    Surface (
        color = MaterialTheme.colorScheme.surfaceVariant,
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(255.dp)
        ){
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )
            Text(
                text = stringResource(text),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.titleMedium
            )
        }        
    }
}
@Preview(showBackground = true)
@Composable
fun FavoriteCollectionCardPreview() {
    BasicLayoutTheme {
        FavoriteCollectionCard(
            text = R.string.nature,
            drawable = R.drawable.nature,
            modifier = Modifier.padding(8.dp)
        )
    }
}

//Alligning the elements in a row
@Composable
fun AlignYourBodyRow(modifier: Modifier = Modifier) {
    LazyRow (
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = Modifier
    ){
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(item.drawable, item.text)
        }
    }
}

//favorite grid section
@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.height(168.dp)
    ) {
        items(favoriteCollectionsData) { item ->
            FavoriteCollectionCard(item.drawable, item.text, modifier.height(80.dp))
        }

   }
}
@Composable
fun HomeSection (
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
){
    Column(modifier) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }

}
@Preview(showBackground = true)
@Composable
fun HomeSectionPreview() {
    BasicLayoutTheme {
        HomeSection(R.string.align_your_body) {
            AlignYourBodyRow()
        }
    }
}
//Navigation Bar
@Composable
private fun BottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ){
        NavigationBarItem(
            selected = true,
            onClick = {},
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text(text = stringResource(R.string.bottom_navigation_home)
                )
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(text = stringResource(R.string.bottom_navigation_profile)
                )
            }
        )
    }
}

//Combining the building blocks into a full screen
@Composable
fun HomeScreen(modifier: Modifier = Modifier){
    Column (
        modifier
            .verticalScroll(rememberScrollState())
    ){
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }
        HomeSection(title = R.string.favorite_collections) {
            FavoriteCollectionsGrid()
        }
        Spacer(Modifier.height(160.dp))
        BottomNavigation()
    }
}
@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    BasicLayoutTheme {
        HomeScreen()
    }
}
@Composable
fun MyApp() {
    BasicLayoutTheme {
        Scaffold (
            bottomBar = { BottomNavigation()}
        ){padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}





