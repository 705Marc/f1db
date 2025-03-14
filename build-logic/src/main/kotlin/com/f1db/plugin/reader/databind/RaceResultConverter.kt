package com.f1db.plugin.reader.databind

import com.f1db.plugin.extensions.toMillis
import com.f1db.plugin.schema.single.RaceResult
import com.fasterxml.jackson.databind.util.StdConverter

/**
 * The race result converter.
 *
 * @author Marcel Overdijk
 */
class RaceResultConverter : StdConverter<RaceResult, RaceResult>() {

    override fun convert(raceResult: RaceResult): RaceResult {
        raceResult.positionNumber = raceResult.positionText.toIntOrNull()
        raceResult.timeMillis = raceResult.time.toMillis()
        raceResult.timePenaltyMillis = raceResult.timePenalty.toMillis()
        if (raceResult.gap != null) {
            val lapsRegex = """^\+(\d+) lap(s)?${'$'}""".toRegex()
            val lapsMatchResult = lapsRegex.matchEntire(raceResult.gap)
            if (lapsMatchResult != null) {
                raceResult.gapLaps = lapsMatchResult.groupValues[1].toInt()
            } else {
                raceResult.gapMillis = raceResult.gap.toMillis()
            }
        }
        raceResult.intervalMillis = raceResult.interval.toMillis()
        raceResult.gridPositionNumber = raceResult.gridPositionText?.toIntOrNull()
        return raceResult
    }
}
