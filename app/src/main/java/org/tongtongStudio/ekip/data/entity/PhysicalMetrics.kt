package org.tongtongStudio.ekip.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date


@Entity(
    foreignKeys = [
        ForeignKey(entity = Player::class,
            parentColumns = ["id"],
            childColumns = ["player_id"])
    ]
)
data class PhysicalMetrics(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "player_id") val playerId: Int,
    val date: Long,
    val height: Double,
    val weight: Double,
    val endurance: Double,
    val maxSpeed: Double,
    val maxStrength: Double,
    val remarks: String?
)