JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $*.java

CLASSES = \
	Piece.java \
	PieceController.java \
	PieceView.java \
	Puzzle.java \
	PuzzleView.java \
	PuzzleController.java \
	PuzzleSolver.java

default: classes
classes: $(CLASSES:.java=.class)
clean:
	$(RM) *.class