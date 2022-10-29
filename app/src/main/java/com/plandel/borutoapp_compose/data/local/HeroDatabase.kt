package com.plandel.borutoapp_compose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.plandel.borutoapp_compose.data.local.dao.HeroDao
import com.plandel.borutoapp_compose.data.local.dao.HeroRemoteKeyDao
import com.plandel.borutoapp_compose.domain.model.Hero
import com.plandel.borutoapp_compose.domain.model.HeroRemoteKey

@Database(entities = [Hero::class, HeroRemoteKey::class], version = 1)
abstract class HeroDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao

    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao

}