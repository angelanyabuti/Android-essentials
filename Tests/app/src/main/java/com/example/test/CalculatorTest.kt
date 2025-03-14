package com.example.test

import androidx.activity.ComponentActivity
import androidx.compose.ui.input.key.Key.Companion.Calculator
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class CalculatorTest {

    //Allows us to set the test content and interact with our app inside the test
    //A test class should always have va test rule defined
    @get:Rule
    val rule = createAndroidComposeRule<ComponentActivity>()
    val buttonOne = hasText("1") and hasClickAction()
    val buttonTwo = hasText("2") and hasClickAction()
    val buttonThree = hasText("3") and hasClickAction()
    val buttonFour = hasText("4") and hasClickAction()
    val buttonFive = hasText("5") and hasClickAction()
    val buttonPlus = hasText("+") and hasClickAction()

    //Test annotation indicates that it should be run as a test
    @Test
    fun enterFormula_showFormula() {
        rule.setContent {
            //Calculator()
        }
        //Do something
        //elements on the screen are represented by nodes
        rule.onNode(buttonOne).performClick()
        rule.onNode(buttonPlus).performClick()
        rule.onNode(buttonTwo).performClick()
        rule.onNode(buttonPlus).performClick()
        rule.onNode(buttonThree).performClick()

        //check something
        rule.onNode(hasText("1+2+3")).assertExists()



    }
}