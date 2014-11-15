fgfs --geometry=480x360 \
--aircraft=c172p \
--timeofday=noon \
--disable-real-weather-fetch \
--generic=socket,out,2,localhost,10500,udp,fgcontrol \
--generic=socket,in,2,localhost,10501,udp,fgcontrol \
--telnet=10503 \
--httpd=10502
