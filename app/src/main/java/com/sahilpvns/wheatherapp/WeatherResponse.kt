package com.sahilpvns.wheatherapp


data class WeatherResponseItem(
    val Version: Int,
    val Key: String,
    val Type: String,
    val Rank: Int,
    val LocalizedName: String,
    val EnglishName: String,
    val PrimaryPostalCode: String,
    val Region: Region,
    val Country: Country,
    val AdministrativeArea: AdministrativeArea,
    val TimeZone: TimeZone,
    val GeoPosition: GeoPosition,
    val IsAlias: Boolean,
    val SupplementalAdminAreas: List<SupplementalAdminArea>,
    val DataSets: List<String>,
    val ParentCity: ParentCity
)

data class Region(
    val ID: String,
    val LocalizedName: String,
    val EnglishName: String
)

data class Country(
    val ID: String,
    val LocalizedName: String,
    val EnglishName: String
)

data class AdministrativeArea(
    val ID: String,
    val LocalizedName: String,
    val EnglishName: String,
    val Level: Int,
    val LocalizedType: String,
    val EnglishType: String,
    val CountryID: String
)

data class TimeZone(
    val Code: String,
    val Name: String,
    val GmtOffset: Double,
    val IsDaylightSaving: Boolean,
    val NextOffsetChange: Any
)

data class GeoPosition(
    val Latitude: Double,
    val Longitude: Double,
    val Elevation: Elevation
)

data class Elevation(
    val Metric: Metric,
    val Imperial: Imperial
)

data class Metric(
    val Value: Int,
    val Unit: String,
    val UnitType: Int
)

data class Imperial(
    val Value: Int,
    val Unit: String,
    val UnitType: Int
)


data class SupplementalAdminArea(
    val Level: Int,
    val LocalizedName: String,
    val EnglishName: String
)

data class ParentCity(
    val Key: String,
    val LocalizedName: String,
    val EnglishName: String
)

