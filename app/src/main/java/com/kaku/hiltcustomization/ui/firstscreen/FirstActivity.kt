package com.kaku.hiltcustomization.ui.firstscreen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kaku.data.di.MyComponentManager
import com.kaku.hiltcustomization.ui.secondscreen.SecondActivity
import com.kaku.hiltcustomization.ui.theme.CustomizeHiltComponentTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FirstActivity : ComponentActivity() {

    @Inject
    lateinit var myComponentManager: MyComponentManager

    private val viewModel by viewModels<FirstViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // to avoid FirstActivity killed by Low Memory
        if (savedInstanceState == null) myComponentManager.recreateComponent()

        setContent {
            CustomizeHiltComponentTheme {
                val num by viewModel.number.collectAsState()
                val repoInfo by viewModel.repoInfo.collectAsState()
                val onAddClick = { viewModel.addNum() }
                val onMinusClick = { viewModel.reduceNum() }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = this@FirstActivity.javaClass.simpleName,
                            modifier = Modifier.align(Alignment.TopCenter),
                            style = MaterialTheme.typography.headlineMedium
                        )
                        Text(
                            text = repoInfo,
                            modifier = Modifier
                                .align(Alignment.TopCenter)
                                .padding(top = 32.dp),
                            style = MaterialTheme.typography.titleLarge
                        )

                        Column(
                            modifier = Modifier.align(Alignment.Center),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = num,
                                style = MaterialTheme.typography.headlineMedium
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Button(onClick = onAddClick) {
                                Text(text = "ADD")
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Button(onClick = onMinusClick) {
                                Text(text = "MINUS")
                            }
                        }

                        Button(
                            onClick = {
                                val intent = Intent(this@FirstActivity, SecondActivity::class.java)
                                startActivity(intent)
                            },
                            modifier = Modifier.align(Alignment.BottomCenter)
                        ) {
                            Text(text = "Nav to Second Screen")
                        }
                    }
                }
            }
        }
    }
}
