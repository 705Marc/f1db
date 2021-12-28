INSERT INTO race_data
( race_id
, type
, position_display_order
, position_number
, position_text
, driver_number
, driver_id
, constructor_id
, engine_manufacturer_id
, tyre_manufacturer_id
, pit_stop_stop
, pit_stop_lap
, pit_stop_time
, pit_stop_time_millis
)
VALUES
( ?1.id
, ?2.type
, ?2.positionDisplayOrder
, ?3.positionNumber
, ?3.positionText
, ?3.driverNumber
, ?3.driverId
, ?3.constructorId
, ?3.engineManufacturerId
, ?3.tyreManufacturerId
, ?3.stop
, ?3.lap
, ?3.time
, ?3.timeMillis
);
