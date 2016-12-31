# Mobile Contacts Library

This application demonstrates the "MobileContactsLib", The library uses the "ContentResolver", it is a well structured, fast, easy to use and easy to modify library for getting contacts from the mobile. 

Images from the app:

<img src="https://github.com/Jagerfield/Android-get-phone-book-contact-library/blob/master/Snapshots/Screenshot_ContactList.png" width="240">

<img src="https://github.com/Jagerfield/Android-get-phone-book-contact-library/blob/master/Snapshots/Screenshot_ContactDetails.png" width="240">

## Installation

In the app manifest file add this permission: 

  ```java
  <uses-permission android:name="android.permission.READ_CONTACTS" />
 
  ``` 
In the app build.gradle add the following:

  a. Add JitPack repository at the end of repositories 

    ```java
    repositories {
      maven { url 'https://jitpack.io' }
    }

    ```
  b. Then add this dependency
 
    ```java
    dependencies {
	        compile 'com.github.Jagerfield:Mobile-Contacts-Library:v1.0'
	}
  
    ```

## How to use?

1. After instaling the library, declare and instantiate an object of type "ImportContacts" class with "context" as an argument.
2. Call the getContacts() method to get all the contacts.

  ```java
  /**
   * Declare and instantiate an object of the "ImportContacts" class
   */
    ImportContacts importContacts = new ImportContacts(context);

  /**
   * Fetch mobile contacts list
   */
    ArrayList<Contact> listItem = importContacts.getContacts();
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

<img src="https://github.com/Jagerfield/Android-get-phone-book-contact-library/blob/master/Snapshots/ContactLib_UML.PNG" width="650">