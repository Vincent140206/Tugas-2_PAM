package vin.pam.praktikum.praktikum_6.appnavigasi.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import vin.pam.praktikum.praktikum_6.appnavigasi.model.YouTubeStreamItem

@Composable
fun YouTubeStreamPagerScreen(
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val videoList = remember {
        listOf(
            YouTubeStreamItem(1, "Google I/O Compose Overview", "FgAL6T_KILw"),
            YouTubeStreamItem(2, "Jetpack Compose Navigation", "0-S5a0eXPoc"),
            YouTubeStreamItem(3, "Android State Management", "j5E3_El_8Js")
        )
    }

    val pagerState = rememberPagerState(pageCount = { videoList.size })

    Scaffold { padding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = onBack) {
                    Text("< Kembali")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Stream Video Pager",
                    style = MaterialTheme.typography.titleLarge
                )
            }

            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) { page ->
                val video = videoList[page]
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = video.title,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        YouTubePlayerComposable(videoId = video.videoId)
                    }
                }
            }

            Text(
                text = "Halaman ${pagerState.currentPage + 1} dari ${videoList.size}",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun YouTubePlayerComposable(
    videoId: String,
    modifier: Modifier = Modifier
) {
    AndroidView(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(16f / 9f),
        factory = { context ->
            YouTubePlayerView(context).apply {
                addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                    override fun onReady(youTubePlayer: YouTubePlayer) {
                        youTubePlayer.cueVideo(videoId, 0f)
                    }
                })
            }
        }
    )
}
