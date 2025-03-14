package com.f1db.plugin.schema.mapper

import com.f1db.plugin.schema.single.Season
import com.f1db.plugin.schema.single.SeasonConstructorStanding
import org.mapstruct.AfterMapping
import org.mapstruct.Context
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingTarget
import com.f1db.plugin.schema.splitted.SeasonConstructorStanding as SplittedSeasonConstructorStanding

/**
 * The season constructor standing mapper.
 *
 * @author Marcel Overdijk
 */
@Mapper
interface SeasonConstructorStandingMapper {

    @Mapping(target = "year", ignore = true)
    fun toSplittedSeasonConstructorStanding(seasonConstructorStanding: SeasonConstructorStanding, @Context season: Season): SplittedSeasonConstructorStanding

    fun toSplittedSeasonConstructorStandings(seasonConstructorStandings: List<SeasonConstructorStanding>, @Context season: Season): List<SplittedSeasonConstructorStanding>

    @AfterMapping
    fun afterMapping(@MappingTarget splittedSeasonConstructorStanding: SplittedSeasonConstructorStanding, @Context season: Season) {
        splittedSeasonConstructorStanding.year = season.year
    }
}
