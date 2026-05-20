# Personal Text Editor – Java Swing Desktop Application

A lightweight desktop-based text editor built using Java Swing that demonstrates core concepts of graphical user interface development, event-driven programming, and state management using data structures. The application provides a clean editing environment with essential text manipulation features including undo/redo, font customization, and file saving functionality.

---

## Overview

This project is a standalone Java Swing application that functions as a basic text editor. It is designed to demonstrate how desktop applications can be built using Java’s standard GUI libraries while applying object-oriented programming principles.

The editor allows users to type and manage text efficiently, customize appearance through font settings, and maintain editing history using stack-based undo and redo functionality.

---

## Features

### Text Editing

* Multi-line text input using `JTextArea`
* Real-time typing with keyboard event tracking
* Clean and minimal dark-themed interface

### Undo and Redo System

* Stack-based undo functionality to restore previous states
* Redo support to reapply undone changes
* Maintains text history during editing sessions

### Font Customization

* Multiple font families including Arial, Consolas, Verdana, Tahoma, and others
* Adjustable font sizes ranging from small to large values
* Instant application of font changes to the editor

### File Operations

* Save text content to a local `.txt` file
* Automatic file creation if it does not exist
* Clears editor after successful save operation

### Text Management

* Clear entire text area with a single click
* Input validation to prevent saving empty content
* Simple and responsive user interaction system

---

## Visual Overview

### UML Class Diagram

The UML diagram below represents the structure, components, and relationships of the application. It was created using PlantUML to clearly show class responsibilities and Swing dependencies.

```markdown id="umlimg"
![UML Class Diagram][(assets/uml-diagram.png)](https://github.com/Jaffer-29/Text-Editor/blob/6c7ace373f681339b5b481d9268993c614b5317f/docs/Architecture/text.png)
```

---

### Application Screenshot

The screenshot below shows the running interface of the Personal Text Editor, including the text area, font controls, and action buttons.

```markdown id="screenshotimg"
![Application Output][(assets/app-screenshot.png)](https://github.com/Jaffer-29/Text-Editor/blob/6c7ace373f681339b5b481d9268993c614b5317f/docs/Output/Editor.png)
```

---

## Architecture

The project consists of two core Java classes:

### RunFrame

* Entry point of the application
* Launches the GUI using `SwingUtilities.invokeLater`
* Ensures thread-safe execution using the Event Dispatch Thread (EDT)

### textEditor

* Main GUI class extending `JFrame`
* Manages all UI components and event handling
* Implements undo/redo functionality using `Stack<String>`
* Handles font customization, text input, and file saving logic

---

## System Design

The application follows an event-driven architecture:

* User interactions are captured using Swing event listeners
* Each text modification is stored in a stack-based history system
* UI components directly reflect changes in application state
* File operations are handled using Java I/O streams

---

## Technology Stack

* Java (JDK 8 or higher)
* Java Swing (GUI development)
* AWT (event handling and graphics support)
* Java I/O (file handling using BufferedWriter and FileWriter)
* Data Structures (Stack for undo/redo system)
* Object-Oriented Programming principles

---

## Project Structure

```
TextEditor/
│
├── RunFrame.java        # Application entry point
├── textEditor.java      # Main GUI and editor logic
│
├── assets/
│   ├── uml-diagram.png  # UML diagram image
│   ├── app-screenshot.png  # Application output screenshot
```

---

## How to Run

### 1. Compile the project

```bash
javac *.java
```

### 2. Run the application

```bash
java RunFrame
```

---

## How It Works

* The application starts from `RunFrame.java`
* The GUI is initialized on the Event Dispatch Thread
* The `textEditor` window is created and displayed
* User input is captured inside the text area
* Each keystroke stores the previous state in an undo stack
* Undo and redo buttons navigate through stored states
* Font selection dynamically updates text appearance
* Save button writes content to a `.txt` file
* Clear button resets the editor

---

## Limitations

* No advanced formatting options (bold, italic, underline)
* No multi-file tab support
* No search and replace functionality
* No autosave feature
* Basic fixed-size UI layout without responsiveness

---

## Future Improvements

* Add open file and “save as” functionality using file chooser
* Implement search and replace feature
* Introduce tab-based multi-document support
* Add autosave functionality
* Improve layout using advanced Swing layout managers
* Add light and dark theme switching

---

## Acknowledgment

This project was developed as a learning exercise inspired by Java Swing tutorials and GUI development concepts.

The implementation has been independently built and extended with additional features such as undo/redo functionality, font customization, and file saving.

---

## Author

Muhammad Jaffer<br>
Personal Text Editor – Java Swing Project
