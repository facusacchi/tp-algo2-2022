import java.math.BigDecimal

class Destino(
    var pais: String,
    var ciudad: String,
    var costoBase: BigDecimal
) {

    companion object {
        var LOCALIA = "Argentina"
    }

    fun esLocal(): Boolean {
        return pais.equals(LOCALIA, ignoreCase = true)
    }

    fun getCosto(usuario: Usuario): BigDecimal {
        var costo = validarAumento();
        return validarDescuento(costo, usuario)
    }

    fun esDelMismoPaisQueUsuario(usuario: Usuario): Boolean {
        return pais.equals(usuario.pais, ignoreCase = true)
    }

    fun validarAumento(): BigDecimal {
        if(!esLocal()) {
            return costoBase * BigDecimal("1.2");
        }
        return costoBase
    }

    fun validarDescuento(costo: BigDecimal, usuario: Usuario): BigDecimal {
        if(esDelMismoPaisQueUsuario(usuario)) {
           return costo - usuario.getDescuentoPorAntiguedad(costoBase)
        }
        return costo
    }
}