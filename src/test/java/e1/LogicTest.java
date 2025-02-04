package e1;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class LogicTest {

  private Logics logic;
  private int gridSize = 5;

  @BeforeEach
  public void initialize() {
    logic = new LogicsImpl(gridSize);
  }

  @Test
  public void isPawnInitializedTest() {
    Pair<Integer,Integer> pawnPosition = logic.getPawnPosition();
    assertEquals(new Pair<Integer,Integer>(pawnPosition.getX(), pawnPosition.getY()), pawnPosition);
  }

  @Test
  public void isKnightInitializedTest() {
    Pair<Integer,Integer> knightPosition = logic.getPawnPosition();
    assertEquals(new Pair<Integer,Integer>(knightPosition.getX(), knightPosition.getY()), knightPosition);
  }

  @Test
  public void doesNotHitOutOfBoundsTest() {
    assertThrows(IndexOutOfBoundsException.class, 
    () -> logic.hit(gridSize + 1, gridSize + 1));
  }

  @Test
  public void pawnAndKnightInDifferentPositionsTest() {
    assertNotEquals(logic.getPawnPosition(), logic.getKnightPosition());
  }

  @Test
  public void isPawnHitTest() {
    Pair<Integer,Integer> pawn = new Pair<Integer,Integer>(0, 0);
    Pair<Integer,Integer> knight = new Pair<Integer,Integer>(1, 2);
    logic = new LogicsImpl(gridSize, pawn, knight);
    assertTrue(logic.hit(pawn.getX(), pawn.getY()));
  }
}
