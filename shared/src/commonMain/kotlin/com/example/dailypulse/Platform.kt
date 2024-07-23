package com.example.dailypulse


//kMP usa conceito de expect,actual para os metodos
//que vao ser implementados por cada sistema operacional,
//resumindo se declar um expect preciso implementar em cada sistema dentro do shared
expect  class Platform {
    val osName: String
    val osVersion: String
    val deviceModel: String
    val density: Int

    fun logSystemInfo()
}