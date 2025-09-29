package com.clerodri.core.domain

/**
 * Author: Ronaldo R.
 * Date:  9/29/2025
 * Description:
 **/
sealed interface Result<out D, out E : Error>{
    data class Success<out D>(val data: D) : Result<D, Nothing>
    data class Error<out E :com.clerodri.core.domain.Error>(val error: E) : Result<Nothing, E>
}

inline fun <T, E: Error, R> Result<T, E>.map(map: (T) -> R): Result<R, E> {
    return when (this) {
        is Result.Success -> Result.Success(map(this.data))
        is Result.Error -> Result.Error(this.error)
    }
}

fun <T, E: Error> Result<T, E>.asEmptyDataResult(): EmptyResult<E> {
    return map {}
}

inline fun <T, E: Error, R> Result<T, E>.onSuccess(action: (T) -> Unit): Result<T, E> {
    return when (this) {
        is Result.Success -> {
            action(this.data)
            this
        }
        is Result.Error -> this
    }
}

inline fun <T, E: Error, R> Result<T, E>.onError(action: (E) -> Unit): Result<T, E> {
    return when (this) {
        is Result.Success -> this
        is Result.Error -> {
            action(error)
            this
        }
    }
}

typealias EmptyResult<E> = Result<Unit, E>