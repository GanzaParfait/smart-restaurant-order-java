# What to write in your notebook (4+ pages)

Copy this by hand. Keep clear headings. When presenting, open the matching folder and run the commands shown.

**Student:** Prince Parfait GANZA  
**Course:** JAVA PROGRAMMING — Object-Oriented Programming  
**Length:** at least 4 notebook pages  

---

## PAGE 1 — Introduction + Classes and Objects

### Title
Object-Oriented Programming in Java

### Introduction
Object-Oriented Programming (OOP) is a programming style that organises software around objects. An object is an instance of a class. A class is a blueprint that describes the data (attributes) and behaviour (methods) of objects.

This report explains five important OOP ideas in Java:
1. Classes and objects
2. Attributes (fields)
3. Methods
4. Access modifiers (public, private, protected, default)
5. Encapsulation using getters and setters

Each idea is supported by a complete Java program that was compiled and run on a PC.

### 1. Classes and Objects
A **class** defines the structure of an object.  
An **object** is created from a class using the `new` keyword.

**Example idea:** a `Student` class can create many student objects, each with its own name and mark.

### 2. Attributes (Fields)
Attributes are variables declared inside a class. They store the state of an object.

Example attributes for a student:
- `name` (String)
- `mark` (int)
- `course` (String)

### 3. Methods
Methods are blocks of code that define what an object can do.

Examples:
- `setDetails(...)` — stores values in the object
- `displayInfo()` — prints student details
- `checkResult()` — decides pass or fail

### Program 1 — Student.java
**Purpose:** show class, objects, attributes and methods.

**Compile and run:**
```
cd 01-classes-objects
javac Student.java
java Student
```

**Output:**
```
--- Student Records ---
Name: Lerato | Mark: 82 | Course: CSSE
Lerato has PASSED.
Name: Prince | Mark: 45 | Course: CSSE
Prince has FAILED.
```

**Brief explanation:**  
`s1` and `s2` are two different objects of the same class. Each object keeps its own data. Methods operate on that data. Lerato passes because 82 >= 50; Prince fails because 45 < 50.

---

## PAGE 2 — Access Modifiers

### 4. Access Modifiers
Access modifiers control where a class member can be used.

| Modifier    | Same class | Same package | Subclass | Everywhere |
|-------------|------------|--------------|----------|------------|
| public      | Yes        | Yes          | Yes      | Yes        |
| protected   | Yes        | Yes          | Yes      | No         |
| default     | Yes        | Yes          | No*      | No         |
| private     | Yes        | No           | No       | No         |

*default: subclass in another package cannot access it.

Meaning in simple words:
- **public** — open to all classes
- **private** — hidden inside its own class only
- **protected** — same package + child classes
- **default** (no keyword) — same package only

### Program 2 — Vehicle, Car, AccessDemo
**Files:**
- `Vehicle.java` — fields with all four modifiers
- `Car.java` — subclass that uses protected/default members
- `AccessDemo.java` — main program

**Compile and run:**
```
cd 02-access-modifiers
javac Vehicle.java Car.java AccessDemo.java
java AccessDemo
```

**Output:**
```
Brand: Toyota | Year: 2022 | Color: Blue | Price: $18500.0
Doors: 4
Public brand from main: Toyota
Protected year from main: 2022
Default color from main: Blue
Private price via getter: $18500.0
```

**Brief explanation:**  
`brand` is public, so main can read it directly.  
`year` is protected and `color` is default; both are visible because `AccessDemo` is in the same package.  
`price` is private, so it cannot be read directly. It is accessed safely with `getPrice()`.

---

## PAGE 3 — Encapsulation (Getters and Setters)

### 5. Encapsulation
Encapsulation means keeping data private and allowing controlled access through public methods called **getters** and **setters**.

Why it is important:
- Protects data from invalid values
- Hides internal details of the class
- Makes programs safer and easier to maintain

**Getter** = method that returns a private field  
**Setter** = method that updates a private field after validation

### Program 3 — BankAccount.java
**Purpose:** hide balance and account details; allow deposit/withdraw only through methods.

**Compile and run:**
```
cd 03-encapsulation
javac BankAccount.java
java BankAccount
```

**Output:**
```
--- Before transactions ---
Holder: Prince Parfait | Account: ACC1001 | Balance: $500.0
Deposited: $200.0
Withdrawn: $100.0
--- After transactions ---
Holder: Prince P. GANZA | Account: ACC1001 | Balance: $600.0
Balance read safely with getter: $600.0
```

**Brief explanation:**  
Starting balance is 500. After deposit (+200) and withdraw (-100), balance becomes 600. The private field `balance` cannot be changed directly from outside the class. This is encapsulation.

---

## PAGE 4 — Summary, Commands Cheat Sheet, Conclusion

### Summary Table

| Concept              | Shown in program      | Key point                                      |
|----------------------|-----------------------|------------------------------------------------|
| Class and object     | Student               | Class = blueprint; object = real instance      |
| Attributes           | Student / Vehicle     | Fields store object data                       |
| Methods              | All programs          | Methods define behaviour                       |
| Access modifiers     | Vehicle / Car         | Control visibility of members                  |
| Encapsulation        | BankAccount           | private fields + getters/setters               |

### Folder on laptop
```
oop-notebook-examples/
  01-classes-objects/Student.java
  02-access-modifiers/Vehicle.java, Car.java, AccessDemo.java
  03-encapsulation/BankAccount.java
```

### How to present (demo order)
1. Open terminal and go to each folder.
2. Compile with `javac ...`
3. Run with `java ...`
4. Point to the matching notebook page while explaining.
5. Mention that all programs compiled and ran successfully.

### Conclusion
Object-Oriented Programming helps developers model real-world things as classes and objects. Attributes store state, methods define behaviour, access modifiers control visibility, and encapsulation protects data. These Java examples show that the same ideas used in theory can be applied in working programs.

### Student details (write at end)
Name: Prince Parfait GANZA  
Programme: Computer Science in Software Engineering (CSSE)  
Assignment: JAVA PROGRAMMING — OOP  

---

## Optional PAGE 5 (if lecturer wants more writing)

### Short code notes (do not copy whole files by hand if time is short)
Write only key lines:

**Student object creation**
```
Student s1 = new Student();
s1.setDetails("Lerato", 82, "CSSE");
```

**Private field + getter**
```
private double balance;
public double getBalance() { return balance; }
```

**Access modifier examples**
```
public String brand;
protected int year;
String color;          // default
private double price;
```

### Personal reflection (2–3 sentences)
Through these programs I practised creating classes, creating objects, protecting fields with private access, and validating data with setters. Compiling and running the programs on my laptop confirmed that the OOP concepts work in real Java applications.
