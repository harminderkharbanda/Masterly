package com.harapps.masterly.ui.screens

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harapps.masterly.R
import com.harapps.masterly.ui.components.RoundedProgressBar
import com.harapps.masterly.ui.model.Skill
import com.harapps.masterly.ui.theme.MasterlyTheme
import com.harapps.masterly.ui.theme.cardSurface
import com.harapps.masterly.ui.theme.deepRed
import com.harapps.masterly.ui.theme.progressTrack
import com.harapps.masterly.ui.theme.purple
import com.harapps.masterly.ui.theme.skyBlue
import com.harapps.masterly.ui.theme.textPrimary
import com.harapps.masterly.ui.theme.white

@Composable
fun SkillDetails(skill: Skill) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "Back Arrow", tint = white)
                Text(text = stringResource(R.string.back),
                    color = textPrimary,
                    style = MaterialTheme.typography.labelSmall,
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Button(
                    onClick = {},
                    border = BorderStroke(1.dp, purple),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = purple
                    )
                ) {
                    Text(stringResource(R.string.edit))
                }
                Button(
                    modifier = Modifier.padding(start = 8.dp),
                    onClick = {},
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = deepRed,
                        contentColor = Color.White
                    )
                ) {
                    Text(stringResource(R.string.delete))
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = skill.skillName,
                color = textPrimary,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 24.sp
                ),
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Column {
                Text(
                    text = stringResource(R.string.progress_towards_mastery),
                    style = MaterialTheme.typography.labelSmall
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RoundedProgressBar(skill.percentageFraction, modifier = Modifier.width(150.dp))
                    Text(modifier = Modifier.padding(start = 8.dp),
                        text = stringResource(R.string.skill_percentage, skill.percentageCompleted),
                        color = skyBlue,
                        style = MaterialTheme.typography.labelMedium)
                }
            }

            Box(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .height(50.dp)
                    .width(1.dp)
                    .background(progressTrack)
            )

            Column(modifier = Modifier.padding(start = 8.dp)) {
                Text(
                    text = stringResource(R.string.total_hours),
                    style = MaterialTheme.typography.labelSmall
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = skill.hoursCompleted,
                        color = textPrimary,
                        style = MaterialTheme.typography.bodyLarge)
                    Text(text = stringResource(R.string.by_10k_hrs, skill.hoursCompleted),
                        style = MaterialTheme.typography.labelSmall)
                }
            }
        }

        Spacer(modifier = Modifier.height(100.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Text(text = "0:00",
                color = textPrimary,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 50.sp
                ))
        }

        Spacer(modifier = Modifier.height(50.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Button(
                onClick = {},
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = purple,
                    contentColor = Color.White
                )
            ) {
                Text(stringResource(R.string.start_timer))
            }
        }

    }
}

@Preview
@Composable
fun SkillDetailsPreview() {
    MasterlyTheme {
        SkillDetails(Skill("Guitar", 0.25f, 12,"1,250"))
    }
}
