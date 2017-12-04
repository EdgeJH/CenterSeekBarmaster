
CenterSeekBarmaster
===============
CenterStart Android SeekBar 

![CenterSeekBar](/centerseekbar.gif)

Gradle
------------
```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
```groovy
dependencies {
    compile 'com.github.EdgeJH:CenterSeekBarmaster:1.0.1'
}
```

Usage
--------
```xml
<com.edge.edge_centerseekbar.CenterSeekBar
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="20dp"
    android:layout_centerInParent="true"
    android:layout_marginStart="20dp"
    android:layout_marginEnd="20dp"
    android:progress="50"
    app:seekbar_backgroundtint="@android:color/darker_gray"
    app:seekbar_progresstint="@android:color/black"
    app:seekbar_height="6dp"
    app:seekbar_thumbtint="@android:color/holo_purple"/>
```

```java
 CenterSeekBar centerSeekBar = new CenterSeekBar.Builder().with(getApplicationContext())
                .setThumbColor(R.color.colorAccent)
                .setBackgroundColor(R.color.colorPrimary)
                .setHeight(10f)
                .setProgressColor(R.color.colorPrimaryDark)
                .build();
```

##### Properties:

* `app:seekbar_backgroundtint`
* `app:seekbar_progresstint`
* `app:seekbar_thumbtint`
* `app:seekbar_height`

License
--------
```
Copyright 2017 EdgeJH


Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

```
