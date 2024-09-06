import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ColumnLabelConverterTest {

    @Test
    fun testSingleLabel() {
        assertArrayEquals(arrayOf("A"), convertToColumnLabels(1, 1))
    }

    @Test
    fun testMultipleLabels() {
        assertArrayEquals(arrayOf("A", "B"), convertToColumnLabels(1, 2))
        assertArrayEquals(arrayOf("Z", "AA", "AB"), convertToColumnLabels(26, 3))
    }

    @Test
    fun testBeyondZZZ() {
        assertThrows<IllegalArgumentException> {
            convertToColumnLabels(17576, 2) // Starting from 17576 (ZZZ), requesting more than 1 result should fail
        }
    }


}
