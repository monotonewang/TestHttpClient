package com.example.ubuntu.testhttpclient.weakreference

data class People(val name:String,val age:Int){
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }
}