package com.sahilpvns.wheatherapp

data class WheatherDetailsResponse(
    val Headline: Headline,
    val DailyForecasts: List<DailyForecast>
)

data class Headline(
    val EffectiveDate: String,
    val EffectiveEpochDate: Int,
    val Severity: Int,
    val Text: String,
    val Category: String,
    val EndDate: String,
    val EndEpochDate: Int,
    val MobileLink: String,
    val Link: String
)

data class DailyForecast(
    val Date: String,
    val EpochDate: Int,
    val Temperature: Temperature,
    val Day: Day,
    val Night: Night,
    val Sources: List<String>,
    val MobileLink: String,
    val Link: String
)

data class Temperature(
    val Minimum: Minimum,
    val Maximum: Maximum
)

data class Minimum(
    val Value: Int,
    val Unit: String,
    val UnitType: Int
)

data class Maximum(
    val Value: Int,
    val Unit: String,
    val UnitType: Int
)

data class Day(
    val Icon: Int,
    val IconPhrase: String,
    val HasPrecipitation: Boolean,
    val PrecipitationType: String,
    val PrecipitationIntensity: String
)

data class Night(
    val Icon: Int,
    val IconPhrase: String,
    val HasPrecipitation: Boolean
)

