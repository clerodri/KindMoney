package com.clerodri.core.util

import com.clerodri.core.domain.DataError
import kindmoney.composeapp.generated.resources.Res
import kindmoney.composeapp.generated.resources.error_disk_full
import org.jetbrains.compose.resources.StringResource

/**
 * Author: Ronaldo R.
 * Date:  9/29/2025
 * Description:
 **/
fun DataError.toUiText(): StringResource {
    val stringRes = when(this){
        DataError.Local.DISK_FULL -> Res.string.error_disk_full
        DataError.Local.INSUFFICIENT_FUNDS -> Res.string.error_disk_full
        DataError.Local.INVALID_DATA -> Res.string.error_disk_full
        DataError.Local.UNKNOWN -> Res.string.error_disk_full
        DataError.Remote.REQUEST_TIMEOUT -> Res.string.error_disk_full
        DataError.Remote.NO_INTERNET -> Res.string.error_disk_full
        DataError.Remote.SERVER -> Res.string.error_disk_full
        DataError.Remote.SERIALIZATION -> Res.string.error_disk_full
        DataError.Remote.UNKNOWN -> Res.string.error_disk_full
        DataError.Remote.TOO_MANY_REQUESTS -> Res.string.error_disk_full
    }
    return stringRes
}