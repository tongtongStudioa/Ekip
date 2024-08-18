package org.tongtongStudio.ekip.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "training_sessions")
data class TrainingSession(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val date: Long,
    val location: String,
    val duration: Int,
)