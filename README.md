# AcharyaOne
AcharyaOne Android App.

#How to build.

1. **Install gradle**
  * **On Mac**
    * Install gradle using homebrew
    * ```brew install gradle```

  * **On Windows** 
    * Unzip the Gradle download to the folder to which you would like to install Gradle, eg. “C:\Program Files”. The subdirectory gradle-x.x will be created from the archive, where x.x is the version.
    * Add location of your Gradle “bin” folder to your path. Open the system properties (WinKey + Pause), select the “Advanced” tab, and the “Environment Variables” button, then add “C:\Program Files\gradle-x.x\bin” (or wherever you unzipped Gradle) to the end of your “Path” variable under System Properties. Be sure to omit any quotation marks around the path even if it contains spaces. Also make sure you separated from previous PATH entries with a semicolon “;”.
    * In the same dialog, make sure that JAVA_HOME exists in your user variables or in the system variables and it is set to the location of your JDK, e.g. C:\Program Files\Java\jdk1.7.0_06 and that %JAVA_HOME%\bin is in your Path environment variable.
    * Open a new command prompt (type cmd in Start menu) and run gradle –version to verify that it is correctly installed.

2. **Android Studio** 
  * Once you have downloaded gradle and android studio, 
    * On android studio select Import from git. 
    * Enter the repo url 'https://github.com/negati-ve/AcharyaOne' 
    * Sit back and relax while gradle does the rest
