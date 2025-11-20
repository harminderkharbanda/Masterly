package com.harapps.masterly.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import com.harapps.masterly.R
import com.harapps.masterly.ui.theme.MasterlyTheme
import com.harapps.masterly.ui.theme.cardSurface
import com.harapps.masterly.ui.theme.progressColor
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
                    style = MaterialTheme.typography.titleLarge,
                )
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Forward Arrow", tint = progressColor)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(painter = painterResource(R.drawable.stopwatch),
                    tint = textSecondary,
                    contentDescription = "stopwatch",
                    modifier = Modifier.size(12.dp)
                )
                Text(text = stringResource(R.string.x_by_10k_hrs, hoursCompleted),
                    modifier = Modifier.padding(start = 8.dp),
                    style = MaterialTheme.typography.labelSmall)
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = stringResource(R.string.progress),
                    color = textSecondary,
                    style = MaterialTheme.typography.labelSmall)

                Text(text = stringResource(R.string.skill_percentage, percentage),
                    color = textPrimary,
                    style = MaterialTheme.typography.labelMedium)
            }

            Spacer(modifier = Modifier.height(15.dp))

            RoundedProgressBar(progress)
        }
    }
}


@Preview(showBackground = true, name = "Generic preview", group = "preview")
@Composable
fun SkillCardPreview() {
    MasterlyTheme {
        SkillCartItem(stringResource(R.string.skill_guitar), "1,234", 0.13f, 13)
    }
}

@Preview(showBackground = true, name = "Full progress preview", group = "preview", uiMode = Configuration.UI_MODE_NIGHT_YES, wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE)
@Composable
fun SkillCardPreviewFull() {
    MasterlyTheme {
        SkillCartItem(stringResource(R.string.skill_guitar), "1,234", 1f, 100)
    }
}

@Preview(showBackground = true, name = "half progress preview", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun SkillCardPreviewHalf() {
    MasterlyTheme {
        SkillCartItem(stringResource(R.string.skill_guitar), "1,234", 0.5f, 50)
    }
}

