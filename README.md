# llama_shop

This is an API for llama shops.

[The **Java API** is hosted here.](https://llama-shop.herokuapp.com/)

[A llama accessible **React UI** front end is hosted here.](https://llama-shop-react.herokuapp.com/)

[And you can find the **files for download** here.](https://drive.google.com/drive/folders/1WNq8wnzAjTzelWaxfvWB9Kde7pP9hkkL?usp=sharing)

- `/`: provides the full shop with store/brands, inventory and the recommended order
- `/stores`: provides the available stores/brands
- `/inventory`: provides the available snacks
- `/recommendation`: provides the list of snacks with the maximum total preference within your budget

  `?budget=int&preference=int`
  Are optional parameters that are used in the Knapsack calculation


## Install
#### API
- Download [here](https://drive.google.com/drive/folders/1WNq8wnzAjTzelWaxfvWB9Kde7pP9hkkL?usp=sharing)
- run `gradle build` in snack-shop folder
- run ` java -jar build/libs/llama-snackshop-0.1.0.jar`

#### UI
- Download [here](https://drive.google.com/drive/folders/1WNq8wnzAjTzelWaxfvWB9Kde7pP9hkkL?usp=sharing)
- run `npm install && npm build` in llama-shop-react folder
- run `npm start`

## Recommendation calculation
The best order is calculated using a variation of an unbounded knapsack - the **KnapSnack**. It takes the inventory, a budget and a preference and returns the best possible list of items under budget with the highest total value. The preference score is used as an optional threshold for Snack selection.

Example:
`http://localhost:8080/recommendation?budget=52&preference=4`





##### TO-DO
- Model a llama customer whose preference gets automatically taken into account
- Persist data (extend repository pattern)
- Create interfaces