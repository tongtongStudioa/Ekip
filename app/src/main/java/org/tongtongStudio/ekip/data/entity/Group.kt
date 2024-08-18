package org.tongtongStudio.ekip.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "level_groups")
data class Group(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val description: String?
)