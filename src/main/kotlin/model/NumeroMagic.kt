package itb.model

class NumeroMagic {
    private var numero: Int

    constructor() {
        this.numero = (1..100).random()
    }

    fun getNumero(): Int { return this.numero }

    fun mirarEncertat(num: Int): Pair<Boolean, String> {
        var encertat: Boolean = false
        var missatge: String = ""
        if(this.numero == num) {
            encertat = true
            missatge = "L'HAS ENCERTAT!"
        } else {
            if(this.numero>num)
                missatge = "No l'has encertat! El número que busques és major."
            else
                missatge = "No l'has encertat! El número que busques és menor."
        }
        return Pair(encertat, missatge)
    }

    override fun toString(): String {
        return "El número és: ${this.numero}"
    }
}