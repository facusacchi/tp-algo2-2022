import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class UsuarioSpec: DescribeSpec({
    describe("Tests de Usuario") {
        it("Calcular la antiguedad para un usuario con determinada fecha de alta") {
            val usuario = Usuario("pepe", "palala", "palapala", "polonia")
            usuario.fechaAlta = usuario.fechaAlta.minusYears(5)
            usuario.calcularAntiguedad().shouldBe(5)
        }

        it("El factor de descuento debe ser el 1% del costo base por cada año de antigüedad") {
            val usuario = Usuario("pepe", "palala", "palapala", "polonia")
            usuario.fechaAlta = usuario.fechaAlta.minusYears(1)
            usuario.getFactorDeDescuento().shouldBe(BigDecimal("0.01"))
        }

        it("El descuento por antiguedad debe ser el costo base multiplicado por el factor de descuento ") {
            val usuario = Usuario("pepe", "palala", "palapala", "polonia")
            usuario.fechaAlta = usuario.fechaAlta.minusYears(1)
            usuario.getDescuentoPorAntiguedad(BigDecimal("1000")).shouldBe(BigDecimal("10.00"))
        }
    }
})