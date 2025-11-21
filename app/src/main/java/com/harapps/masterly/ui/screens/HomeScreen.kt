package com.harapps.masterly.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.harapps.masterly.R
import com.harapps.masterly.ui.components.SkillCartItem
import com.harapps.masterly.ui.model.Skill
import com.harapps.masterly.ui.theme.MasterlyTheme

@Composable
fun HomeScreen(paddingValues: PaddingValues) {
    Column(modifier = Modifier.padding(paddingValues)) {
        SkillDetails(Skill("Guitar", 0.25f, 12,"1,250"))
        SkillCartItem(stringResource(R.string.skill_guitar), "1,250", 0.13f, 13)
        SkillCartItem(stringResource(R.string.skill_javaScript), "10,000", 1f, 100)
        SkillCartItem(stringResource(R.string.skill_digital_painting), "2,250", 0.23f, 23)
        SkillCartItem(stringResource(R.string.skill_spanish), "6,450", 0.65f, 65)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MasterlyTheme {
        HomeScreen(PaddingValues(16.dp))
    }
}