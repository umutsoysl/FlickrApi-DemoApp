# FlickrApi-DemoApp
Android app demonstrating access to Flickr API and display of user data

<img src="/ScreenShot/2.png" width="350" height="600"/>

Introduction
------------
FlickrDemo is an example Android app demonstrating a few technologies together:
  * The Flickr API
  * OAuth to authenticate the user to Flickr
  * A message bus to communicate with fragments
  * Management of remotely loaded images
  * REST with JSON data using Retrofit
  * Automatic testing with the Google-supplied framework
  * Automatic Gradle/Android Studio integration of GitHub repositories that are not packaged in a repo
  
  Attribution
------------
It's impossible to make a complete list of the open source software that this app relies on, but the major top-level libraries and sources include:
  * https://github.com/square/retrofit
  * https://github.com/square/picasso
  * https://github.com/square/otto
  
  
## Setup

1. To get an Flickr API key, visit [https://www.flickr.com/services/apps/create/apply/](https://www.flickr.com/services/apps/create/apply/).

   <img src="http://imgur.com/DmOhVPJ.png"/>

2. Click on Apply for Non-Commercial Key.

3. Fill out a name and description of the app.  Make sure to accept terms of use and click Submit.

4. You should see `Done! Here's the API key and secret for your new app:`.  
     * Set the key value to be the `REST_CONSUMER_KEY`.
     * Set the secret value to be the `REST_CONSUMER_SECRET`.
     
### The Flickr API

Images are retrieved by hitting the [Flickr API](https://www.flickr.com/services/api/flickr.photos.search.html).
- Search Path: https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=FLICKR_API_KEY&tags=SEARCH_TEXT&per_page=25&format=json&nojsoncallback=1
- Response includes an array of photo objects, each represented as:
``` swift
{
    "farm": 8,
    "id": 15981410640,
    "isfamily": 0,
    "isfriend": 0,
    "ispublic": 1,
    "owner": "28339853@N03",
    "secret": "a0d5006167",
    "server": 7564,
    "title": "Chi shark week"
}
```

We use the farm, server, id, and secret to build the image path.
- Image Path: https://farmFARM.staticflickr.com/SERVER/ID_SECRET_m.jpg
- Example: https://farm8.staticflickr.com/7564/15981410640_a0d5006167_m.jpg
- Response object is the image file

### Other Notes

- If you want to quickly test this out you are free to use this demo API key (0461b2b85aee5a025189ce3eed1aff6b), but I recommend replacing with your own API key from Flickr

     
 License
------------
  Copyright (C) 2019 umutsoysl, Inc.
 
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
 
       http://www.apache.org/licenses/LICENSE-2.0
 
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 
    

