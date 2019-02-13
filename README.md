# FlickrApi-DemoApp
Android app demonstrating access to Flickr API and display of user data

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

