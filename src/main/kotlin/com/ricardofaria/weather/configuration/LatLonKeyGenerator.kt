package com.ricardofaria.weather.configuration

import org.springframework.cache.interceptor.KeyGenerator
import java.lang.reflect.Method
import java.math.RoundingMode
import java.text.DecimalFormat

class LatLonKeyGenerator : KeyGenerator {

    private val FORMAT = "#.###"
    private val LAT_PARAMETER_POSITION = 0
    private val LON_PARAMETER_POSITION = 1

    override fun generate(p0: Any, p1: Method, vararg params: Any?): Any {
        var lat = params[LAT_PARAMETER_POSITION] as Double
        var lon = params[LON_PARAMETER_POSITION] as Double

        val df = DecimalFormat(FORMAT)
        df.roundingMode = RoundingMode.CEILING

        return df.format(lat) + "-" + df.format(lon)
    }
}
