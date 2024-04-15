# Cocktail_Recipe_app

The Cocktail_Recipe_app is an Android application that allows users to search for cocktail recipes by name or ingredient.

## Features
- Search by Name: Users can search for recipes by entering the name of the recipe.
- Search by Ingredient: Users can search for recipes by entering an ingredient.
- View Recipe Details: Users can view detailed information about a recipe, including its ingredients and preparation instructions.
- Save Favorites: Users can save their favorite recipes to access them later.
- Offline Access: The app allows users to access their favorite recipes even when offline.
  
##Getting Started
To get started with the Recipe Finder App, follow these steps:

- Clone the repository to your local machine.
- Open the project in Android Studio.
- Set up the required dependencies and build the project.
- Run the app on an Android emulator or physical device.

## Usage
- Searching for Recipes
- Search by Name: Enter the name of the recipe in the search bar and click the search button.
- Search by Ingredient: Enter the ingredient in the search bar and click the search button.
- Viewing Recipe Details
  Click on a recipe to view its details, including ingredients and preparation instructions.
  Navigate back to the main screen to search for more recipes or access your favorites.
- Saving Favorites
  Click the "Favorites" button to view your saved favorite recipes.
  From the recipe details screen, click the "Favorite" button to save the recipe to your favorites.
## Architecture
The Recipe Finder App follows the Model-View-Controller (MVC) architecture pattern. It consists of the following components:

- Model: Includes data models such as RecipeModel and FavoriteData, representing recipe and favorite data entities, respectively.
- View: Includes activities such as MainActivity, FavoritesActivity, RecipeViewActivity, and SearchActivity, which represent different screens of the app visible to users.
- Controller: Includes asynchronous tasks such as RecipeSearchByNameAsyncTask and RecipeSearchByIngredientAsyncTask, which handle the business logic for searching recipes asynchronously.
