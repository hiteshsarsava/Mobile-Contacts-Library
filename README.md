# Mobile Contacts Library

This application demonstrates the "MobileContactsLib", The library uses the "ContentResolver", it is a well structured, fast, easy to use and easy to modify library for getting contacts from the mobile. This library requires minimum SDK 16.

Images from the app:

<img src="https://github.com/Jagerfield/Mobile-Contacts-Library/blob/master/Snapshots/Screenshot_ContactList.png" width="240"/> &#160;
<img src="https://github.com/Jagerfield/Mobile-Contacts-Library/blob/master/Snapshots/Screenshot_ContactDetails.png" width="240"/>


## Installation

In the app manifest file add this permission: 

  ```
  <uses-permission android:name="android.permission.READ_CONTACTS" />
  ``` 
In the app build.gradle add the following:

  a. Add JitPack repository at the end of repositories 

```
    repositories {
      maven { url 'https://jitpack.io' }
    }
 ```
 
  b. Then add this dependency
 
```
    dependencies {
	    implementation  "com.github.Jagerfield:Mobile-Contacts-Library:latest_version" //Check release section for latest version
	}
```

#Latest version
[![](https://jitpack.io/v/hiteshsarsava/Mobile-Contacts-Library.svg)](https://jitpack.io/#hiteshsarsava/Mobile-Contacts-Library)

## How to use?
There are two ways to implement this library, the first method is to directly implement it on the main-thread. The library is fast and I didn't ntice any delays.
  1. After instaling the library, declare and instantiate an object of type "ImportContacts" class with "context" as an argument.
  2. Call the getContacts() method to get all the contacts.
  
  ```
    /**
     * Declare and instantiate an object of the "ImportContacts" class
     */
      ImportContacts importContacts = new ImportContacts(context);

    /**
     * Fetch mobile contacts list
     */
      ArrayList<Contact> listItem = importContacts.getContacts();   
  ```
From version v1.8, you can fetch contacts through an Async call.
  
  ```
    new ImportContactsAsync(activity, new ImportContactsAsync.ICallback()
            {
                @Override
                public void mobileContacts(ArrayList<Contact> contactList)
                {
                    //Your code here
                }
            }).execute();
  ```

## Available Contact elements:

  ```
  1. Name: 
    a. Displaydname
    b. Firstname
    c. Lastname
  2. Nickname: 
    a. Nickname
    b. Nicknametype
  3. Number: 
    a. Number
    b. Normalizednumber
    c. Numbertype
  4. Email: 
    a. Email
    b. Emaillabel
    c. Emailtype
  5. Website:
    a. Website
  6. Event:
    a. Eventstartdate
    b. Eventlabel
    c. Eventtype
  7. Note:
    a. Note
  8. Address:
    a. Address
    b. Addresstype
  ```

## UML Diagram

This is a general diagram of the library's architectural design, and it only includes the numbers elements for clarity. 

<img src="https://github.com/Jagerfield/Mobile-Contacts-Library/blob/master/Snapshots/ContactLib_UML.PNG" width="650">

The **Mobile Contact Library** uses the **Android Utilities Library** to manage permissions:

<a href='https://github.com/Jagerfield/Android-Utilities-Library'><img alt='Android Utilities Library' src="https://github.com/Jagerfield/Mobile-Contacts-Library/blob/master/Snapshots/Octocat.png" width="65"/></a> &#160; <a href='https://play.google.com/store/apps/details?id=jagerfield.utilities'><img alt='Get it on Google Play' src='https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png' width="150" height="60"/></a>


## Privacy Policy

This app sample will request the follwoing permission below which require user approval and is used for demonstration purposes only. No data is shared or used outside this app.

* android.permission.READ_CONTACTS
