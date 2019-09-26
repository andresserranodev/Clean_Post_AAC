package com.puzzle.bench.post_aac.presentation.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.puzzle.bench.post_aac.data.FetchAllPostServiceImpl
import com.puzzle.bench.post_aac.data.FetchAllUsersServiceImpl
import com.puzzle.bench.post_aac.data.database.room.PostAACRoomDatabase
import com.puzzle.bench.post_aac.data.mapper.PostMapper
import com.puzzle.bench.post_aac.data.mapper.UserMapper
import com.puzzle.bench.post_aac.data.networking.retrofit.RetrofitClient
import com.puzzle.bench.post_aac.data.utils.utils.BusinesRulesSynPost.getReadPosts
import com.puzzle.bench.post_aac.data.utils.utils.BusinesRulesSynPost.getUnReadPosts
import kotlinx.coroutines.coroutineScope

class SycDataWorker(context: Context, workerParams: WorkerParameters) :
    CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result = coroutineScope {
        try {

            val serviceRepose = FetchAllPostServiceImpl(
                RetrofitClient.makeServiceApi(),
                PostMapper()
            ).fetchAllPost()

            val usersServiceImp =
                FetchAllUsersServiceImpl(RetrofitClient.makeServiceApi(), UserMapper())
            val database = PostAACRoomDatabase.getInstance(applicationContext)
            database.postDao().insertAll(getUnReadPosts(serviceRepose))
            database.postDao().insertAll(getReadPosts(serviceRepose))
            database.userDao().insertAll(usersServiceImp.fetchAllUsers())
            Result.success()
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }

    companion object {
        private val TAG = SycDataWorker::class.java.simpleName
    }

}