package com.harapps.masterly.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harapps.masterly.R
import com.harapps.masterly.ui.theme.cardSurface
import com.harapps.masterly.ui.theme.progressColor
import com.harapps.masterly.ui.theme.progressTrack
import com.harapps.masterly.ui.theme.textPrimary
import com.harapps.masterly.ui.theme.textSecondary

@Composable
fun SkillCartItem(title: String,
                  hoursCompleted: String,
                  progress: Float,
                  percentage: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = cardSurface),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = title,
                    color = textPrimary,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Forward Arrow", tint = progressColor)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(modifier = Modifier.wrapContentSize(),
                verticalAlignment = Alignment.CenterVertically) {
                Icon(painter = painterResource(R.drawable.stopwatch),
                    tint = textSecondary,
                    contentDescription = "stopwatch",
                    modifier = Modifier.size(12.dp)
                )
                Text(text = hoursCompleted,
                    modifier = Modifier.padding(start = 8.dp),
                    color = textSecondary,
                    fontSize = 12.sp)

                Text(text = "/",
                    modifier = Modifier.padding(start = 2.dp),
                    color = textSecondary,
                    fontSize = 12.sp)

                Text(text = stringResource(R.string.hrs_10k),
                    modifier = Modifier.padding(start = 2.dp),
                    color = textSecondary,
                    fontSize = 12.sp)
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = stringResource(R.string.progress),
                    color = textSecondary,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp)

                Text(text = stringResource(R.string.skill_percentage, percentage),
                    color = textPrimary,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(15.dp))

            RoundedProgressBar(progress)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SkillCardPreview() {
    SkillCartItem(stringResource(R.string.skill_guitar), "1,234", 0.13f, 13)
}

@Composable
fun RoundedProgressBar(
    progress: Float,
    modifier: Modifier = Modifier,
    height: Dp = 10.dp,
    trackColor: Color = progressTrack,
    progressColor: Color = com.harapps.masterly.ui.theme.progressColor
) {
    val safeProgress = progress.coerceIn(0f, 1f)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .clip(RoundedCornerShape(50))
            .background(trackColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(safeProgress)
                .background(progressColor)
        )
    }
}