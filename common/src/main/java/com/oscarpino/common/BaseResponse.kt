package com.oscarpino.common

data class BaseResponse<T>(val result: ResultResponse, val payload:T? = null)

enum class ResultResponse{
    SUCCESSFUL,
    ERROR
}