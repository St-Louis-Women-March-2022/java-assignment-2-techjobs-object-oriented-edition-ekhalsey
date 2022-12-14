package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;
import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job testJob1 = new Job();
        Job testJob2 = new Job();
        assertNotEquals(testJob1.getId(),testJob2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(testJob.getName() instanceof String);
        assertEquals("Product tester", testJob.getName());
        assertEquals("ACME", testJob.getEmployer().toString());
        assertEquals("Desert", testJob.getLocation().toString());
        assertEquals("Quality control", testJob.getPositionType().toString());
        assertEquals("Persistence", testJob.getCoreCompetency().toString());
    }

    @Test
    public void testJobsForEquality() {
        Job test1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(test1.equals(test2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String returnString = testJob.toString();
        assertEquals('\n', testJob.toString().charAt(0));
        assertEquals('\n', returnString.charAt(returnString.length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String returnString = testJob.toString();
        System.out.println(returnString);
        assertTrue(returnString.contains("ID: " + testJob.getId()));
        assertEquals("Name: Product tester", "Name: " + testJob.getName());
        assertEquals("Employer: ACME", "Employer: " + testJob.getEmployer());
        assertEquals("Location: Desert","Location: " + testJob.getLocation());
        assertEquals("Position Type: Quality control","Position Type: " + testJob.getPositionType());
        assertEquals("Core Competency: Persistence", "Core Competency: " + testJob.getCoreCompetency());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob = new Job("Product tester", new Employer(""), new Location(""), new PositionType("Quality control"), new CoreCompetency(null));
        String returnString = testJob.toString();
        assertTrue(returnString.contains("ID: " + testJob.getId()));
        assertEquals("Name: Product tester", "Name: " + testJob.getName());
        assertEquals("Employer: Data not available", "Employer: " + testJob.getEmployer());
        assertEquals("Location: Data not available", "Location: " + testJob.getLocation());
        assertEquals("Position Type: Quality control","Position Type: " + testJob.getPositionType());
        assertEquals("Core Competency: Data not available", "Core Competency: " + testJob.getCoreCompetency());
    }
}