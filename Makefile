# Compiler and flags
JAVAC=javac
JAVA=java
SRC_DIR=.
BIN_DIR=bin

# Collect all Java source files
SOURCES := $(shell find $(SRC_DIR) -name "*.java")
CLASSES := $(patsubst $(SRC_DIR)/%.java, $(BIN_DIR)/%.class, $(SOURCES))

# Main class
MAIN_CLASS=app/Main

# Compile and run
run: compile
	$(JAVA) -cp $(BIN_DIR) $(MAIN_CLASS)

# Compile all java files into the bin directory
compile:
	mkdir -p $(BIN_DIR)
	$(JAVAC) -d $(BIN_DIR) $(SOURCES)

# Clean class files
clean:
	rm -rf $(BIN_DIR)

.PHONY: run compile clean