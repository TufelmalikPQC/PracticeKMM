package com.practice.kmm.modules.shop.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.practice.kmm.models.entities.Product
import com.practice.kmm.theme.ShopTheme
import com.practice.kmm.uiToolKit.CircleIconButton
import com.practice.kmm.uiToolKit.ColorSelector
import com.practice.kmm.uiToolKit.PagerIndicator
import com.practice.kmm.uiToolKit.PrimaryButton
import com.practice.kmm.uiToolKit.RatingDisplay
import com.practice.kmm.uiToolKit.SecondaryButton
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import practicekmm.composeapp.generated.resources.Res
import practicekmm.composeapp.generated.resources.action_add_to_cart
import practicekmm.composeapp.generated.resources.action_buy_now
import practicekmm.composeapp.generated.resources.label_including_taxes

/**
 * Product detail screen showing product images, info, and purchase options.
 *
 * @param productId ID of the product to display
 * @param onNavigateBack Callback for back navigation
 * @param onBuyNow Callback when Buy Now is clicked
 * @param onAddToCart Callback when Add to Cart is clicked
 * @param modifier Modifier for the screen
 */
@Composable
fun ProductDetailScreen(
    productId: String,
    onNavigateBack: () -> Unit,
    onBuyNow: () -> Unit,
    onAddToCart: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Demo data - in real app, fetch from repository
    val product = remember {
        Product(
            id = productId,
            name = "Sony WH-1000XM5",
            price = 4999.0,
            rating = 4.8f,
            reviewCount = 231,
            colors = listOf(0xFF1E3A5F, 0xFFE5DDD3, 0xFFB8B8B8),
            thumbnails = listOf("front", "side", "back")
        )
    }

    var selectedColorIndex by remember { mutableStateOf(0) }
    var selectedImageIndex by remember { mutableStateOf(1) }

    val extendedColors = ShopTheme.extendedColors

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Scrollable Content
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {
                // Header with Back, Heart, Share
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CircleIconButton(
                        icon = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        onClick = onNavigateBack
                    )

                    Row {
                        CircleIconButton(
                            icon = Icons.Default.FavoriteBorder,
                            contentDescription = "Favorite",
                            onClick = { }
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        CircleIconButton(
                            icon = Icons.Default.Share,
                            contentDescription = "Share",
                            onClick = { }
                        )
                    }
                }

                // Main Product Image
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .padding(horizontal = 32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    // Placeholder for product image
                    Box(
                        modifier = Modifier
                            .size(250.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(MaterialTheme.colorScheme.surfaceVariant),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = product.name.take(2).uppercase(),
                            style = MaterialTheme.typography.displayLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                // Image Pager Indicator
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    PagerIndicator(
                        pageCount = 3,
                        currentPage = selectedImageIndex
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Thumbnail Row
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    itemsIndexed(product.thumbnails) { index, _ ->
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 8.dp)
                                .size(60.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .then(
                                    if (index == selectedImageIndex) {
                                        Modifier.border(
                                            2.dp,
                                            MaterialTheme.colorScheme.primary,
                                            RoundedCornerShape(12.dp)
                                        )
                                    } else {
                                        Modifier
                                    }
                                )
                                .background(MaterialTheme.colorScheme.surfaceVariant)
                                .clickable { selectedImageIndex = index },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = (index + 1).toString(),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Product Info
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = product.name,
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = MaterialTheme.colorScheme.onBackground
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "$ ${product.price.toInt().toString().reversed().chunked(3).joinToString(",").reversed()}",
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            color = extendedColors.priceText
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "|",
                            color = MaterialTheme.colorScheme.outline
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = stringResource(Res.string.label_including_taxes),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Color Selector and Rating Row
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ColorSelector(
                            colors = product.colors,
                            selectedIndex = selectedColorIndex,
                            onColorSelected = { selectedColorIndex = it }
                        )

                        RatingDisplay(
                            rating = product.rating,
                            reviewCount = product.reviewCount
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
            }

            // Bottom Action Buttons
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                SecondaryButton(
                    text = stringResource(Res.string.action_add_to_cart),
                    onClick = onAddToCart
                )

                PrimaryButton(
                    text = stringResource(Res.string.action_buy_now),
                    onClick = onBuyNow
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProductDetailScreenPreview() {
    ShopTheme {
        ProductDetailScreen(
            productId = "2",
            onNavigateBack = {},
            onBuyNow = {},
            onAddToCart = {}
        )
    }
}
