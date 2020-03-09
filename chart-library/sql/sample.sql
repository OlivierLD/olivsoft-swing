echo To go from 38.50 N, 124.0 W to 36.50 N, 122.0 W:
select 'You want to take chart #' || chartno || ' ' || title  as "Take those:" from charts where inTrack(38.50, -124.0, 36.50, -122.0, topLeftLat, topLeftLong, bottomRightLat, bottomRightLong) = true;
echo To go from 37.50 N, 126.0 W to 38.25 N, 120.50 W:
select 'You want to take chart #' || chartno || ' ' || title as "Take those:" from charts where inTrack(37.50, -126.0, 38.25, -120.50, topLeftLat, topLeftLong, bottomRightLat, bottomRightLong) = true;
