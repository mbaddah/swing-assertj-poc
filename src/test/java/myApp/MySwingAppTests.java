package myApp;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class MySwingAppTests {

    private FrameFixture window;

    @BeforeClass
    public static void setUpOnce() {
        FailOnThreadViolationRepaintManager.install();
    }

    @BeforeEach
    public void setUp() {
        MySwingApp frame = GuiActionRunner.execute( () -> new MySwingApp());
        window = new FrameFixture(frame);
        window.show();
    }

    @Test
    public void assertTitleOfFrame() {
        window.requireTitle("My AssertJ-Swing App");
    }

    @Test
    public void assertUserCanClickSubmitButton() {
        window.button("submitButton").click();
    }

    @Test
    public void assertSubmitButtonText() {
        assertThat(window.button("submitButton").text()).isEqualTo("Submit");

    }

    @Test
    public void assertTextFieldVisibleAndTextEntered() {
        window.textBox("textField").enterText("foo");
        assertThat(window.textBox("textField").text()).isEqualTo("foo");
    }

    @AfterEach
    public void tearDown()  {
        window.cleanUp();
    }
}
