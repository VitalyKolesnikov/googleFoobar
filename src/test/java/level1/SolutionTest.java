package level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void case1() {
        String actual = Solution.solution("Yvzs! I xzm'g yvorvev Lzmxv olhg srh qly zg gsv xlolmb!!");
        String expected = "Yeah! I can't believe Lance lost his job at the colony!!";

        assertEquals(actual, expected);
    }

    @Test
    void case2() {
        String actual = Solution.solution("wrw blf hvv ozhg mrtsg'h vkrhlwv?");
        String expected = "did you see last night's episode?";

        assertEquals(actual, expected);
    }
}
