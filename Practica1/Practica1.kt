import java.time.LocalDate
import java.time.Period
import java.time.temporal.ChronoUnit

fun solicitarNumeros() {
    println("Introduce tres números:")
    val num1 = readln().toDouble()
    val num2 = readln().toDouble()
    val num3 = readln().toDouble()
    println("Resultado de la suma: ${num1 + num2 + num3}")
}

fun capturarNombre() {
    println("Introduce tu nombre completo:")
    val nombre = readln()
    println("TU NOMBRE ES: $nombre")
}

fun TiempoVida() {
    println("Introduce tu fecha de nacimiento (YYYY-MM-DD):")
    val fechaNacimiento = LocalDate.parse(readln())
    val fechaActual = LocalDate.now()
    val diferencia = Period.between(fechaNacimiento, fechaActual)
    val diasTotales = ChronoUnit.DAYS.between(fechaNacimiento, fechaActual)

    println("Tiempo transcurrido desde tu nacimiento:")
    println("${diferencia.years * 12 + diferencia.months} meses")
    println("${diasTotales / 7} semanas")
    println("$diasTotales días")
    println("${diasTotales * 24} horas")
    println("${diasTotales * 1440} minutos")
    println("${diasTotales * 86400} segundos")
}

fun cerrarPrograma() {
    println("Finalizando el programa...")
    System.exit(0)
}

fun Menu() {
    while (true) {
        println("\nOpciones disponibles:")
        println("1. Sumar tres números")
        println("2. Introducir nombre completo")
        println("3. Calcular tiempo transcurrido")
        println("4. Salir")
        print("Elige una opción: ")

        when (readln()) {
            "1" -> solicitarNumeros()
            "2" -> capturarNombre()
            "3" -> TiempoVida()
            "4" -> cerrarPrograma()
            else -> println("Opción no válida, intenta nuevamente.")
        }
    }
}

fun main() {
    Menu()
}
