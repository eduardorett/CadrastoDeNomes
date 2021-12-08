package com.devedu.cadrastodenomes.Repositorys

class ValidationListener(str:String = "") {

    private var mStatus: Boolean = true
    private var mMessage: String = ""

    init {
        if (str != "" ){
            mStatus = false
            mMessage = str
        }
    }

    fun succes()= mStatus
    fun failure () = mMessage


}