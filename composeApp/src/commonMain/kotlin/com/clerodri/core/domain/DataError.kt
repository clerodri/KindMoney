package com.clerodri.core.domain

/**
 * Author: Ronaldo R.
 * Date:  9/29/2025
 * Description:
 **/
sealed interface DataError: Error {

    enum class Remote: DataError {
        REQUEST_TIMEOUT,
        NO_INTERNET,
        SERVER,
        SERIALIZATION,
        UNKNOWN,
        TOO_MANY_REQUESTS
    }

    enum class Local: DataError {
        DISK_FULL,
        INSUFFICIENT_FUNDS,
        INVALID_DATA,
        UNKNOWN
    }
}