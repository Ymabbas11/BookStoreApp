# BookStoreApp

BookStoreApp is an Android application designed to provide users with an interactive platform for browsing and managing books. The app includes features for user authentication, book listings, detailed book views, and more.

## Features
- **User Authentication**: Secure login and registration functionality.
- **Book Listings**: Display a collection of books with details such as title, author, and cover image.
- **Book Details**: View detailed information about a specific book.
- **Responsive Design**: Adaptive UI for various screen sizes.

## Project Structure

### Key Directories and Files
- **`app/src/main/java/com/example/bookstoreapp`**:
  - `MainActivity.java`: Entry point of the application.
  - `LoginActivity.java`: Handles user login.
  - `RegisterActivity.java`: Handles user registration.
  - `BookAdapter.java`: Manages the display of books in a list.
  - `BookDetailsActivity.java`: Displays detailed information about a selected book.
- **`app/src/main/res/layout`**:
  - `activity_main.xml`: Layout for the main activity.
  - `activity_login.xml`: Layout for the login screen.
  - `activity_register.xml`: Layout for the registration screen.
  - `item_book.xml`: Layout for displaying individual book items.
- **`app/src/main/AndroidManifest.xml`**:
  - Contains app configuration and permissions.
- **`app/build.gradle`**:
  - Specifies dependencies and project settings.

## Prerequisites
- **Android Studio**: Version 2022.3 or higher.
- **Java SDK**: Version 8 or higher.
- **Gradle**: Pre-configured with the project.

## Getting Started

### Clone the Repository
```bash
git clone https://github.com/your-username/BookStoreApp.git
cd BookStoreApp
```

### Open in Android Studio
1. Open Android Studio.
2. Click on `File > Open`.
3. Navigate to the cloned repository folder and select it.

### Build and Run
1. Ensure you have an Android device/emulator configured.
2. Click `Run > Run 'app'` or press **Shift + F10**.

## Dependencies
The project uses the following dependencies:
- `com.google.firebase:firebase-auth`: For user authentication.
- `com.google.firebase:firebase-database`: For book data management.
- `androidx.appcompat:appcompat`: For compatibility support.
- `com.github.bumptech.glide:glide`: For image loading and caching.

## Contributing
1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch-name`).
3. Commit your changes (`git commit -m 'Add feature'`).
4. Push to the branch (`git push origin feature-branch-name`).
5. Open a pull request.

