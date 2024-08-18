package org.tongtongStudio.ekip.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import org.tongtongStudio.ekip.data.dao.AttendanceDao
import org.tongtongStudio.ekip.data.dao.EvaluationDao
import org.tongtongStudio.ekip.data.dao.PlayerDao
import org.tongtongStudio.ekip.data.entity.Attendance
import org.tongtongStudio.ekip.data.entity.Category
import org.tongtongStudio.ekip.data.entity.CategoryEvalType
import org.tongtongStudio.ekip.data.entity.Evaluation
import org.tongtongStudio.ekip.data.entity.EvaluationType
import org.tongtongStudio.ekip.data.entity.Group
import org.tongtongStudio.ekip.data.entity.Injury
import org.tongtongStudio.ekip.data.entity.Match
import org.tongtongStudio.ekip.data.entity.PhysicalMetrics
import org.tongtongStudio.ekip.data.entity.Player
import org.tongtongStudio.ekip.data.entity.TrainingSession

@Database(entities = [
    Player::class,
    Attendance::class,
    Evaluation::class,
    EvaluationType::class,
    Category::class,
    Group::class,
    Injury::class,
    Match::class,
    PhysicalMetrics::class,
    TrainingSession::class,
    CategoryEvalType::class], version = 1, exportSchema = false)
abstract class EkipDatabase : RoomDatabase() {

    abstract fun playerDao(): PlayerDao
    abstract fun attendanceDao(): AttendanceDao
    abstract fun evaluationDao(): EvaluationDao

    companion object {
        @Volatile
        private var INSTANCE: EkipDatabase? = null

        fun getDatabase(context: Context): EkipDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EkipDatabase::class.java,
                    "team_management_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
