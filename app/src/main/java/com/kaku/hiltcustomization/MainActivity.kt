package com.kaku.hiltcustomization

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kaku.hiltcustomization.ui.firstscreen.FirstActivity
import com.kaku.hiltcustomization.ui.theme.CustomizeHiltComponentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomizeHiltComponentTheme {
                val onNavToFirstScreenClick = {
                    startActivity(Intent(this@MainActivity, FirstActivity::class.java))
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = this@MainActivity.javaClass.simpleName,
                            modifier = Modifier.align(Alignment.TopCenter),
                            style = MaterialTheme.typography.headlineMedium
                        )
                        Button(
                            modifier = Modifier.align(Alignment.Center),
                            onClick = onNavToFirstScreenClick
                        ) {
                            Text(text = "Nav to First Screen")
                        }
                    }
                }
            }
        }
    }
}
