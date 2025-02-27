/*package itb.view

import javafx.application.Application
import javafx.geometry.Insets
import javafx.stage.Stage
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
//import model.Color
//import model.TipusOperacio
//import org.example.utils.CalculadoraController.div
//import org.example.utils.CalculadoraController.multi
//import org.example.utils.CalculadoraController.resta
//import org.example.utils.CalculadoraController.suma

class NumeroMagicJavaFXAPI: Application () { //fem servir el constructor sense paràmetres
    override fun start(primerStage: Stage) {
        /* Declarem els atributs de la vista */
        val txtNumeroUsuari = TextField()
        val btnJugar = Button("JUGAR!")
        val lblMissatge = Label()
    }

    /*btnJugar.setOnAction {

    }*/


    // Definim un container vertical (una columna d'elements a mostrar a la GUI)
    val vBox = VBox(10.0)
    vBox.children.addAll(
    Label("Introdueix el primer número:"),
    txtPrimerOperador,
    Label("Introdueix el segon número:"),
    txtSegonOperador,
    // Li afegim tots els elements de
    l'horitzontal box que hem creat abans
    filaButonsOperacions,
    lblResultat
    )





}*/

package itb

import javafx.application.Application
import javafx.geometry.Insets
import javafx.stage.Stage
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.image.Image
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import model.Color
import model.TipusOperacio
import org.example.utils.NumeroMagicController.encertat

class NumeroMagicJavaFXAPI: Application() {

    override fun start(primerStage: Stage) {
        /* Declarem els atributs de la vista */
        var numeroMagic: Int = (0..100).random()
        var numeroIntents: Int = 5

        // Declarem els elements que tindrà el nostre formulari
        val lblCapcalera = Label("Introdueix el teu número:")
        val txtNumeroUsuari = TextField()
        val btnJugar = Button("JUGAR!")
        val btnTornarJugar = Button("TORNAR A JUGAR!")
        btnTornarJugar.isVisible = false
        val lblMissatge = Label("el número és: $numeroMagic")   //xivato per poder jugar
        val lblNumeroIntents = Label("Et queden $numeroIntents intents")

        /* Definim el comportament de les accions de l'acció clickar damunt de cadascun dels botons */
        btnJugar.setOnAction {
            if(esNumeric(txtNumeroUsuari)) {
                numeroIntents--
                if(numeroIntents>0) {
                    val numeroUsuari = txtNumeroUsuari.text.toInt()
                    val resultat: Pair<Boolean, String> = encertat(numeroMagic, numeroUsuari)
                    lblMissatge.text = resultat.second
                    if(resultat.first){
                        // un cop finalitzada la partida, amaguem i mostrem els botons que correspon
                        lblCapcalera.isVisible = false
                        txtNumeroUsuari.isVisible = false
                        btnJugar.isVisible = false
                        lblNumeroIntents.isVisible = false
                        btnTornarJugar.isVisible = true
                    }
                    lblNumeroIntents.text = "Et queden $numeroIntents intents"
                } else {
                    // un cop finalitzada la partida, amaguem i mostrem els botons que correspon
                    lblCapcalera.isVisible = false
                    lblNumeroIntents.text = "T'has quedat sense intents, el número era $numeroMagic"
                    btnJugar.isVisible = false
                    lblMissatge.isVisible = false
                    txtNumeroUsuari.isVisible = false
                    btnTornarJugar.isVisible = true
                }
            } else {
                lblMissatge.text = "El valor introduït no és numèric"
            }
        }

        // Tornem a generar els valors inicials i a mostrar els elements que han de ser visibles
        btnTornarJugar.setOnAction {
            numeroMagic = (0..100).random()
            numeroIntents = 5
            txtNumeroUsuari.text = ""
            lblCapcalera.isVisible = true
            txtNumeroUsuari.isVisible = true
            btnJugar.isVisible = true
            lblMissatge.isVisible = true
            lblMissatge.text = "el número és: " + numeroMagic   //xivato per poder jugar
            lblNumeroIntents.isVisible = true
            btnTornarJugar.isVisible = false
        }

        // Definim un container vertical (una columna d'elements a mostrar a la GUI)
        val vBox = VBox(10.0)
        vBox.padding = Insets(20.0) // Aquesta línia estableix un marge intern (padding) de 20 píxels a tots els costats del contenidor VBox.
        vBox.children.addAll(
            lblCapcalera,
            txtNumeroUsuari,
            btnJugar, // Li afegim tots els elements de l'horitzontal box que hem creat abans
            btnTornarJugar,
            lblMissatge,
            lblNumeroIntents
        )

        // Definim la finestra emergent amb el seu contingut vbox i la seva mida en píxels horitzontal i vertical
        val scene = Scene(vBox, 350.0, 200.0)
        // Definim el títol que es mostrarà a la finestra emergent
        primerStage.icons.add(Image("icon.png"))
        primerStage.title = "Encerta el número!"
        // Li assignem l'escena creada a l'atribut scene a la finestra GUI del nostre programa 'primerStage'
        primerStage.scene = scene
        // Fem que aparegui la finestra de la GUI
        primerStage.isResizable = false
        primerStage.show()
    }

    private fun esNumeric(textField: TextField): Boolean {
        var esNumero: Boolean = true
        var numero: Int

        try {
            numero = textField.text.toInt()
        }catch (e: NumberFormatException){
            esNumero = false
        }

        return esNumero
    }

}
