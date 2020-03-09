@setlocal
@echo off
set OPTIONS=
set OPTIONS=%OPTIONS%-fromL 37.325
set OPTIONS=%OPTIONS% -fromG -122.0
set OPTIONS=%OPTIONS% -toL -9.25
set OPTIONS=%OPTIONS% -toG -139.10
set OPTIONS=%OPTIONS% -startTime "2012-03-10T12:10:11"
set OPTIONS=%OPTIONS% -grib "D:\OlivSoft\all-scripts\GRIBFiles\2012\03\GRIB_2012_03_01_08_22_55_PST.grb"
set OPTIONS=%OPTIONS% -polars "D:\OlivSoft\all-scripts\polars\cheoy-lee-42-polar-coeff.xml"
set OPTIONS=%OPTIONS% -output "out.csv"
:: set OPTIONS=%OPTIONS% -speedCoeff 0.75
set OPTIONS=%OPTIONS% -speedCoeff 1.0
set OPTIONS=%OPTIONS% -verbose y
set OPTIONS=%OPTIONS% -timeInterval 12
cli.routing %OPTIONS%
@endlocal
