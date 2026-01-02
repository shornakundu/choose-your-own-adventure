# Choose-Your-Own-Adventure  

This project is a **text-based Choose-Your-Own-Adventure game**.  
Players navigate an original story by making choices that influence the narrative path and lead to multiple possible endings.

---

## Project Overview
- Text-based interactive story
- Player choices determine the outcome
- Multiple branching paths and endings
- Focus on clean structure, modular code, and user-friendly design

The story is entirely original, though it may reference or be inspired by existing media.

---

## Gameplay Features
- **Start screen** with ASCII / FIGlet-style art introducing the story and controls
- Clear prompts showing valid inputs at every decision point
- Invalid inputs are rejected until the user enters a valid choice
- At least **4 meaningful player choices**
- At least **3 different endings**, depending on decisions made

---

## Programming Concepts Used
This project demonstrates understanding of the first three course units, including:

### Control Structures
- `if` / `else` statements  
- loops (`while`, `for`) for game flow and input validation  

### Methods
- Modular design following the **Single Responsibility Principle**
- Use of parameters, arguments, and return values
- Code reuse to avoid repetition

### Data Structures
At least one structured data type is used, chosen to suit the needs of the program, such as:
- Arrays
- ArrayLists
- HashMaps
- 2D arrays
- Deques  

### File I/O
- Uses file input and/or output to store or retrieve story data, game state, or other information

---

## Program Design
- Organized game loop that controls story progression
- Clear separation between logic, input handling, and story content
- Structured output formatting for readability
- Commenting follows course conventions:
  - Program header
  - Method header comments
  - Inline comments where appropriate

---

## How to Run
1. Open the project in **IntelliJ IDEA**
2. Run `Main.java`
3. Follow the on-screen instructions to begin your adventure

---

## Possible Improvements
- Inventory system
- Player stats
- Randomized outcomes (Possibly using an LLM)
- Dialogue-based interactions
- Enhanced text formatting (e.g., pacing, colours)
- Using a single file, and naming elements in a HashMap
- special characters to split elements
