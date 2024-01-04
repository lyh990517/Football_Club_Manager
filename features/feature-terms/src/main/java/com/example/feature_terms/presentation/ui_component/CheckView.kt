package com.example.feature_terms.presentation.ui_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.feature_terms.R
import com.example.ui_component.HorizontalSpacer

@Composable
fun CheckView() {
    Column {
        CheckBox(text = "서비스 이용약관"){}
        CheckBox(text = "위치기반 서비스 이용약관"){}
        CheckBox(text = "개인정보 처리방침"){}
    }
}

@Composable
fun CheckBox(text: String, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth(),
    ) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(20.dp)
                .clickable { onClick() }
        )
        {
            Image(
                painter = painterResource(id = R.drawable.check_icon),
                contentDescription = "CheckIcon",
                modifier = Modifier.size(20.dp)
            )
        }
        HorizontalSpacer(value = 10)
        Text(text = text, color = Color.White, modifier = Modifier.weight(1f))
        HorizontalSpacer(value = 10)
        Text(text = "(필수)", color = Color(0xFF857FEB))

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.right_arrow_icon),
            contentDescription = "RightArrowIcon",
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
@Preview
fun CheckViewPreview() {
    CheckView()
}