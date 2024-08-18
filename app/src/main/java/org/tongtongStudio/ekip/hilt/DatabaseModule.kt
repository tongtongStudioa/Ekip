package org.tongtongStudio.ekip.hilt

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.tongtongStudio.ekip.data.EkipDatabase
import org.tongtongStudio.ekip.data.dao.PlayerDao
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): EkipDatabase {
        return Room.databaseBuilder(
            app,
            EkipDatabase::class.java,
            "ekip_database"
        ).build()
    }

    @ApplicationScope
    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())

    @Retention(AnnotationRetention.RUNTIME)
    @Qualifier
    annotation class ApplicationScope

    @Provides
    fun providePlayerDao(database: EkipDatabase): PlayerDao {
        return database.playerDao()
    }

    // Ajoutez ici les autres DAO si nécessaire
}