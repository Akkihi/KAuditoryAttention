package akkihi.KAuditoryAttention.utils

import kotlin.math.log2
import kotlin.math.sqrt
import kotlin.random.Random

fun Random.nextGaussian(): Double {
    var spare: Double? = null
    var isSpareReady = false

    if (isSpareReady) {
        isSpareReady = false
        return spare!!
    } else {
        var u: Double
        var v: Double
        var s: Double

        do {
            u = 2.0 * Random.nextDouble() - 1.0
            v = 2.0 * Random.nextDouble() - 1.0
            s = u * u + v * v
        } while (s >= 1 || s == 0.0)

        val multiplier = sqrt(-2.0 * log2(s) / s)
        spare = v * multiplier
        isSpareReady = true

        return u * multiplier
    }
}