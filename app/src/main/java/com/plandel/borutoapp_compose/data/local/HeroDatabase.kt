package com.plandel.borutoapp_compose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.plandel.borutoapp_compose.data.local.dao.HeroDao
import com.plandel.borutoapp_compose.data.local.dao.HeroRemoteKeyDao
import com.plandel.borutoapp_compose.domain.model.Hero
import com.plandel.borutoapp_compose.domain.model.HeroRemoteKey

@Database(entities = [Hero::class, HeroRemoteKey::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class HeroDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao

    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao

}