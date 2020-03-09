//<![CDATA[

/*
 * Put together by 
 * olivier@lediouris.net, 2007.
 *
 */

/*
 * Available icons:
 * http://maps.google.com/mapfiles/ms/icons/blue-dot.png
 * http://maps.google.com/mapfiles/ms/icons/blue.png
 * http://maps.google.com/mapfiles/ms/icons/yellow-dot.png
 * http://maps.google.com/mapfiles/ms/icons/yellow.png
 * http://maps.google.com/mapfiles/ms/icons/sailing.png
 */

var map;

centerlat=0.4394488164;
centerlng=-164.619140625;

var pointarray = new Array();

var n = "N";
var s = "S";
var e = "E";
var w = "W";

var ns = "NS";
var ew = "EW";

var pointfrom = null;
var pointto   = null;

function format(expr, decplaces)
{
  var str = "" + Math.round(eval(expr) * Math.pow(10, decplaces));
  while (str.length <= decplaces)
  {
    str = "0" + str;
  }
  var decpoint = str.length - decplaces;
  return str.substring(0, decpoint) + "." + str.substring(decpoint, str.length);
}

function sexagesimalToDecimal(d, m, sgn)
{
  var value = parseFloat(d);

  value += (parseFloat(m)/60.0);
  if (sgn == "W" || sgn == "S")
    value = -value;
  return value;
}

function decimalToSexagesimal(v, ns_ew)
{
  var s = "";
  var absVal = Math.abs(v);
  var intValue = Math.floor(absVal);
  var dec = absVal - intValue;
  i = intValue;
  dec *= 60;
  s = String(i) + "&deg;" + format(dec, 2) + "'";
  if (v < 0)
  {
    switch(ns_ew)
    {
      case ns:
        s = s + "S";
        break;
      case ew:
        s = s + "W";
        break;
    }
  }
  else
  {
    switch(ns_ew)
    {
      case ns:
        s = s + "N";
        break;
      case ew:
        s = s + "E";
        break;
    }
  }
  return s;
}

function isCloseTo(latlng)
{
  var ptId = -1;
  var minDist = (30 * 1852); // 30 miles
  for (var j=0; j<pointarray.length; j++)
  {
    var pt = new GLatLng(pointarray[j].latitude, pointarray[j].longitude);
    var dist = pt.distanceFrom(latlng);
    if (dist < minDist)
    {
      ptId = j;
      minDist = dist;
//    break;
    }
  }
  return ptId;
}

function loadChart()
{
  map = new GMap2(document.getElementById("map"));
  map.addControl(new GLargeMapControl());
  map.addControl(new GMapTypeControl());
  map.addControl(new GOverviewMapControl());
  map.enableContinuousZoom();
  map.enableDoubleClickZoom();
  map.setCenter(new GLatLng(centerlat, centerlng), 4);
  map.addMapType(G_NORMAL_MAP );
  map.addMapType(G_AERIAL_MAP);
  map.addMapType(G_SATELLITE_MAP);
  map.addMapType(G_SATELLITE_3D_MAP);
  map.addMapType(G_PHYSICAL_MAP );
  map.enableRotation();

//map.setMapType(G_SATELLITE_MAP);
  map.setMapType(G_HYBRID_MAP);
  map.enableScrollWheelZoom();

  GEvent.addListener(map, "moveend", function()
                                     {
                                        var center = map.getCenter();
                                        document.getElementById("center-lat").innerHTML = decimalToSexagesimal(center.lat(), ns);
                                        document.getElementById("center-lng").innerHTML = decimalToSexagesimal(center.lng(), ew);
//                                      GLog.write("Lat:" + center.lat());
//                                      GLog.write("Lng:" + center.lng());
                                     });
  GEvent.addListener(map, "mousemove", function(latlng)
                                       {
                                         document.getElementById("mouse-lat").innerHTML = decimalToSexagesimal(latlng.lat(), ns);
                                         document.getElementById("mouse-lng").innerHTML = decimalToSexagesimal(latlng.lng(), ew);
                                         var prox = isCloseTo(latlng);
                                         if (prox > -1)
                                         {
                                           document.getElementById("mouse-place").innerHTML = pointarray[prox].text;
                                         }
                                       });
  GEvent.addListener(map, "click", function(overlay, latlng)
                                   {
//                                   alert("You clicked the map at " + latlng);
                                     if (pointfrom == null)
                                       pointfrom = latlng;
                                     else
                                     {
                                       pointto = latlng;
                                       var distance = pointfrom.distanceFrom(pointto);
//                                     GLog.write("That's " + distance + " meters, " + (distance / 1852.0) + " mn.");
                                       var mess = "Distance from<br>";
                                       mess += (decimalToSexagesimal(pointfrom.lat(), ns) + " / " + decimalToSexagesimal(pointfrom.lng(), ew) + "<br>to<br>");
                                       mess += (decimalToSexagesimal(pointto.lat(), ns) + " / " + decimalToSexagesimal(pointto.lng(), ew) + "<br>");
                                       mess += (format((distance / 1852.0), 0) + " nm");
                                       document.getElementById("mouse-dist").innerHTML = mess;

                                       var points = [];
                                       points.push(new GLatLng(pointfrom.lat(), pointfrom.lng()));
                                       points.push(new GLatLng(pointto.lat(), pointto.lng()));
                                       map.addOverlay(new GPolyline(points, "#ffff00", 3, 0.9));                                       

                                       pointto = pointfrom = null;
                                     }
                                   });
  function createMarker(point, label, icon) 
  {
    var marker = new GMarker(point, icon);
    GEvent.addListener(marker, "click", function() 
      {
        marker.openInfoWindowHtml(label);
      });
    return marker;
  }
  // Any position to plot?
  if (date2display.length > 0)
  {    
    var dpicon = new GIcon();
//  dpicon.image  = "./donpedro.png";
    dpicon.image  = "http://maps.google.com/mapfiles/ms/icons/sailing.png";
    dpicon.iconSize = new GSize(46, 42);
    dpicon.iconAnchor = new GPoint(23, 21);
    dpicon.infoWindowAnchor = new GPoint(23, 21);
    var dppos = new GLatLng(lat2plot, lng2plot);
    var mess = "<b>Don Pedro is here</b><br>" +
               "<b>Latitude</b>:" + decimalToSexagesimal(lat2plot, ns) + "<br>" +
               "<b>Longitude</b>:" + decimalToSexagesimal(lng2plot, ew) + "<br>" +
               unescape(date2display);
    map.addOverlay(createMarker(dppos, mess, dpicon));            
    
//map.openInfoWindowHtml(dppos, mess);   
  }                                     
}

var lat2plot     = 0.0;
var lng2plot     = 0.0;
var date2display = '';

function load()
{
  var latitude = '';
  var longitude = '';
  var currentdate = '';
  
  latitude    = getPrm('latitude');
  longitude   = getPrm('longitude');
  currentdate = getPrm('currentdate');
  
  if (latitude.length > 0 &&
      longitude.length > 0 &&
      currentdate.length > 0)
  {
//  alert('Found something:' + latitude + ', ' + longitude + ', ' + currentdate);
    lat2plot = parseFloat(latitude);
    lng2plot = parseFloat(longitude);
    date2display = currentdate;
  }   
  else
    date2display = '';   
  
  if (GBrowserIsCompatible())
  {
    loadChart();
//  loadData();
    drawGRIBWind();
  }
}

function load4fax()
{
  var latitude = '';
  var longitude = '';
  
  latitude    = getPrm('latitude');
  longitude   = getPrm('longitude');
  
  if (latitude.length > 0 &&
      longitude.length > 0)
  {
//  alert('Found something:' + latitude + ', ' + longitude + ', ' + currentdate);
    lat2plot = parseFloat(latitude);
    lng2plot = parseFloat(longitude);
  }   
  
  if (GBrowserIsCompatible())
  {
    loadChart();
//  alert("Loading " + faxarray.length + " faxes");
    for (i=0; i<faxarray.length; i++)
    {
      
      faxOverlay(faxarray[i].top, 
                 faxarray[i].bottom, 
                 faxarray[i].left, 
                 faxarray[i].right, 
                 "./" + faxarray[i].name);
    }    
  }
}

function datapoint(latitude, longitude, text, latstr, lngstr)
{
  this.latitude = latitude;
  this.longitude = longitude;
  this.text = text;
  this.latstr = latstr;
  this.lngstr = lngstr;
}

function loadData()
{
  GDownloadUrl("places.xml", function (data, responseCode)
                                    {
                                      var xml = GXml.parse(data);
                                      var markers = xml.documentElement.getElementsByTagName("place");
                                      pointarray = new Array(markers.length);

                                      for (var i=0; i<markers.length; i++)
                                      {
                                        latnode = markers[i].getElementsByTagName("latitude");
                                        lngnode = markers[i].getElementsByTagName("longitude");
                                        var lat = sexagesimalToDecimal(latnode[0].getAttribute("deg"),
                                                                       latnode[0].getAttribute("min"),
                                                                       latnode[0].getAttribute("sign"));
                                        var lng = sexagesimalToDecimal(lngnode[0].getAttribute("deg"),
                                                                       lngnode[0].getAttribute("min"),
                                                                       lngnode[0].getAttribute("sign"));
                                        pointarray[i] = new datapoint(lat,
                                                                      lng,
                                                                      markers[i].getAttribute("name"),
                                                                      latnode[0].getAttribute("deg") + "&deg;" + latnode[0].getAttribute("min") + "&apos;" + latnode[0].getAttribute("sign"),
                                                                      lngnode[0].getAttribute("deg") + "&deg;" + lngnode[0].getAttribute("min") + "&apos;" + lngnode[0].getAttribute("sign"));
                                      }
                                    });
}

function plotMarkers()
{
  for (var i=0; i<pointarray.length; i++)
  {
    var point = new GLatLng(pointarray[i].latitude,
                            pointarray[i].longitude);
    map.addOverlay(createMarker(point, i));
  }
}

function openWindow(url, name, w, h)
{
  var nw = window.open(url, name, 'height=' + h + ',width=' + w + ',status=no,resizable=yes,scrollbars=yes');
  nw.focus();
}

// Link to produce: <a href="javascript:openWindow('displaymap.html?zoom=11&latitude=-19.053032&longitude=-169.841766&end', 'Niue', 640, 480);">XXXX</a>
function createInfoData(i)
{
  var content = "";
  content = "<font face='Tahoma'><small>" +
            "<b><a href=\"javascript:openWindow('../displaymap.html?zoom=11&latitude=" + pointarray[i].latitude + "&longitude=" + pointarray[i].longitude + "&end', '" + pointarray[i].text + "', 640, 480);\">" +
              pointarray[i].text + 
            "</a></b><br>" +
            pointarray[i].latstr + "<br>" +
            pointarray[i].lngstr + "</small></font>";
//GLog.write("Content:" + content);
  return content;
}

function createMarker(point, i)
{
  var marker = new GMarker(point);
  GEvent.addListener(marker, "click", function()
                                      {
                                        marker.openInfoWindowHtml(createInfoData(i));
                                      });
  return marker;
}

function clearChart()
{
  map.clearOverlays();
}

function getPrm(prmName)
{
  var loc = document.location.toString();
  var i = loc.indexOf(prmName + "=");      
  var value = '';
  if (i > -1)
  {
    str = loc.substr((prmName.length + 1)+i);
    var j = str.indexOf('&');
    if (j > -1)
      value = str.substr(0, j);
    else
      value = str;
  }
//alert(prmName + " = " + value);    
  return value;
}

function drawGRIBWind()
{
//alert("drawGRIBWind");
  
  for (i=0; i<windpoint.length; i++)
  {
//  GLog.write("Lat:" + windpoint[i].lat + ", Lng:" + windpoint[i].lng + ", Speed:" + windpoint[i].speed + ", Dir:" + windpoint[i].dir);
	  drawWindFeather(windpoint[i].lat,
	                  windpoint[i].lng,
	                  windpoint[i].speed,
	                  windpoint[i].dir);
  }
}

var SPEED_PRM = 2.0;

function drawWindFeather(lat, lng, speed, dir)
{
  var points = [];  
  points.push(new GLatLng(lat, lng));
  
  var onedash = false;
  if (onedash)
  	points.push(deadReckoning(lat, lng, speed * SPEED_PRM, dir));
  else
  {
  	points.push(deadReckoning(lat, lng, speed * SPEED_PRM, dir - 10));
  	points.push(deadReckoning(lat, lng, speed * SPEED_PRM * 0.9, dir));
  	points.push(deadReckoning(lat, lng, speed * SPEED_PRM, dir + 10));
  	points.push(new GLatLng(lat, lng));
  }
	
	var color = "#ffff00"; // yellow
	
	var lightblue = "#00ffff";
	var green     = "#00ff00";
	var yellow    = "#ffff00";
	var orange    = "#ff8000";
	var red       = "#ff0000";
	
	if (speed < 10) color = lightblue;
	else if (speed < 20) color = green;
	else if (speed < 30) color = yellow;
	else if (speed < 40) color = orange;
	else color = red;
	
  map.addOverlay(new GPolyline(points, color, 1, 0.9));                                       
}

function getWindColor(speed)
{  
  return color;
}

function deadReckoning(l, g, s, d)
{
  deltaL = (s / 60) * Math.cos(toRadians(d));
  l2 = l + deltaL;
  lc1 = getIncLat(l);
  lc2 = getIncLat(l2);
  deltaLc = lc2 - lc1;
  deltaG = deltaLc * Math.tan(toRadians(d));
  g2 = g + deltaG;
  return new GLatLng(l2, g2);
}

function getIncLat(lat)
{
  il = Math.log(Math.tan((Math.PI / 4) + (toRadians(lat) / 2)));
  return toDegrees(il);
}

function toRadians(d)
{
  return Math.PI * d / 180;
}

function toDegrees(d)
{
  return d * 180 / Math.PI;
}
    
function getDate()
{
  var loc = document.location.toString();
  var i = loc.indexOf("date=");
  var defaultDate = '';
  if (i > -1)
  {
    defaultDate = loc.substr(5+i);
  }
  else
    defaultDate = '';
      
  return defaultDate;
}      
    
function faxOverlay(top, bottom, left, right, img)
{
//alert("Loading fax " + img);
  var boundaries = new GLatLngBounds(new GLatLng(bottom, left), new GLatLng(top, right));
  var overlay = new GGroundOverlay(img, boundaries);
  map.addOverlay(overlay);
  overlay.show();
}    
//]]>
