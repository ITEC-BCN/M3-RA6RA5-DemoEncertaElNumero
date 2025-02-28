package itb


import javafx.application.Application

fun main() {

    try {
        /* Cridem a la vista de JavaFX API */
        Application.launch(NumeroMagicJavaFXAPI()::class.java)
    }catch (ise: IllegalStateException){
        println("ERROR: Si es tanca finestra de la GUI no es pot llançar més d'un cop mentre la app es troba en execució. S'hauria de generar una nova escena.")
    }catch(e: Exception){
        println("FATAL ERROR: ${e.stackTraceToString()}")
    }

}