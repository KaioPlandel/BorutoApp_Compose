package com.plandel.borutoapp_compose.data.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.plandel.borutoapp_compose.domain.model.HeroRemoteKey

interface HeroRemoteKeyDao {

    @Query("SELECT * FROM hero_remote_key_table WHERE id= :id")
    suspend fun getRemoteKey(id: Int): HeroRemoteKey?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(heroRemoteKeys: List<HeroRemoteKey>)

    @Query("DELETE FROM HERO_REMOTE_KEY_TABLE")
    suspend fun deleteAllRemoteKeys()
}