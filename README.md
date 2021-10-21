Quake Report App 
===================================

This app display list of earthquake reports from all over the world,
from the U.S. Geological Survey (USGS) organization.
Used an  API to request earthquake data from the USGS web-server in Json format.


More info on the USGS Earthquake API available at:
https://earthquake.usgs.gov/fdsnws/event/1/


- `HTTP Network request` is done on the background thread using `AsyncTask Looaders` and rest everything is on the main `UI thread`
- Used `ListView and Array Adapter` to display the data in `Activity` so it will use less memory 
- Used  `Preference Fragments` for filter and can store the preferences data in the user device 
- Added Empty state Activty ,Progress Bar Activity , Network State activity too 

<img src="https://user-images.githubusercontent.com/76242077/138230838-8b5635bf-d883-4a89-bf5e-35f33283d737.jpg" alt ="no eq" width="200" height="400"> .
<img src="https://user-images.githubusercontent.com/76242077/138230791-d9e62ce4-1668-43f9-bf55-60494f7bec77.jpg" alt ="progress" width="200" height="400"> .
<img src="https://user-images.githubusercontent.com/76242077/138230776-91c78351-371f-4573-97bb-e2deea667f72.jpg" alt ="no internrt" width="200" height="400">


WorkFlow
---------------

https://user-images.githubusercontent.com/76242077/138218271-e56c38e6-acb4-404d-ae40-94f3e88b4bdf.MP4

- The list of live earthquake data is displayed as main screen and by tapping on particular earthquake we will reach USGS website for more details.
- Can apply  filter to select the `minimum magnitude level` and sort the results based on`Magnitude` or `Most Recent`
- By default it will show the earthquake report of `one month` from `today` if we had not set any date limit
- That why its showing `No earthquake found` is displayed when **minimum magnitude** is set to 8 , as one month before 18 Oct, 2021 earthqauke more than 8 didnt occurs 



https://user-images.githubusercontent.com/76242077/138218709-cc1c4d06-7988-4e4d-9a3f-af5923f92d50.MP4

- One more filter we can set date  between we want to see earthqauke report .
- `Set Date` checkbox once checked we can set `starttime` and `endtime` get the report between our desired date 
-  If unchecked then both options are disabled, you can only see recent earthquake for one momth then
- `Order By` option sort the result according to user choices, 
    - ``Most Recent`` will sort according to time in  descending order 
    - ``Magnitude`` will sort according to the maximum magnitude
 
 **You can Download apk from [here](https://github.com/Rohit570git-hub/Quake_Report_App/blob/main/apk/app.apk)**


Pre-requisites
--------------
- Android SDK v30
- Android Build Tools v30.0.3

Getting Started
---------------

This sample uses the Gradle build system. To build this project, use the
"gradlew build" command or use "Import Project" in Android Studio.

