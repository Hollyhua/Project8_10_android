# **MyCoffee List**

## Table of Contents

1. [App Overview](#App-Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
1. [Build Notes](#Build-Notes)

## App Overview 


### Description 

**Our project will create an app that displays a scrollable list of coffee images with their names and descriptions from the Coffee API, with the searchable and favorite function.**

### App Evaluation

<!-- Evaluation of your app across the following attributes -->

- **Category:** Lifestyle/Food
- **Mobile:** Mobile is essential for the instant browsing. It is used for checking a list of available coffee flavors that cafes can add to their menu. The user also can search for the name of the coffee that they want to purchase.
- **Story:** Shows a scrollable list of coffee items with their name, images, and descriptions that baristas can add to their "favorites" list.
- **Market:** Any coffee enthusiast or barista can use this app. The API is constantly expanding its coffee datasets which are available online for free.
- **Habit:** Users can access it anytime throughout the day for inspiration and ideas for different crafts to make with their coffee.
- **Scope:** We do not intend to create separate versions of this app. This app should automatically update based on the dataset uploaded in the Coffee API used.

## Product Spec

### 1. User Features (Required and Optional)

Required Features:

- **Display a scrollable list of coffee items.**
- **Display the name, image, and description of each coffee item.**
- **When clicked at the top, user can search through the coffee items**

Stretch Features:

- **Search for a coffee query.**
- **Implement Dark Mode**
- **Allow multiple lists apart from the default "favorites" list.**
- **Remove an item from the favorites list.**

### 2. Chosen API(s)
- **Get Coffee Images**
  - User can search for a type of coffee
  - User can filter results by name of coffee
- **<a href="https://api.sampleapis.com/coffee/hot" target="_blank">Sample API Hot Coffee</a>**
- *Stretch:* **<a href="https://api.sampleapis.com/coffee/iced" target=_blank>Sample API Iced Coffee</a>**

### 3. User Interaction

Required Feature

- **Display Coffee:** User can scroll for list of coffee.
  - => **user can tap on a coffee image.**
  - => **user can search the coffee by entering the name.**
  - => **coffee item gets added to list.**

## Wireframes (Hand Sketched)

<!-- Add picture of your hand sketched wireframes in this section -->
Main Landing Page:


<img src="https://i.imgur.com/mNtMWyc.jpg" width=600>

Coffee Browse Section:


<img src="https://i.imgur.com/tcC1Aai.jpg" width=600>

Favorites Page:


<img src="https://i.imgur.com/Witpzqu.jpg" width=600>


### [BONUS] Digital Wireframes & Mockups
Figma Link: https://www.figma.com/file/KqYIhrkoSIccYCD4wjUg90/Coffee-App?type=design&node-id=0%3A1&mode=design&t=Qq4z58lBmQhlGZx7-1

### [BONUS] Interactive Prototype

Use the same Figma link and run! it should show the working prototype :)

## Build Notes
Here's a place for any other notes on the app, it's creation 
process, or what you learned this unit!  
We are still working on creating a favorite list that user can add their favorite coffee into the list, which is also like the shopping list.

For Milestone 2, include **2+ Videos/GIFs** of the build process here!<br>
<br>
Step 1: Created recyclerview of coffee list with dark mode and divider features <br>
<img src='https://i.imgur.com/hOrV4Oq.gif' title='Video Demo' width='' alt='Video Demo' /> <br>
Step 2: Added the searching feature for user to search the coffee name <br>
<img src='https://i.imgur.com/YCoYCGd.gif' title='Video Demo' width='' alt='Video Demo' /> <br>

GIF created with **InShot**

## License

Copyright **2023** **Hua Xiao, Mavis Javier, Shraddha Subash, Sydelle Mutabaruka, Pallavi Mekala**

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
