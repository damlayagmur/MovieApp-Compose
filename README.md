# Movie App

![Latest Version](https://img.shields.io/badge/latestVersion-1.0-yellow)
![Kotlin](https://img.shields.io/badge/language-kotlin-blue)
![Mininum SDK Version](https://img.shields.io/badge/minSDK-21-orange)
![Android Gradle Version](https://img.shields.io/badge/androidGradleVersion-7.0.4-green)
![Gradle Version](https://img.shields.io/badge/gradleVersion-7.0.2-informational)
## 📦 Modules

Modules are the collection of source files and build settings that allow you to divide your project into discrete units of functionality.

- **Data Module**

  `:data` module contains models, api services and repository classes

- **Domain Module**

  `:domain` module contains use case,repository and mapper classes
  
- **Presentation Module**

  `:presentation` module contains business logic and composable screen

# System Requirements

- Android Studio
- Jetpack Compose
- Clean Architecture
- MVVM
- Flow
- Navigation Component
- Dagger/Hilt
- Glide

# Features

- Get Movie List: Now Playing Movies List and Popular Movies List. In lists page, you can find movie poster, name, duraion and rating.In addition in the Popular Movie List, you can check  movie's overview. When you click movie in the lists page, you redirected Movie Detail Page.
- Movie Detail Page by: movie poster, name,released date, duration, overview and genres.

# Developer's Approach 
- In the Now Playing  API, there is no movie duration parameter. Because of get the duration information for now playing list a for loop is added in the NowPlayingUseCase. Thanks to this for we can get items' movie id and call the Movie Detail API because this API has duration information. 
- In the Rating View part, Image is added in the related Screens and if the movie ratings less than 50%, image will be changed with red. If movie ratings is for 50% and above, image will be changed with green. 

# Screenshots
<p align"center">
<img src="screenshots/Character List Page .png" width="211" height="423" />
<img src="screenshots/Character List - GridView Mode.png" width="211" height="423"  />
<img src="screenshots/Filter:Search Page.png" width="211" height="423"  />
<img src="screenshots/Character Detail Page.png" width="211" height="423" />
</p>
