package com.clerodri.core.util

import com.clerodri.core.domain.DataError
import kindmoney.composeapp.generated.resources.Res
import kindmoney.composeapp.generated.resources.error_disk_full
import kindmoney.composeapp.generated.resources.error_insufficient_balance
import kindmoney.composeapp.generated.resources.error_no_internet
import kindmoney.composeapp.generated.resources.error_request_timeout
import kindmoney.composeapp.generated.resources.error_serialization
import kindmoney.composeapp.generated.resources.error_too_many_requests
import kindmoney.composeapp.generated.resources.error_unknown
import org.jetbrains.compose.resources.StringResource

/**
 * Author: Ronaldo R.
 * Date:  9/29/2025
 * Description:
 **/
fun DataError.toUiText(): StringResource {
    val stringRes = when(this){
        DataError.Local.DISK_FULL -> Res.string.error_disk_full
        DataError.Local.UNKNOWN -> Res.string.error_unknown
        DataError.Remote.REQUEST_TIMEOUT -> Res.string.error_request_timeout
        DataError.Remote.TOO_MANY_REQUESTS -> Res.string.error_too_many_requests
        DataError.Remote.NO_INTERNET -> Res.string.error_no_internet
        DataError.Remote.SERVER -> Res.string.error_unknown
        DataError.Remote.SERIALIZATION -> Res.string.error_serialization
        DataError.Remote.UNKNOWN -> Res.string.error_unknown
        DataError.Local.INSUFFICIENT_FUNDS -> Res.string.error_insufficient_balance
        DataError.Local.INVALID_DATA -> Res.string.error_unknown
    }
    return stringRes
}