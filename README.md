# APOD
# Introduction
The APOD application will show the Astronomy Picture of the Day,This will work on offline also.


# Technologies
*Kotlin 
*Room
*Retrofit
*Hilt
*Picasso
*Gson


# Screenshots

senario: When user Offline
https://github.com/saravanansurf3/NASA_APOD/blob/SaravanakumarThirumoorthy-WalE/screenshots/sc_offline.jpg


senario: When user online
https://github.com/saravanansurf3/NASA_APOD/blob/SaravanakumarThirumoorthy-WalE/screenshots/sc_with_internet.jpg

senario: When user online before on the same day, but offline just now 
https://github.com/saravanansurf3/NASA_APOD/blob/SaravanakumarThirumoorthy-WalE/screenshots/sc_without_internet.jpg


senario: When user online yesterday,
https://github.com/saravanansurf3/NASA_APOD/blob/SaravanakumarThirumoorthy-WalE/screenshots/sc_yesterday_online.jpg

senario: When user online yesterday,but offline today
https://github.com/saravanansurf3/NASA_APOD/blob/SaravanakumarThirumoorthy-WalE/screenshots/sc_today_offline_with%20yesterday_data.jpg


senario: something went wrong with server
https://github.com/saravanansurf3/NASA_APOD/blob/SaravanakumarThirumoorthy-WalE/screenshots/server_not_reachable.jpg



# To do(Future Enhancement)
Currently the Local cache of image is handled by Picasso (https://square.github.io/picasso/),
if we store more number of images we need to use our own local storage to do cache.

