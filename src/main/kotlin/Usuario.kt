import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.*

class Usuario(
    var nombre: String,
    var apellido: String,
    var userName: String,
    var pais: String,
    var fechaAlta: LocalDate = LocalDate.now()
) {



    companion object {
        var ANTIGUEDAD_MAX = 15
    }

    fun calcularAntiguedad(): Int {
        return minOf(ChronoUnit.YEARS.between(fechaAlta, LocalDate.now()).toInt(), ANTIGUEDAD_MAX)
    }

    fun getDescuentoPorAntiguedad(costoBase: BigDecimal): BigDecimal {
        return costoBase * getFactorDeDescuento()
    }

    fun getFactorDeDescuento(): BigDecimal {
        return BigDecimal("0.01") * BigDecimal(calcularAntiguedad())
    }

    fun crear(itinerario: Itinerario) {

    }

    fun editar(itinerario: Itinerario) {

    }
}