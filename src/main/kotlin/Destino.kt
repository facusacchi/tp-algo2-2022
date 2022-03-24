import java.math.BigDecimal

class Destino(
    pais: String,
    ciudad: String,
    costoBase: BigDecimal
) {

    companion object {
        var LOCALIA = "Argentina"
    }

    var pais = "";
    var ciudad = "";
    var costoBase = BigDecimal(0.0);

    fun esLocal(): Boolean {
        return pais.equals(LOCALIA, ignoreCase = true)
    }

    fun getCosto(usuario: Usuario): BigDecimal {
        var costo = validarAumento();
        costo = validarDescuento(costo, usuario)

        return costo;
    }

    fun esDelMismoPaisQueUsuario(usuario: Usuario): Boolean {
        return pais == usuario.pais
    }

    fun validarAumento(): BigDecimal {
        if(!esLocal()) {
            return costoBase * BigDecimal(1.2);
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