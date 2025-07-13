# Ecommerce
Ecommerce_Backend_Application

# Git branch hierarchy
1. Main acts as Staging code that will always have the latest code which can be run anytime without any errors. It will act as UAT source code.
2. Master is the branch which will have latest code whic is running and cannot have any errors ever. It will act as prod code.
3. Version_1.0.0 will act as the first released version of the code. Any error should also not be here.
4. Feature_#.#.# will act as the development branch and can have code with errors.

# Code Promotion Hierachy
Feature_#.#.# ->Version_#.#.# -> Main-> Master
