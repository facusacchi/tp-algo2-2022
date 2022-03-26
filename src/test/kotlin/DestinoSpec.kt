import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class DestinoSpec: DescribeSpec({
    describe("Tests de Destino") {

        it("Un destino es local cuando el país del destino es igual al país de localia") {
            val destino = Destino("argentina","bs as", BigDecimal("25000"))
            destino.esLocal().shouldBeTrue()
        }

        it("Un destino no es local cuando el país del destino es distinto al país de localia") {
            val destino = Destino("Pais del nunca jamas","saraza", BigDecimal("25000"))
            destino.esLocal().shouldBeFalse()
        }

        it("Un destino es del mismo pais que un usuario cuando ambos tienen el mismo pais") {
            val destino = Destino("polonia","polo", BigDecimal("25000"))
            val usuario = Usuario("pepe", "palala", "palapala", "polonia")
            destino.esDelMismoPaisQueUsuario(usuario).shouldBeTrue()
        }

        it("Un destino con pais distinto al pais de localia y tmb distinto al pais del usuario debe costar un 20% mas que su costo base") {
            val destino = Destino("polonia","polo", BigDecimal("1000"))
            val usuario = Usuario("pepe", "palala", "palapala", "argentina")
            destino.getCosto(usuario).shouldBe(BigDecimal("1200.0"))
        }

        it("Un destino con mismo pais al pais de localia y con mismo pais al pais del usuario que lo visita tiene un descuento del 1% del costo base por cada año de antigüedad del usuario") {
            val destinoArgBsAs = Destino("argentina","buenos aires", BigDecimal("1000"))
            val usuarioArg = Usuario("nombre de user 1", "apellido de user", "palapala", "argentina")
            usuarioArg.fechaAlta = usuarioArg.fechaAlta.minusYears(10)
            destinoArgBsAs.getCosto(usuarioArg).shouldBe(BigDecimal("900.00"))
        }

    }
})