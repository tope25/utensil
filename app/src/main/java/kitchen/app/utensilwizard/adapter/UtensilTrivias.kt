package kitchen.app.utensilwizard.adapter

data class UtensilTrivias(
    val utensilAsk: String,
    val utensilQuestions: List<String>,
    val utensilAnswer: Int
)

val utensilAsk = listOf(
    UtensilTrivias(
        "1.) What is a versatile, all-purpose knife used for chopping, slicing, and dicing various ingredients?",
        listOf("Chef's Knife", "Chainsaw", "Hacksaw"), 0
    ),
    UtensilTrivias(
        "2.) What is a flat surface used as a safe platform for cutting and chopping food?",
        listOf("Blackboard", "Cutting Board", "White Board"), 1
    ),
    UtensilTrivias(
        "3.) What are used for combining and mixing ingredients, especially in baking or preparing salads?",
        listOf("Soup Bowl", "Mixing Bowls", "Super Bowl"), 1
    ),
    UtensilTrivias(
        "4.) What is a flat, wide utensil with a thin edge, used for flipping and turning items like pancakes or eggs in a pan?",
        listOf("Fork", "Spoon", "Spatula/Turner"), 2
    ),
    UtensilTrivias(
        "5.) What are spoons made of wood, suitable for stirring and mixing hot dishes without scratching cookware?",
        listOf("Wooden Spoons", "Wooden Spatula", "Wooden Fork"), 0
    ),
    UtensilTrivias(
        "6.) What is a tool with wire loops used for beating, whipping, and incorporating air into ingredients, especially in baking?",
        listOf("Whisk", "Steering Wheel", "Wire"), 0
    ),
    UtensilTrivias(
        "7.) What are scissor-like utensils with long handles, used for gripping and flipping food items on grills or in pans?",
        listOf("Long Nose", "Tongs", "Scissor"), 1
    ),
    UtensilTrivias(
        "8.) What is a bowl-shaped strainer with perforations, used for draining water from pasta, vegetables, or fruits?",
        listOf("Mixing Bowls", "Pot", "Colander"), 2
    ),
    UtensilTrivias(
        "9.) What tools are used for precise measurement of ingredients in specific quantities, crucial for accurate cooking and baking?",
        listOf("Tape Measure", "Measuring Cups and Spoons", "Tongs"), 1
    ),
    UtensilTrivias(
        "10.) What is a tool designed to remove the outer skin of fruits and vegetables, making them easier to handle and consume?",
        listOf("Peeler", "Mixing Bowls", "Chef's Knife"), 0
    ),
    UtensilTrivias(
        "11.) What is a device used to open sealed cans by puncturing and removing the lid, exposing the contents inside?",
        listOf("Can Opener", "Tongs", "Peeler"), 0
    ),
    UtensilTrivias(
        "12.) What is a deep-bowled spoon with a long handle, used for serving soups, stews, and sauces?",
        listOf("Whisk", "Ladle", "Tongs"), 1
    ),
    UtensilTrivias(
        "13.) What is a cylindrical tool used to flatten and shape dough for baking purposes?",
        listOf("Ruler", "Rolling Pin", "Roller"), 1
    ),
    UtensilTrivias(
        "14.) What is a tool with sharp-edged perforations, used for grating cheese, vegetables, or fruits?",
        listOf("Greater", "Great", "Grater"), 2
    ),
    UtensilTrivias(
        "15.) What are scissors designed for kitchen use, helpful for tasks like cutting herbs, poultry, and more?",
        listOf("Chef's Knife", "Nail Cutter", "Kitchen Shears"), 2
    ),
)
