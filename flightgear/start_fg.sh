fgfs --geometry=480x360 \
--aircraft=c172p \
--timeofday=noon \
--disable-real-weather-fetch \
--generic=socket,out,10,localhost,10500,udp,fgcontrol \
--generic=socket,in,10,localhost,10501,udp,fgcontrol \
--httpd=10502
