package com.practice.kmm.modules.shop.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.practice.kmm.models.consts.Category
import com.practice.kmm.models.entities.Product
import com.practice.kmm.modules.shop.components.PromoBanner
import com.practice.kmm.theme.ShopTheme
import com.practice.kmm.uiToolKit.BottomNavTab
import com.practice.kmm.uiToolKit.CategoryChip
import com.practice.kmm.uiToolKit.PagerIndicator
import com.practice.kmm.uiToolKit.ProductCard
import com.practice.kmm.uiToolKit.SearchBar
import com.practice.kmm.uiToolKit.ShopBottomNavigationBar
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import practicekmm.composeapp.generated.resources.Res
import practicekmm.composeapp.generated.resources.label_fashion
import practicekmm.composeapp.generated.resources.label_sports
import practicekmm.composeapp.generated.resources.label_supermarket
import practicekmm.composeapp.generated.resources.label_technology
import practicekmm.composeapp.generated.resources.promo_validity
import practicekmm.composeapp.generated.resources.title_hot_sales
import practicekmm.composeapp.generated.resources.title_recently_viewed

/**
 * Shop home screen with product listings.
 *
 * @param onProductClick Callback when product is clicked
 * @param onTabSelected Callback when bottom nav tab is selected
 * @param modifier Modifier for the screen
 */
@Composable
fun ShopHomeScreen(
    onProductClick: (String) -> Unit,
    onTabSelected: (BottomNavTab) -> Unit,
    modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf<Category?>(null) }
    var currentBannerPage by remember { mutableStateOf(0) }

    // Demo data
    val hotSalesProducts = remember {
        listOf(
            Product(
                id = "1",
                name = "Macbook Air M1",
                price = 29999.0,
                hasFreeShipping = true
            ),
            Product(
                id = "2",
                name = "Sony WH1000XM5",
                price = 4999.0,
                hasFreeShipping = true
            ),
            Product(
                id = "3",
                name = "FreeBuds Huawei",
                price = 1999.0,
                hasFreeShipping = true
            )
        )
    }

    val recentlyViewedProducts = remember {
        listOf(
            Product(id = "4", name = "Samsung Galaxy Tab", price = 15999.0),
            Product(id = "5", name = "Amazon Echo", price = 2999.0)
        )
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            ShopBottomNavigationBar(
                selectedTab = BottomNavTab.HOME,
                onTabSelected = onTabSelected
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            // Header with Search and Notification
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SearchBar(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(12.dp))

                BadgedBox(
                    badge = {
                        Badge(
                            containerColor = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(8.dp)
                        )
                    }
                ) {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }

            // Promo Banner
            PromoBanner(
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            // Banner Validity Text
            Text(
                text = stringResource(Res.string.promo_validity, "27/03", "01/04 2022", 1),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Category Chips
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    CategoryChip(
                        text = stringResource(Res.string.label_technology),
                        isSelected = selectedCategory == Category.TECHNOLOGY,
                        onClick = {
                            selectedCategory = if (selectedCategory == Category.TECHNOLOGY) null else Category.TECHNOLOGY
                        }
                    )
                }
                item {
                    CategoryChip(
                        text = stringResource(Res.string.label_fashion),
                        isSelected = selectedCategory == Category.FASHION,
                        onClick = {
                            selectedCategory = if (selectedCategory == Category.FASHION) null else Category.FASHION
                        }
                    )
                }
                item {
                    CategoryChip(
                        text = stringResource(Res.string.label_sports),
                        isSelected = selectedCategory == Category.SPORTS,
                        onClick = {
                            selectedCategory = if (selectedCategory == Category.SPORTS) null else Category.SPORTS
                        }
                    )
                }
                item {
                    CategoryChip(
                        text = stringResource(Res.string.label_supermarket),
                        isSelected = selectedCategory == Category.SUPERMARKET,
                        onClick = {
                            selectedCategory = if (selectedCategory == Category.SUPERMARKET) null else Category.SUPERMARKET
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Hot Sales Section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(Res.string.title_hot_sales),
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.onBackground
                )

                PagerIndicator(
                    pageCount = 4,
                    currentPage = currentBannerPage
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Hot Sales Products
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(hotSalesProducts) { product ->
                    ProductCard(
                        product = product,
                        onClick = { onProductClick(product.id) },
                        modifier = Modifier.width(150.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Recently Viewed Section
            Text(
                text = stringResource(Res.string.title_recently_viewed),
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Recently Viewed Products
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(recentlyViewedProducts) { product ->
                    ProductCard(
                        product = product,
                        onClick = { onProductClick(product.id) },
                        modifier = Modifier.width(150.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview
@Composable
private fun ShopHomeScreenPreview() {
    ShopTheme {
        ShopHomeScreen(
            onProductClick = {},
            onTabSelected = {}
        )
    }
}
