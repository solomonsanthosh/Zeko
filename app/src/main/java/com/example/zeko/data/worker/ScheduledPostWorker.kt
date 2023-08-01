package com.example.zeko.data.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.zeko.data.model.Post
import com.example.zeko.data.usecase.getScheduledPostUseCase
import com.example.zeko.data.usecase.savePostUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import java.lang.reflect.Parameter


@HiltWorker
class ScheduledPostWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
     val getScheduledPostUseCase: getScheduledPostUseCase,
     val savePostUseCase: savePostUseCase
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result {
        getScheduledPostUseCase.execute(System.currentTimeMillis()).also {
            if (it != null) {
                savePostUseCase.execute(it).also {
                    if (it != null) {
                        return Result.success()
                    } else {
                        return Result.failure()
                    }
                }

            } else {
               return Result.failure()
            }
        }

    }
}