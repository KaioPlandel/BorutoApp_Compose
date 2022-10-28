package com.plandel.borutoapp_compose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.plandel.borutoapp_compose.data.local.dao.HeroDao
import com.plandel.borutoapp_compose.domain.model.Hero

@Database(entities = [Hero::class], version = 1)
abstract class HeroDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao

}