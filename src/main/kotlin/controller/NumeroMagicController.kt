package org.example.utils

/**
 * Classe singleton Calculadora.
 * D'aquesta classe només se'n podrà crear un objecte.
 * S'usa a mode de llibreria d'atributs i mètodes similar al concepte de classe estàtica
 * que podem trobar a Java.
 * @author dmarin-itb
 */
object NumeroMagicController {
    /**
     * Funció que comproba si s'ha encertat el número i retorna un booleà indicant'ho i un missatge per informar a l'usuari
     * @author dmarin-itb
     * @param numeroMagic valor del número a encertar
     * @param numeroUsuari valor del número introduït per l'usuari
     * @return retorna una parella de dades, un booleà que indica si s'ha encertat o no, i un string amb el missatge de sortida
     */
    internal fun encertat(numeroMagic: Int, numeroUsuari: Int): Pair<Boolean, String>{
        var encertat: Boolean = false
        var missatge: String = ""
        if(numeroMagic == numeroUsuari) {
            encertat = true
            missatge = "L'HAS ENCERTAT!"
        } else {
            if(numeroMagic>numeroUsuari)
                missatge = "No l'has encertat! El número que busques és major."
            else
                missatge = "No l'has encertat! El número que busques és menor."
        }
        return Pair(encertat, missatge)
    }

}