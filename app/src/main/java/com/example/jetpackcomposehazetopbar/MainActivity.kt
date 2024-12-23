package com.example.jetpackcomposehazetopbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposehazetopbar.ui.theme.Blur
import com.example.jetpackcomposehazetopbar.ui.theme.JetpackComposeHazeTopBarTheme
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeStyle
import dev.chrisbanes.haze.HazeTint
import dev.chrisbanes.haze.hazeChild

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeHazeTopBarTheme {

                val hazeState = remember { HazeState() }
                val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
                    state = rememberTopAppBarState()
                )
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = colorResource(id = R.color.black))
                        .nestedScroll(scrollBehavior.nestedScrollConnection),
                    containerColor = Color.Transparent,
                    topBar = {
                        Column {
                            TopBar(
                                modifier = Modifier.hazeChild(hazeState),
                                scrollBehavior = scrollBehavior
                            )

                            Pager(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .hazeChild(state = hazeState)
                            )
                        }
                    },
                )
                { innerPadding ->
                   HomeScreen(
                       paddingValues = innerPadding,
                       modifier = Modifier
                           .fillMaxSize(),
                       hazeState = hazeState
                   )
                }
            }
        }
    }

    @Composable
    fun HomeScreen(
        modifier: Modifier = Modifier,
        hazeState: HazeState,
        paddingValues: PaddingValues
    ) {
        Box(
            modifier = modifier
                .background(MaterialTheme.colorScheme.background)
        ) {
            CarList(
                paddingValues = paddingValues,
                modifier = Modifier
                    .fillMaxSize()
                    .hazeChild(
                        state = hazeState,
                        style = HazeStyle(
                            blurRadius = 13.dp,
                            tint = HazeTint(Blur)
                        )
                    )
            )

            BottomBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 26.dp)
                    .align(Alignment.BottomStart)
                    .padding(bottom = 56.dp)
                    .hazeChild(
                        state = hazeState,
                    )
                    .clip(RoundedCornerShape(20.dp))
            )
        }

    }
}

