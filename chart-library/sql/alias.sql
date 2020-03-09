create alias inTrack for "chartlib.sql.alias.ChartUtil.inTrack";
-- Sample
select chartno from charts where inTrack(38.50, -124.0, 36.50, -122.0, topLeftLat, topLeftLong, bottomRightLat, bottomRightLong) = true;
select chartno from charts where inTrack(37.50, -126.0, 38.25, -120.50, topLeftLat, topLeftLong, bottomRightLat, bottomRightLong) = true;
