package com.clerodri.porfolio.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Author: Ronaldo R.
 * Date:  9/30/2025
 * Description:
 **/
@Entity
data class UserBalanceEntity(
    @PrimaryKey val id: Int = 1,
    val cashBalance: Double
)