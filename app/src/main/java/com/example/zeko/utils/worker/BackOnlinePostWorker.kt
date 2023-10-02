package com.example.zeko.utils.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.zeko.data.usecase.getOfflinePostsUseCase
import com.example.zeko.data.usecase.getScheduledPostUseCase
import com.example.zeko.data.usecase.savePostUseCase
import com.example.zeko.utils.notification.NotificationService
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class BackOnlinePostWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParameters: WorkerParameters,
    val getOfflinePostsUseCase: getOfflinePostsUseCase

) : CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        getOfflinePostsUseCase.execute()
        return Result.success()
    }
}