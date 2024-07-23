# Daily Pulse
App nativo em Android e IOS, mostra as informacoes sobre o nome do device,versao e a densidade

## Motivacao 
Primerio aplicativo com kMP(koltin Multiplataform) 


## Feature
- Quando é criado o projeto a estrutura inicial padrão haverá 3 principais pastas:  androidApp, iosApp e shared
- Shared  será a camada de lógica para Android e IOS
- Dentro de shared temos androidMain, iosMain é commonMain
- Os códigos copilados no commonMain e nas respectivas pastas iram para específico sistema operacional. Exemplo commonMain e  iosMain serão  copilado para IOS
- Abaixo mais detalhes sobre o uso de shared com as respectivas plataformas
- Detalhe no IOS pode acusar que não encontrou o modulo shared, após copilar no xcode deveria voltar funcionar normalmente
- Após ter criado a lógica consumimos nos respectivos códigos nativos, ou seja em iosApp ou androidApp
  
``` kotlin
// commonMain
// criei uma funcao com a palavra expect, quando isso e criado, o copilador espera que possua a mesma classe dentro de androidMain é iosMain

expect  class Platform {
    val osName: String
    val osVersion: String
    val deviceModel: String
    val density: Int

    fun logSystemInfo()
}

//androidMain
//precisa ser a mesma classe de commonMain e os membros respectivos identico a um contrato
actual class Platform {
    actual val osName: String
        get() =  "Android"
    actual val osVersion: String
        get() = "${android.os.Build.VERSION.SDK_INT}"
    actual val deviceModel: String
        get() = android.os.Build.MODEL
    actual val density: Int
            get() = round(Resources.getSystem().displayMetrics.density).toInt()

    actual fun logSystemInfo() {
        Log.d("Daily pulse", "deviceModel: $deviceModel osName: $osName osVersion: $osVersion density: $density")
    }

}


//iosMain
actual class Platform {
    actual val osName: String
        get() =  UIDevice.currentDevice.systemName()
    actual val osVersion: String
        get() = UIDevice.currentDevice.systemVersion
    actual val deviceModel: String
        get() = UIDevice.currentDevice.model
    actual val density: Int
        get() = UIScreen.mainScreen.scale.toInt()

    actual fun logSystemInfo() {
        NSLog("deviceModel: $deviceModel osName: $osName osVersion: $osVersion density: $density")
    }

}


```





