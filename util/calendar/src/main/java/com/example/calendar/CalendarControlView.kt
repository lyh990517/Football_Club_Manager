package com.example.calendar

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ui_component.HorizontalSpacer
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CalendarControlView(
    modifier: Modifier = Modifier,
    year: Int,
    month: Int,
    pagerState: PagerState,
    pageCount: Int
) {
    val coroutineScope = rememberCoroutineScope()
    Row(modifier) {
        Text(text = "$year 년 $month 월")
        HorizontalSpacer(value = 10)
        Icon(
            modifier = Modifier.clickable {
                coroutineScope.launch {
                    pagerState.animateScrollToPage((pagerState.currentPage - 1).coerceAtLeast(0))
                }
            },
            imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
            contentDescription = "key"
        )
        HorizontalSpacer(value = 10)
        Icon(
            modifier = Modifier.clickable {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(
                        (pagerState.currentPage + 1).coerceAtMost(
                            pageCount
                        )
                    )
                }
            },
            imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
            contentDescription = "key"
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun CalendarControlView() {
    CalendarControlView(modifier = Modifier.fillMaxWidth(), year = 2024, month = 1, pagerState = rememberPagerState { 5 }, pageCount = 5)
}