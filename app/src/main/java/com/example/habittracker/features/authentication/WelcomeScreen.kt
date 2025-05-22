package com.example.habittracker.features.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.habittracker.R
import com.example.habittracker.core.components.PrimaryButton
import com.example.habittracker.core.theme.HabitTrackerTheme

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    onGetStarted: () -> Unit,
) {
    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = Color(0xFF4E55E0)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(Modifier.height(100.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Build healthy habits with us",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayMedium,
                color = Color.White
            )

            Spacer(Modifier.height(30.dp))

            Image(
                modifier = Modifier
                    .size(310.dp),
                painter = painterResource(R.drawable.welcome_img),
                contentDescription = null
            )

            Spacer(Modifier.height(30.dp))

            PrimaryButton(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Get started",
                onClick = onGetStarted
            )


            Text(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .clickable { },
                text = "I have an account",
                style = MaterialTheme.typography.bodySmall,
                color = Color.White,
                textDecoration = TextDecoration.Underline
            )

            Spacer(Modifier.weight(1f))

            Text(
                modifier = Modifier
                    .clickable { }
                    .fillMaxWidth(0.75f),
                text = "By starting or singing in, you agree to our Terms of use",
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                color = Color.White,
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    HabitTrackerTheme {
        WelcomeScreen(
            onGetStarted = {}
        )
    }
}