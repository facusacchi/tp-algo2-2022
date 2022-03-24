import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.*

class Usuario(
    nombre: String = "",
    apellido: String = "",
    userName: String = "",
    fechaAlta: LocalDate = LocalDate.now(),
    antiguedad: Int = 0,
    pais: String = ""
) {
    var nombre: String = ""
    var apellido: String = ""
    var userName: String = ""
    var fechaAlta: LocalDate = LocalDate.of(1,1,1)
    var antiguedad: Int = 0
    var pais: String = ""

    companion object {
        var ANTIGUEDAD_MAX = 15
    }

    private fun calcularAntiguedad(): Int {
        return minOf(ChronoUnit.YEARS.between(fechaAlta, LocalDate.now()).toInt(), ANTIGUEDAD_MAX)
    }

    fun getDescuentoPorAntiguedad(costoBase: BigDecimal): BigDecimal {
        return costoBase * getFactorDeDescuento()
    }

    fun getFactorDeDescuento(): BigDecimal {
        return BigDecimal(0.1) * BigDecimal(calcularAntiguedad()) + BigDecimal(1)
    }

    fun crear(itinerario: Itinerario) {

    }

    fun editar(itinerario: Itinerario) {

    }
}