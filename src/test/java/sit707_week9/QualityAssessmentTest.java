package sit707_week9;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class QualityAssessmentTest {

    QualityAssessment qa;

    @Before
    public void setUp() {
        qa = new QualityAssessment();
    }

    // Right - correct results for valid inputs

    @Test
    public void testAssessQualitySuccess() {
        assertEquals("Quality assessed", qa.assessQuality("T1", 5));
    }

    @Test
    public void testGetQualityScoreAfterAssessment() {
        qa.assessQuality("T1", 4);
        assertEquals(4, qa.getQualityScore("T1"));
    }

    @Test
    public void testAssessQualityWithZeroPoints() {
        assertEquals("Quality assessed", qa.assessQuality("T1", 0));
    }

    @Test
    public void testGetQualityScoreZero() {
        qa.assessQuality("T1", 0);
        assertEquals(0, qa.getQualityScore("T1"));
    }

    @Test
    public void testAssessQualityOverwritesPrevious() {
        qa.assessQuality("T1", 3);
        qa.assessQuality("T1", 5);
        assertEquals(5, qa.getQualityScore("T1"));
    }

    // Boundary - edge values

    @Test
    public void testAssessQualityMinimumPoints() {
        assertEquals("Quality assessed", qa.assessQuality("T1", 0));
    }

    @Test
    public void testAssessQualityMaximumPoints() {
        assertEquals("Quality assessed", qa.assessQuality("T1", 5));
    }

    @Test
    public void testGetQualityScoreNotAssessed() {
        assertEquals("Not assessed", qa.getQualityScoreLabel("T99"));
    }

    @Test
    public void testAssessQualityMultipleTasks() {
        qa.assessQuality("T1", 5);
        qa.assessQuality("T2", 3);
        assertEquals(5, qa.getQualityScore("T1"));
        assertEquals(3, qa.getQualityScore("T2"));
    }

    // Error - invalid inputs throw exceptions

    @Test(expected = IllegalArgumentException.class)
    public void testAssessQualityNullTaskId() {
        qa.assessQuality(null, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAssessQualityNegativePoints() {
        qa.assessQuality("T1", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAssessQualityExceedsMaxPoints() {
        qa.assessQuality("T1", 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetQualityScoreNullTaskId() {
        qa.getQualityScore(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetQualityScoreLabelNullTaskId() {
        qa.getQualityScoreLabel(null);
    }
}
